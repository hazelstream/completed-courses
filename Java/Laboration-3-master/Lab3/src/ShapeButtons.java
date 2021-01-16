import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JComponent;

public class ShapeButtons extends JComponent {

	private Model model;
	private int y = 10;
	private ArrayList<Integer> shapes = new ArrayList<>();

	int xpoints[] = {15, 0, 30};
	int ypoints[] = {60, 90, 90};
	int npoints = xpoints.length;

	public ShapeButtons(Model model) {
		this.model = model;
		Collections.addAll(shapes, 1, 2, 3);
		
	

		this.addMouseListener(new MouseListener(){
			// Kommentar: Går det att lösa detta på likanande sätt som i färgvalen.
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("Vi klickade i färgkomponenten! på " +
						e.getX() + "," + e.getY());

				for(int i = 0; i < shapes.size(); ++i) {
					if(e.getY() >= i * 30 && e.getY() <= (i + 1) * 30) {
						model.setShape(shapes.get(i));
						y = 10 + (30 * i);
					}
				}
			}






			//if (e.getY() <= 30) {
			//	model.setShape(1);
			//	y = 10;
			//}
			//else if (e.getY() <= 60) {
			//	model.setShape(2);
			//y = 40;
			//}
			//else if (e.getY() <= 90) {
			//model.setShape(3);
			//	y = 70;
			//	}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}
 
		});
}



		@Override
		public void paintComponent(Graphics g) {
			g.setColor(model.getColor());
			g.fillOval(0, 0, 30, 30);
			g.fillRect(0, 30, 30, 30);
			g.fillPolygon(xpoints, ypoints, npoints);

			g.setColor(Color.black);
			g.drawRect(0, 30, 30, 30);
			g.drawOval(0, 0, 30, 30);
			g.drawPolygon(xpoints, ypoints, npoints);


			g.setColor(Color.LIGHT_GRAY);
			g.fillOval(10, y, 10, 10);

			repaint();
		}
	}