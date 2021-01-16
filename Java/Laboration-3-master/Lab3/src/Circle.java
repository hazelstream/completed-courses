import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape{
	
	// TODO: Komplettering: x,y och c finns redan i superklassen sw de skall inte
	// deklareras i subklassen igen. Se över samtliga subklasser.
	//private int x;
	//private int y;
	//private Color c;
	
	public Circle(int x, int y, Color c) {
		super(x, y, c);
		//this.x = x;
		//this.y = y;
		//this.c = c;
	}
	
	public void paintComponent (Graphics g) {
		g.setColor(getC());
		g.fillOval(getX(), getY(), 30, 30);
	
	}	
	
	public void putColor(Color c) {
		this.setC(c);
	}
}
