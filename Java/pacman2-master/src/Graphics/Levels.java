package Graphics;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JComponent;


/**
 * Superclass for levels
 * @author viksv451
 *
 */
public abstract class Levels extends JComponent {
	
	
	public Levels (){	
	}
	
	public abstract void paintComponent (Graphics g);

	public abstract ArrayList<PowerUp> getTenPowerUpList();
	
	public abstract ArrayList<PowerUp> getFivePowerUpList();
	
}

