
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JComponent;

public class ColorButtons extends JComponent {
	
	private Model model;
	private int y = 10;
	private ArrayList<Color> colors = new ArrayList<>();
	
	public ColorButtons(Model model) {
		this.model = model;
		Collections.addAll(colors, Color.black, Color.yellow, Color.red, Color.magenta, Color.green, Color.cyan, Color.blue, Color.orange);
		
		this.addMouseListener(new MouseListener(){
			
			// TODO: Komplettering: Ha en Array/lista med alla färger som ni loopar över istället
			// Sedan kan ni med hjälp av divison få ut vilken färg som skall väljas.
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("Vi klickade i färgkomponenten! på " +
						e.getX() + "," + e.getY());
				
				for(int i = 0; i < colors.size(); ++i) {
					System.out.println(i);
					System.out.println(e.getY());
					if(e.getY() >= i * 30 && e.getY() <= (i + 1) * 30) {
						model.putColor(colors.get(i));
						y = 10 + (30 * i);
					}
				}
				
//				if (e.getY() <= 30) {
//					model.putColor(Color.black);
//					y = 10;
//				}
//				else if (e.getY() <= 60) {
//					model.putColor(Color.yellow);
//					y = 40;
//				}
//				else if (e.getY() <= 90) {
//					model.putColor(Color.red);
//					y = 70;
//				}
//				else if (e.getY() <= 120) {
//					model.putColor(Color.magenta);
//					y = 100;
//				}
//				else if (e.getY() <= 150) {
//					model.putColor(Color.green);
//					y = 130;
//				}
//				else if (e.getY() <= 180) {
//					model.putColor(Color.cyan);
//					y = 160;
//				}
//				else if (e.getY() <= 210) {
//					model.putColor(Color.blue);
//					y = 190;
//				}
//				else if (e.getY() <= 240) {
//					model.putColor(Color.orange);
//					y = 220;
//				}
				
			}
			
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
		g.setColor(Color.black);
		g.fillRect(0, 0, 30, 30);
		
		g.setColor(Color.yellow);
		g.fillRect(0, 30, 30, 30);
		
		g.setColor(Color.red);
		g.fillRect(0, 60, 30, 30);

		g.setColor(Color.magenta);
		g.fillRect(0, 90, 30, 30);

		g.setColor(Color.green);
		g.fillRect(0, 120, 30, 30);

		g.setColor(Color.cyan);
		g.fillRect(0, 150, 30, 30);

		g.setColor(Color.blue);
		g.fillRect(0, 180, 30, 30);

		g.setColor(Color.orange);
		g.fillRect(0, 210, 30, 30);
		
		g.setColor(Color.black);
		g.drawRect(0, 30, 30, 30);
		g.drawRect(0, 210, 30, 30);
		g.drawRect(0, 180, 30, 30);
		g.drawRect(0, 150, 30, 30);
		g.drawRect(0, 120, 30, 30);
		g.drawRect(0, 90, 30, 30);
		g.drawRect(0, 60, 30, 30);
		
		g.setColor(Color.LIGHT_GRAY);
		g.fillOval(10, y, 10, 10);
		
		repaint();
	}
}