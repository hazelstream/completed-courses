package Graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;


/**
 * Class that paint the helpmenu.
 * @author viksv451
 *
 */
public class HelpMenu extends JComponent{
	
	private DrawingArea drawingArea;
	private int gameStage;

	public HelpMenu(DrawingArea drawingArea, int gameStage) {
		this.drawingArea = drawingArea;
		this.gameStage = gameStage;
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		g.setFont(new Font("arial", Font.BOLD, 16));
		
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, 675, 675);

		
		
		g.setColor(Color.cyan);
		g.fillRect(245, 500, 185, 40);
		
		
		g.setColor(Color.red);
		g.fillRect(200, 100, 275, 350);
		
		
		g2.setColor(Color.black);
		drawString(g2, "VÄLKOMMEN TILL BK-MAN", 220, 130);
		drawString(g2, "Ditt namn är BK.\n\nDu vaknar mitt i natten\n"
				+ "och letar efter nån form\n"
				+ "av nattkäk. Se till att äta\n"
				+ "sunt och motstå frestelsen\n"
				+ "av de lömska semlorna.\n"
				+ "Ät alla nyttigheter för\n"
				+ "att klara spelet.\n\n"
				+ "Äpple = 5 poäng\n"
				+ "Broccoli = 10 poäng\n"
				+ "Semla = -30 poäng och\nförlust"
				+ "", 220, 160);
		
		g.setColor(Color.black);
		g.drawString("BACK", 310, 525);
	}
	
	private void drawString(Graphics g, String text, int x, int y) {
        for (String line : text.split("\n"))
            g.drawString(line, x, y += g.getFontMetrics().getHeight());
    }

}
