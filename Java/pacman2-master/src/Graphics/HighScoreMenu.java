package Graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JComponent;
import Logic.MyPair;

/**
 * Class for painting the high score menu
 * @author viksv451
 *
 */
public class HighScoreMenu extends JComponent{


	private ArrayList<MyPair> scoreList;
	private int height = 120;

	public HighScoreMenu(Game game) throws IOException {


		scoreList = game.getScoreList();


	}

	public void paintComponent(Graphics g) {
		g.setFont(new Font("arial", Font.BOLD, 16));

		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, 675, 675);



		g.setColor(Color.magenta);
		g.fillRect(245, 500, 185, 40);

		g.setColor(Color.pink);
		g.fillRect(200, 100, 275, 350);


		g.setColor(Color.black);

		g.drawString("HIGHSCORES", 280, 130);



		if(scoreList.size() >= 1) {
			g.drawString(scoreList.get(0).getKey() + ". " + scoreList.get(0).getValue(), 220, 160);
		}
		if(scoreList.size() >= 2) {
			g.drawString(scoreList.get(1).getKey()  + ". " + scoreList.get(1).getValue(), 220, 190);
		}
		if(scoreList.size() >= 3) {
			g.drawString(scoreList.get(2).getKey()  + ". " + scoreList.get(2).getValue(), 220, 220);
		}
		if(scoreList.size() >= 4) {
			g.drawString(scoreList.get(3).getKey()  + ". " + scoreList.get(3).getValue(), 220, 250);
		}
		if(scoreList.size() >= 5) {
			g.drawString(scoreList.get(4).getKey()  + ". " + scoreList.get(4).getValue(), 220, 280);
		}
		if(scoreList.size() >= 6) {
			g.drawString(scoreList.get(5).getKey()  + ". " + scoreList.get(5).getValue(), 220, 310);
		}
		if(scoreList.size() >= 7) {
			g.drawString(scoreList.get(6).getKey()  + ". " + scoreList.get(6).getValue(), 220, 340);
		}
		if(scoreList.size() >= 8) {
			g.drawString(scoreList.get(7).getKey()  + ". " + scoreList.get(7).getValue(), 220, 370);
		}
		if(scoreList.size() >= 9) {
			g.drawString(scoreList.get(8).getKey() + ". " + scoreList.get(8).getValue(), 220, 400);
		}
		if(scoreList.size() >= 10) {
			g.drawString(scoreList.get(9).getKey()  + ". " + scoreList.get(9).getValue(), 220, 400);
		}




		g.setColor(Color.black);
		g.drawString("BACK", 310, 525);
	}

}
