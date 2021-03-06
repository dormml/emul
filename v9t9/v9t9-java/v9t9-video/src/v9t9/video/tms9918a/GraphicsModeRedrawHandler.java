/*
  GraphicsModeRedrawHandler.java

  (c) 2008-2014 Edward Swartz

  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
 */
package v9t9.video.tms9918a;

import java.util.Arrays;

import v9t9.common.video.RedrawBlock;
import v9t9.video.BaseRedrawHandler;
import v9t9.video.IVdpModeBlockRedrawHandler;
import v9t9.video.IVdpModeRowRedrawHandler;
import v9t9.video.VdpRedrawInfo;
import v9t9.video.VdpTouchHandler;
import v9t9.video.common.VdpModeInfo;

/**
 * Redraw graphics mode content
 * @author ejs
 *
 */
public class GraphicsModeRedrawHandler extends BaseRedrawHandler 
	implements IVdpModeBlockRedrawHandler, IVdpModeRowRedrawHandler {

	protected VdpTouchHandler modify_color_graphics = new VdpTouchHandler() {
	
		public void modify(int offs) {
			int ptr = offs << 3;
			Arrays.fill(info.changes.patt, ptr, ptr + 8, (byte)1);
			info.changes.changed = true;			
		}
		
	};

	public GraphicsModeRedrawHandler(VdpRedrawInfo info, VdpModeInfo modeInfo) {
		super(info, modeInfo);
		info.touch.screen = modify_screen_default;
		info.touch.color = modify_color_graphics;
		info.touch.patt = modify_patt_default;
	}
	
	public void prepareUpdate() {
		propagatePatternTouches();
	}
	
	public int updateCanvas(RedrawBlock[] blocks) {
		/*  Redraw changed chars  */
		int count = 0;
		int screenBase = modeInfo.screen.base;
		
		int minY = info.canvas.getMinY();
		int maxY = info.canvas.getMaxY();
		
		for (int i = info.changes.screen.nextSetBit(0); 
			i >= 0 && i < modeInfo.screen.size; 
			i = info.changes.screen.nextSetBit(i+1)) 
		{
			int currchar = info.vdp.readAbsoluteVdpMemory(screenBase + i) & 0xff;

			RedrawBlock block = blocks[count++];
			
			block.r = (i >> 5) << 3;	/* for graphics mode */
			if (block.r + 8 < minY || block.r >= maxY)
				continue;
			
			block.c = (i & 31) << 3;
			byte color = (byte) info.vdp.readAbsoluteVdpMemory(modeInfo.color.base + (currchar >> 3));

			byte fg, bg;
			
			bg = (byte) (color & 0xf);
			fg = (byte) ((color >> 4) & 0xf);
			
			info.canvas.draw8x8TwoColorBlock(block.r, block.c, info.vdp.getByteReadMemoryAccess((modeInfo.patt.base + (currchar << 3))), fg, bg); 
		}
		return count;
	}
	
	/* (non-Javadoc)
	 * @see v9t9.video.IVdpModeRowRedrawHandler#getCharsPerRow()
	 */
	@Override
	public int getCharsPerRow() {
		return 32;
	}

	/* (non-Javadoc)
	 * @see v9t9.video.IVdpModeRowRedrawHandler#updateCanvas(int, int)
	 */
	@Override
	public void updateCanvasRow(int row, int col) {
//		System.out.println("graphics: " + prevScanline + " - " + currentScanline);
		int screenBase = modeInfo.screen.base;
		
		int roffs = (row >> 3) << 5;
		for (int c = 0; c < 32; c++) {
			int i = roffs + c;
			if (!info.changes.screen.get(i)) 
				continue;
			
			int currchar = info.vdp.readAbsoluteVdpMemory(screenBase + i) & 0xff;

			byte color = (byte) info.vdp.readAbsoluteVdpMemory(modeInfo.color.base + (currchar >> 3));

			byte fg, bg;
			
			bg = (byte) (color & 0xf);
			fg = (byte) ((color >> 4) & 0xf);
			
			int offs = info.canvas.getBitmapOffset(c * 8, row);
			int pattAddr = (row & 7) + (modeInfo.patt.base + (currchar << 3));
			info.canvas.drawEightPixels(
					offs, info.vdp.readAbsoluteVdpMemory(pattAddr), 
					fg, bg);
		}
	}
	
	/* (non-Javadoc)
	 * @see v9t9.video.IVdpModeRowRedrawHandler#updateCanvasBlockRow(int)
	 */
	@Override
	public void updateCanvasBlock(int screenOffs, int col, int row) {
		int screenBase = modeInfo.screen.base;
		int pattBase = modeInfo.patt.base;
		
		int currchar = info.vdp.readAbsoluteVdpMemory(screenBase + screenOffs) & 0xff;

		byte color = (byte) info.vdp.readAbsoluteVdpMemory(modeInfo.color.base + (currchar >> 3));

		byte fg, bg;
		
		bg = (byte) (color & 0xf);
		fg = (byte) ((color >> 4) & 0xf);
		
		int pattOffs = pattBase + (currchar << 3);
		info.canvas.draw8x8TwoColorBlock(row, col, 
				info.vdp.getByteReadMemoryAccess(pattOffs), fg, bg);
	}
}
