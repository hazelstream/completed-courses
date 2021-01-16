package Graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;


/**
 * Class that paints the score while in game
 * @author viksv451
 *
 */
public class HSPanel extends JPanel {

	private int score = 60;

	public HSPanel() {
		
		this.setBackground(Color.darkGray);
		this.setPreferredSize(new Dimension(150, getHeight()));
		
	}

	    public void paintComponent (Graphics g) {

	    	g.setFont(new Font("arial", Font.BOLD, 12));
			g.setColor(Color.black);
			g.drawString("Score: " + score, 25, 15);

	    }

		public int getScore() {
			return score;
		}
	
		public void setScore(int score) {
			this.score = score;
		}
		
		public void addScore(int number) {
			this.score = this.score + number;
		}
		
		public void removeScore(int x) {
			this.score = this.score - x;
		}
}
