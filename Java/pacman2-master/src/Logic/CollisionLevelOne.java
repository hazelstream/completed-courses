package Logic;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collections;

import Graphics.Player;


/**
 * Class responsible for creating the level one intersection rectangles.
 * @author viksv451
 *
 */
public class CollisionLevelOne extends Collision{
	
	private ArrayList<Rectangle> levelOne = new ArrayList<Rectangle>();
	
	public CollisionLevelOne() {
		Rectangle rect1 = new Rectangle(0, 0, 675, 25);
		Rectangle rect2 = new Rectangle(0, 0, 25, 625);
		Rectangle rect3 = new Rectangle(600, 0, 25, 625);
		Rectangle rect4 = new Rectangle(0, 600, 625, 25);
		
		//Översta linjen - från vänster till höger
		Rectangle rect5 = new Rectangle(75, 75, 100, 50);
		Rectangle rect6 = new Rectangle(225, 75, 75, 50);
		Rectangle rect7 = new Rectangle(350, 25, 50, 100);
		Rectangle rect8 = new Rectangle(450, 75, 25, 50);
		Rectangle rect9 = new Rectangle(525, 75, 25, 50);
		
		//Mittenskiktet - från vänster till höger
		Rectangle rect10 = new Rectangle(75, 175, 25, 50);
		Rectangle rect11= new Rectangle(75, 275, 25, 125);
		
		Rectangle rect12 = new Rectangle(150, 175, 50, 225);
		Rectangle rect13 = new Rectangle(200, 275, 100, 25);
		
		Rectangle rect14 = new Rectangle(250, 175, 200, 50);
		Rectangle rect15 = new Rectangle(350, 225, 25, 125);
		
		Rectangle rect16 = new Rectangle(250, 350, 125, 50);
		Rectangle rect17 = new Rectangle(425, 225, 25, 175);
		
		Rectangle rect18 = new Rectangle(500, 175, 50, 225);
		
		//Nedre - från vänster till höger
		Rectangle rect19 = new Rectangle(75, 450, 125, 25);
		Rectangle rect20 = new Rectangle(75, 525, 125, 25);
		
		Rectangle rect21 = new Rectangle(250, 450, 50, 150);
		
		Rectangle rect22 = new Rectangle(350, 450, 100, 25);
		Rectangle rect23 = new Rectangle(350, 525, 100, 75);
		
		Rectangle rect24 = new Rectangle(500, 450, 50, 50);
		Rectangle rect25 = new Rectangle(500, 550, 50, 50);
		
		Collections.addAll(levelOne, rect1, rect2, rect3, rect4, rect5, rect6, rect7, rect8, rect9, rect10, rect11, rect12, rect13, rect14,
				rect15, rect16, rect17, rect18, rect19, rect20, rect21, rect22, rect23, rect24, rect25);
		


	}
	
	public ArrayList<Rectangle> getLevel(){
		return levelOne;
	}
}
