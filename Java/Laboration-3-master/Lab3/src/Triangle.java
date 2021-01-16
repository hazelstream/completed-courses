import java.awt.Color;
import java.awt.Graphics;

public class Triangle extends Shape {

	/*
	 * private int x; private int y; private Color c;
	 */

	public Triangle(int x, int y, Color c) {
		super(x, y, c);
		/*
		 * this.x = x; this.y = y; this.c = c;
		 */
	}

	@Override
	public void paintComponent(Graphics g) {
		int xpoints[] = {getX() + 15, getX(), getX() + 30};
	    int ypoints[] = {getY(), getY() + 30, getY() + 30};
	    int npoints = xpoints.length;
		
	    g.setColor(getC());
		g.fillPolygon(xpoints, ypoints, npoints);
		
	}

	@Override
	public void putColor(Color c) {
		this.setC(c);

	}
}