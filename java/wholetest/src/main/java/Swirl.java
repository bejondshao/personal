/******************************************************************************
 *  Compilation:  javac Swirl.java
 *  Execution:    java Swirl filename
 *
 *  Swirl image.
 *
 *  % java Swirl baboon.jpg
 *
 ******************************************************************************/

public class Swirl {

	public static void main(String[] args) {
		Picture pic1 = new Picture(args[0]);
		pic1.show();
		int width  = pic1.width();
		int height = pic1.height();
		double x0 = 0.5 * (width  - 1);
		double y0 = 0.5 * (height - 1);

		Picture pic2 = new Picture(width, height);

		// swirl
		for (int sx = 0; sx < width; sx++) {
			for (int sy = 0; sy < height; sy++) {
				double dx = sx - x0;
				double dy = sy - y0;
				double r = Math.sqrt(dx*dx + dy*dy);
				double angle = Math.PI / 256 * r;
				int tx = (int) (+dx * Math.cos(angle) - dy * Math.sin(angle) + x0);
				int ty = (int) (+dx * Math.sin(angle) + dy * Math.cos(angle) + y0);

				// plot pixel (sx, sy) the same color as (tx, ty) if it's in bounds
				if (tx >= 0 && tx < width && ty >= 0 && ty < height)
					pic2.set(sx, sy, pic1.get(tx, ty));
			}
		}

		pic2.show();
	}



}