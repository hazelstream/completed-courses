package Graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;


/**
 * Class for painting out the start menu.
 * @author viksv451
 *
 */
public class MainMenu extends JComponent {
	
	
	
	public MainMenu() {
		
		
	}
	
	public void paintComponent(Graphics g) {
		
		g.setFont(new Font("arial", Font.BOLD, 16));
		
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, 675, 675);

		
		g.setColor(Color.red);
		g.fillRect(245, 170, 185, 40);
		
		
		
		g.setColor(Color.green);
		g.fillRect(245, 230, 185, 40);
		g.setColor(Color.orange);
		g.fillRect(245, 290, 185, 40);
		g.setColor(Color.pink);
		g.fillRect(245, 350, 185, 40);
		
		
		
		//TEXT
		
		g.setColor(Color.black);
		g.drawString("SPELA", 310, 195);
		
		g.setColor(Color.black);
		g.drawString("HIGHSCORES", 285, 255);
		
		g.setColor(Color.black);
		g.drawString("HELP", 310, 315);
		
		g.setColor(Color.black);
		g.drawString("EXIT", 310, 375);
		
	}
	
	
}
