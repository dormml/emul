/**
 * 
 */
package v9t9.video;

import v9t9.common.video.RedrawBlock;
import v9t9.video.common.VdpModeInfo;



/**
 * @author ejs
 *
 */
public class BlankModeRedrawHandler extends BaseRedrawHandler implements
		IVdpModeRedrawHandler {

	public BlankModeRedrawHandler(VdpRedrawInfo info, VdpModeInfo modeInfo) {
		super(info, modeInfo);
		
		info.touch.patt = null;
		info.touch.sprite = info.touch.sprpat = null;
		info.touch.screen = null;
		info.touch.color = null;
	}

	/* (non-Javadoc)
	 * @see v9t9.emulator.clients.builtin.InternalVdp.VdpModeRedrawHandler#propagateTouches()
	 */
	public void prepareUpdate() {
		
	}

	/* (non-Javadoc)
	 * @see v9t9.emulator.clients.builtin.InternalVdp.VdpModeRedrawHandler#updateCanvas(v9t9.emulator.clients.builtin.VdpCanvas, v9t9.emulator.clients.builtin.InternalVdp.RedrawBlock[])
	 */
	public int updateCanvas(RedrawBlock[] blocks) {
		/*if (force) {
			for (int i = 0; i < 768; i++) {
				blocks[i].r = (i / 32) * 8;
				blocks[i].c = (i % 32) * 8;
			}
			return 768;
		}*/
		return 0;
	}
}