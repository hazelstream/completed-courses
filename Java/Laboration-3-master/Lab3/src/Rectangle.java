import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape {
	
	/*
	 * private int x; private int y; private Color c;
	 */

	public Rectangle(int x, int y, Color c) {
		super(x, y, c);
		/*
		 * this.x = x; this.y = y; this.c = c;
		 */	
	}

	@Override
	public void paintComponent(Graphics g) {
		g.setColor(getC());
		g.fillRect(getX(), getY(), 30, 30);
		
	}

	@Override
	public void putColor(Color c) {
		this.setC(c);

	}

}
