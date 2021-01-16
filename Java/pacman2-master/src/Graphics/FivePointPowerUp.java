package Graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

/**
 * Class for painting powerups worth five points.
 * @author viksv451
 *
 */
public class FivePointPowerUp extends PowerUp {
	
	private int x;
	private int y;
	private Rectangle spuRectangle;
	private Image img;
	
	public FivePointPowerUp (int x, int y) {
		this.x = x;
		this.y = y;
		spuRectangle = new Rectangle(x, y, 25, 25);
		
		ImageIcon i = new ImageIcon("pics/apple.png");
		img = i.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
		
	}
	
	public void paintComponent (Graphics g) {
		g.drawImage(img, x, y, null);
	}

	
	public Rectangle getRectangle () {
		return spuRectangle;
	}
}
