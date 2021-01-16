import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public abstract class Shape extends JComponent {

	private int x;
	private int y;
	private Color c;

	public Shape(int x, int y, Color c) {
		this.x = x;
		this.y = y;
		this.setC(c);
	}

	public abstract void paintComponent(Graphics g);

	public abstract void putColor(Color c);

	public Color getC() {
		return c;
	}

	public void setC(Color c) {
		this.c = c;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}


