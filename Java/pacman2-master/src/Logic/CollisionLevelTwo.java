package Logic;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collections;

import Graphics.Player;

/**
 * Class responsible for creating the level two intersection rectangles.
 * @author viksv451
 *
 */

public class CollisionLevelTwo extends Collision{
	
	private ArrayList<Rectangle> levelTwo = new ArrayList<Rectangle>();
	
	public CollisionLevelTwo() {
		Rectangle rect1 = new Rectangle(0, 0, 675, 25);
		Rectangle rect2 = new Rectangle(0, 0, 25, 625);
		Rectangle rect3 = new Rectangle(600, 0, 25, 625);
		Rectangle rect4 = new Rectangle(0, 600, 625, 25);
		
		//Överst - från vänster till höger
		Rectangle rect5 = new Rectangle(75, 25, 25, 50);
		Rectangle rect6 = new Rectangle(75, 75, 125, 25);
				
		Rectangle rect7 = new Rectangle(250, 25, 25, 75);
		Rectangle rect8 = new Rectangle(325, 75, 100, 25);
				
		Rectangle rect9 = new Rectangle(475, 25, 75, 75);
				
				//Andra raden - från vänster till höger
		Rectangle rect10 = new Rectangle(75, 150, 200, 25);
		Rectangle rect11 = new Rectangle(325, 150, 175, 25);
		Rectangle rect12 = new Rectangle(550, 150, 50, 25);
				
				//Mittenskiktet - från vänster till höger, uppifrån och ned
		Rectangle rect13 = new Rectangle(75, 175, 25, 150);
		Rectangle rect14 = new Rectangle(100, 225, 75, 100);
				
		Rectangle rect15 = new Rectangle(225, 225, 50, 100);
				
		Rectangle rect16 = new Rectangle(325, 225, 125, 25);
		Rectangle rect17 = new Rectangle(325, 300, 125, 25);
				
		Rectangle rect18 = new Rectangle(500, 225, 50, 100);
				
				//Nedre - från vänster till höger, uppifrån och ned
		Rectangle rect19 = new Rectangle(75, 375, 250, 25);
		Rectangle rect20 = new Rectangle(375, 375, 175, 25);
				
		Rectangle rect21 = new Rectangle(75, 450, 50, 50);
		Rectangle rect22= new Rectangle(75, 550, 50, 50);
				
		Rectangle rect23 = new Rectangle(175, 450, 25, 100);
		Rectangle rect24= new Rectangle(200, 525, 200, 25);
				
		Rectangle rect25 = new Rectangle(250, 450, 150, 25);
				
		Rectangle rect26 = new Rectangle(450, 450, 100, 50);
				
		Rectangle rect27= new Rectangle(450, 550, 25, 50);
		Rectangle rect28 = new Rectangle(525, 550, 25, 50);
		
		Collections.addAll(levelTwo, rect1, rect2, rect3, rect4, rect5, rect6, rect7, rect8, rect9, rect10, rect11, rect12, rect13, rect14,
				rect15, rect16, rect17, rect18, rect19, rect20, rect21, rect22, rect23, rect24, rect25, rect26, rect27, rect28);
		
	}
	
	public ArrayList<Rectangle> getLevel(){
		return levelTwo;
	}
}
