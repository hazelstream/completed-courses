import java.awt.Color;
import java.util.ArrayList;

public class Model {

	private ArrayList<Shape> lista = new ArrayList<>();
	private Color color = Color.black;
	private int val = 1;


	public Model() {
	}

	public void addShape(int x, int y) {
		Shape c = null;		
		if(val == 1) {
			c = new Circle(x, y, color);
		}
		else if (val == 2) {
			c = new Rectangle(x, y, color);
		}
		else if (val == 3) {
			c = new Triangle(x, y, color);
		}
		

		lista.add(c);
	}

	public void putColor(Color c) {
		// this.c.putColor(c);
		color = c;
	}

	public void setShape(int i) {
		val = i;
	}

	public ArrayList<Shape> getLista() {
		return lista;
	}

	public void clearList() {
		lista = new ArrayList<>();
	}
	
	public Color getColor() {
		return color;
	}
}






