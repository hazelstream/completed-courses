package Logic;

import java.awt.Rectangle;
import java.util.ArrayList;


/**
 * Superclass for classes creating intersection rectangles for levels
 * @author viksv451
 *
 */
public abstract class Collision {
	
	public Collision() {
		
	}

	public abstract ArrayList<Rectangle> getLevel();

}
