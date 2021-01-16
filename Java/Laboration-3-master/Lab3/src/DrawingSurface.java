import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class DrawingSurface extends JPanel{
	
	private Model model = new Model();

	public DrawingSurface () {
		
		this.setBackground(Color.white);		
		this.addMouseListener(new Listener(model, getDrawingSurface()));		
		this.setVisible(true);
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		for (Shape c : model.getLista()) {
			c.paintComponent(g);
		}
		// TODO: Komplettering: Använd inte repaint() här.
		
	}

	public Model getModell() {
		return model;
	}
	
	public DrawingSurface getDrawingSurface() {
		return this;
	}
	
	
}
