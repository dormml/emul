/*
  RGB221MapColor.java

  (c) 2016 Edward Swartz

  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
 */
package v9t9.video.imageimport;

import java.util.TreeMap;

import org.ejs.gui.images.ColorMapUtils;
import org.ejs.gui.images.V99ColorMapUtils;

class RGB221MapColor extends RGBDirectMapColor {

	static private TreeMap<Integer, byte[]> map;

	public RGB221MapColor(boolean isGreyscale) {
		super(createStock221Palette(), 0, 32, isGreyscale);
	}
	/** Get the 8-bit RGB values from a packed 2-2-1 GRB byte */
	private static void getGRB221(byte[] rgb, byte grb, boolean isGreyscale) {
		int g = (grb >> 3) & 0x3;
		int r = (grb >> 1) & 0x3;
		int b = grb & 0x1;
		rgb[0] = V99ColorMapUtils.rgb2to8[r];
		rgb[1] = V99ColorMapUtils.rgb2to8[g];
		rgb[2] = V99ColorMapUtils.rgb1to8[b];
		if (isGreyscale) {
			ColorMapUtils.rgbToGrey(rgb, rgb);
		}
	}
	
	private static byte[][] createStock221Palette() {
		byte[][] pal = new byte[32][];
		for (int i = 0; i < 32; i++) {
			 byte[] rgb = { 0, 0, 0 };
			 getGRB221(rgb, (byte) i, false);
			 pal[i] = rgb;
		}
		return pal;
	}

	/** Get the RGB triple for the 221 GRB. */
	private static byte[] getGRB221(int g, int r, int b) {
		return new byte[] { 
				V99ColorMapUtils.rgb2to8[r&0x3], 
				V99ColorMapUtils.rgb2to8[g&0x3],
				V99ColorMapUtils.rgb1to8[b&0x1] };
	}

	protected byte[] getRGB221(int r, int g, int b) {
		byte[] rgbs = getGRB221(g, r, b);
		if (isColorMappedGreyscale) {
			rgbs = getRgbToGreyForGreyscaleMode(rgbs);
		}
			
		return rgbs;
	}
	
	@Override
	public int mapColor(int pixel, int[] dist) {
		int r = ((pixel & 0xff0000) >>> 16) >>> 6;
		int g = ((pixel & 0x00ff00) >>>  8) >>> 6;
		int b = ((pixel & 0x0000ff) >>>  0) >>> 7;
		
		byte[] rgbs = getRGB221(r, g, b);
		
		if (isColorMappedGreyscale)
			dist[0] = ColorMapUtils.getRGBLumDistance(rgbs, pixel);
		else
			dist[0] = ColorMapUtils.getRGBDistance(rgbs, pixel);

		int c = (g << 3) | (r << 1) | b;
		return c;
	}

	/* (non-Javadoc)
	 * @see v9t9.emulator.clients.builtin.video.ImageImport.IMapColor#getClosestPaletteColor(int[])
	 */
	@Override
	public int getClosestPaletteEntry(int pixel) {
		// we don't need to trawl the palette here
		if (isColorMappedGreyscale) {
			pixel = getPixelForGreyscaleMode(pixel);
		}
		
		int r = ((pixel & 0xff0000) >>> 16) >>> 6;
		int g = ((pixel & 0x00ff00) >>>  8) >>> 6;
		int b = ((pixel & 0x0000ff) >>>  0) >>> 7;
		return (g << 3) | (r << 1) | b;
	}
	
	/* (non-Javadoc)
	 * @see v9t9.emulator.clients.builtin.video.image.BasePaletteMapper#getMinimalPaletteDistance()
	 */
	@Override
	public int getMinimalPaletteDistance() {
		return 0x40 * 0x40 * 2 + 0x80 * 0x80;
	}
	
	/* (non-Javadoc)
	 * @see org.ejs.gui.images.IPaletteMapper#getGreyToRgbMap()
	 */
	@Override
	public TreeMap<Integer, byte[]> getGreyToRgbMap() {
		if (map == null) {
			map = new V99ColorMapUtils.GreyRgbMapper(2, 2, 1).create();
		}
		return map;
	}
	
	/* (non-Javadoc)
	 * @see org.ejs.gui.images.IDirectColorMapper#mapDirectColor(byte[], byte)
	 */
	@Override
	public void mapDirectColor(byte[] rgb, byte c) {
		getGRB221(rgb, (byte) c, false);
	}
}