package v9t9.emulator.clients.builtin.video;

import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Rectangle;

public abstract class ImageDataCanvas extends VdpCanvas {

	protected ImageData imageData;

	public ImageDataCanvas() {
		super();
	}

	public ImageData getImageData() {
		return imageData;
	}

	@Override
	public int getLineStride() {
		return imageData.bytesPerLine;
	}



	@Override
	public void doChangeSize() {
		imageData = createImageData();
	}

	abstract protected ImageData createImageData();

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public int getWidth() {
		return width;
	}

	/** Map the image generated by ImageData to something renderable */
	public Rectangle mapVisible(Rectangle logical) {
		return new Rectangle(logical.x, logical.y, logical.width, logical.height);
	}

}