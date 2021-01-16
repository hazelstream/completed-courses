import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Listener implements MouseListener {
	
	private Model model;
	private DrawingSurface d;

	public Listener(Model model, DrawingSurface d) {
		this.model = model;
		this.d = d;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Vi klickade i komponenten! på " +
				e.getX() + "," + e.getY());
		model.addShape(e.getX() - 15, e.getY() - 15);
		d.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
