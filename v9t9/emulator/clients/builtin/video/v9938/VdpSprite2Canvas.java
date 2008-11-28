/**
 * 
 */
package v9t9.emulator.clients.builtin.video.v9938;

import v9t9.emulator.clients.builtin.video.MemoryCanvas;
import v9t9.emulator.clients.builtin.video.VdpCanvas;
import v9t9.emulator.clients.builtin.video.VdpSprite;
import v9t9.emulator.clients.builtin.video.tms9918a.VdpSpriteCanvas;
import v9t9.engine.memory.ByteMemoryAccess;

/**
 * For Sprite 2 mode, we use a different strategy for managing sprites.
 * <p>
 * First, the "color + early clock" byte in the sprite attribute table
 * is not used.
 * <p>
 * Instead, a sprite color table is implicitly located
 * 512 bytes in front of the sprite attribute table.  Each entry is 16
 * bytes long and specifies attributes for each row of the sprite.
 * The color and early clock are moved here. 
 * A new flag allows for "canceling priority" on sprites, which effectively
 * means allowing them to OR with each other and not detect collisions.
 * <p>
 * The base {@link VdpSpriteCanvas} will draw sprites directly to the
 * final screen canvas, meaning we cannot do such OR'ing because we can't
 * distinguish existing screen pixels from sprite pixels (to avoid
 * OR'ing with the background).  Not to mention, the format of the 
 * screen canvas may have lost the original color code information.
 * Similarly, this makes collision detection difficult.
 * <p>
 * This sprite canvas, then, maintains its own independent rendering canvas
 * for the sprites.  All sprites' dirtyings and drawings are performed on
 * a static 256xN bitmap, where we can track the pixels properly.
 * <p>
 * In the final "drawing" call, we draw the sprites into their own canvas
 * and then blit this on top of the screen canvas.
 * <p>
 * This approach requires that we modify our interpretation of how dirtying
 * interacts.  Now, when a screen block changes, this doesn't mean the sprite
 * over it is dirty -- but it does mean that sprite's corresponding block
 * must be reblitted.  The other dirtying changes (sprite movement -> screen
 * change) still apply, though.
 * @author ejs
 *
 */
public class VdpSprite2Canvas extends VdpSpriteCanvas {

	private MemoryCanvas spriteCanvas;
	/** which screen changes there were, requiring sprite reblits */
	private byte[] screenSpriteChanges;

	public VdpSprite2Canvas(VdpCanvas canvas, int maxPerLine) {
		super(canvas, maxPerLine);
		this.spriteCanvas = new MemoryCanvas();
		spriteCanvas.setClearColor(0);
		spriteCanvas.setSize(256, canvas.getHeight());
		screenSpriteChanges = null;
	}
	
	@Override
	protected void updateSpriteBitmapForScreenChanges(VdpCanvas screenCanvas,
			byte[] screenChanges) {
		screenSpriteChanges = screenChanges;
		
		// no changes to screen can affect sprites here
	}

	@Override
	public void drawSprites(VdpCanvas canvas) {
		//spriteCanvas.clear(null);
		// clear the blocks where the sprites are moving
		//int cleared = 0;
		for (int i = 0; i < spritebitmap.length; i++) {
			if ((spritebitmap[i] & knowndirty) != 0) {
				int offset = spriteCanvas.getBitmapOffset(i % 32 * 8, i / 32 * 8);
				spriteCanvas.clear8x8Block(offset);
				//cleared++;
			}
		}
		//System.out.print(cleared +" cleared; ");
		super.drawSprites(spriteCanvas);
		blitSpriteCanvas(canvas);
	}

	
	/**
	 * Draws an 8x8 sprite character
	 * @param y
	 * @param x
	 * @param shift the early clock shift (usu. 0 or -32)
	 * @param rowbitmap a map of the rows which should be drawn, based on sprite priority
	 * and N-sprites-per-line calculations.  The LSB corresponds to the top row.
	 * @param pattern the sprite's pattern
	 * @param attr the row attribute table
	 * @param doubleWidth is the sprite drawn double-wide?
	 */
	private void drawSpriteChar(VdpCanvas canvas, int y, int x, int rowbitmap, ByteMemoryAccess pattern,
			ByteMemoryAccess attr, boolean magnified, boolean doubleWidth) {
		
		int pixy = 0;
		for (int yy = 0; yy < 8; yy++) {
			if (y >= canvas.getHeight())
				continue;
			
			byte attrb = attr.memory[attr.offset + yy];
			int shift = (attrb & 0x80) != 0 ? -32 : 0;
			if (x + shift + 8 <= 0)
				continue;
			byte color = (byte) (attrb & 0xf);
			if (color == 0 && !canvas.isClearFromPalette())
				continue;
			
			short bitmask = -1;
			if (!magnified) {
				if (x + shift < 0) {
					bitmask &= 0xff >> (x + shift);
				} else if (x + shift + 8 > 256) {
					bitmask &= 0xff << ((x + shift + 8) - 256);
				}
			} else {
				if (x + shift < 0) {
					bitmask &= 0xffff >> (x + shift);
				} else if (x + shift + 16 > 256) {
					bitmask &= 0xffff << ((x + shift + 16) - 256);
				}
			}
			
			boolean isLogicalOr = (attrb & 0x40) != 0;
			byte patt = 0;
			for (int iy = 0; iy < (magnified ? 2 : 1); iy++) {
				if ((rowbitmap & (1 << pixy)) != 0) {
					patt = pattern.memory[pattern.offset + yy];
					if (patt != 0) {
						int block = canvas.getBitmapOffset((x + shift) * (doubleWidth ? 2 : 1), y);
						if (magnified && doubleWidth)
							canvas.drawEightDoubleMagnifiedSpritePixels(block, patt, color, bitmask, isLogicalOr);
						else if (doubleWidth || magnified)
							canvas.drawEightMagnifiedSpritePixels(block, patt, 
									color, bitmask, isLogicalOr);
						else
							canvas.drawEightSpritePixels(block, patt, 
									color, (byte) bitmask, isLogicalOr);
					}
				}
				pixy++;
				y = (y + 1) & 0xff;
			}
		}
	}

	protected void drawSprite(VdpCanvas canvas, VdpSprite sprite) {
		if (sprite.isDeleted())
			return;
		
		ByteMemoryAccess colors = new ByteMemoryAccess(sprite.getColorStripe());
		boolean doubleWidth = canvas.getWidth() == 512;
		
		int x = sprite.getX();
		int y = sprite.getY();
		int sprrowbitmap = sprite.getSprrowbitmap();
		ByteMemoryAccess tmpPattern = new ByteMemoryAccess(sprite.getPattern());
		
		boolean ismag = (sprite.getSize() == 16 && sprite.getNumchars() == 1)
			|| sprite.getSize() == 32;
		int magfac = ismag ? 2  : 1;
		
		for (int c = 0; c < sprite.getNumchars(); c++) {
			int rowshift = charshifts[c*2];
			int colshift = charshifts[c*2+1];
			drawSpriteChar(canvas, y + rowshift * magfac, x + colshift * magfac, 
						sprrowbitmap >> (rowshift * magfac), tmpPattern, colors, ismag, doubleWidth);
			tmpPattern.offset += 8;
			colors.offset += 16;
		}
	}
	
	protected void blitSpriteCanvas(VdpCanvas screenCanvas) {
		// where the screen changed, we need to draw our sprite blocks
		int blockStride = screenCanvas.getWidth() / 8;
		int blockMag = blockStride / 32;
		int blockCount = 32 * screenCanvas.getHeight() / 8;
		int screenOffs = 0;
		//RedrawBlock[] blocks = new RedrawBlock[screenCanvas.getBlockCount()];
		//int blockidx = 0;
		for (int i = 0; i < blockCount; i += 32) {
			for (int j = 0; j < 32; j++) {
				if (screenSpriteChanges[screenOffs + j * blockMag] != 0 
					|| (blockMag > 1 && screenSpriteChanges[screenOffs + j * blockMag + 1] != 0)) {
					/*
					blocks[blockidx++] = block;
					block.r = i / 32 * 8;
					block.c = j * blockMag;
					block.w = blockMag * 8;
					block.h = 8;
					 */
					screenCanvas.blitSpriteBlock(spriteCanvas, j * 8, i / 32 * 8, blockMag);
				}
			}
			screenOffs += blockStride;
		}
		//System.out.println(blockidx + " dirty from sprites");
		//screenCanvas.markDirty(blocks, blockidx);
	}
}