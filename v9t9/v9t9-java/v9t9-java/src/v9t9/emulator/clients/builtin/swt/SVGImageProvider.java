/**
 * 
 */
package v9t9.emulator.clients.builtin.swt;

import java.util.TreeMap;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.ejs.coffee.core.utils.Pair;

import v9t9.emulator.clients.builtin.swt.ImageIconCanvas.IImageBar;

/**
 * @author ejs
 *
 */
public class SVGImageProvider extends MultiImageSizeProvider {

	private final SVGLoader svgIcon;
	private Thread loadIconThread;
	
	private Point desiredSize;
	private Image scaledImage;
	private boolean svgFailed;
	
	/**
	 * @param iconMap
	 */
	public SVGImageProvider(TreeMap<Integer, Image> iconMap, SVGLoader svgIcon) {
		super(iconMap);
		this.svgIcon = svgIcon;
	}
	

	/* (non-Javadoc)
	 * @see v9t9.emulator.clients.builtin.swt.MultiImageSizeProvider#getImage(org.eclipse.swt.graphics.Point)
	 */
	@Override
	public Pair<Double, Image> getImage(final Point size, final IImageBar imageBar) {
		boolean recreate = false;
		if (scaledImage == null || !size.equals(desiredSize)) {
			/*if (loadIconJob != null) {
				loadIconJob.cancel();
				try {
					loadIconJob.join();
				} catch (InterruptedException e) {
				}
			}*/
			if (loadIconThread == null)
				recreate = true;
		}
		if (!svgFailed && recreate) {
			desiredSize = size;
			if (scaledImage != null)
				scaledImage.dispose();
			scaledImage = null;
			loadIconThread = new Thread("Scaling icon") {

				public void run() {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e1) {
						return;
					}
					final ImageData scaledImageData;
					try {
						//int min = iconMap.values().iterator().next().getBounds().width;
						Point scaledSize = new Point(size.x, size.y);
						Point svgSize = svgIcon.getSize();
						if (imageBar.isHorizontal())
							scaledSize.y = size.y * svgSize.y / svgSize.x;
						else
							scaledSize.x = size.x * svgSize.x / svgSize.y;
						
						long start = System.currentTimeMillis();
						
						scaledImageData = svgIcon.getImageData(scaledSize);
						long end = System.currentTimeMillis();
						System.out.println("Loaded " + svgIcon.getFileName() + " @ " + scaledSize + ": " + (end - start) + " ms");
						svgFailed = false;
						
						final Composite composite = imageBar.getComposite();
						
						if (!composite.isDisposed()) {
							composite.getDisplay().asyncExec(new Runnable() {
								public void run() {
									if (!composite.isDisposed()) {
										scaledImage = new Image(composite.getDisplay(), scaledImageData);
										System.out.println("Got image " + scaledImage.getBounds());
										imageBar.redrawAll();
									}
								}
							});
						}
					} catch (SVGException e) {
						svgFailed = true;
					}
					loadIconThread = null;
					
				}
				
			};
			loadIconThread.start();
		}
		if (scaledImage == null) {
			return super.getImage(size, imageBar);
		}
		else {
			int min = iconMap.values().iterator().next().getBounds().width;
			double ratio = (double) scaledImage.getBounds().width / min;
			//System.out.println("Using svg image " + scaledImage.getBounds() + " at " +ratio);
			return new Pair<Double, Image>(ratio, scaledImage);
		}
		
	}
}
