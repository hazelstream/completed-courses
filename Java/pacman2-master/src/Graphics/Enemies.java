package Graphics;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.JComponent;

import Logic.Collision;
import Logic.Model;
import Logic.Position;


/**
 * Superclass for enemies
 * @author viksv451
 *
 */
public abstract class Enemies extends JComponent {
	
	private Position currentPos;
	private Model model;
	private Position startPos;
	private Rectangle enemyRectangle;
	private int currentLevel = 0;
	private int x, y;
	ArrayList<Collision> collisionLists = new ArrayList<>();
	

	public Enemies (int x, int y, Model model) {
		currentPos = new Position(x, y);
		startPos = currentPos;
		this.model = model;
		this.x = x;
		this.y = y;
		Collections.addAll(collisionLists, getModel().getCollisionOne(), getModel().getCollisionTwo());
		
	}
	
	public abstract void paintComponent (Graphics g);
	
	public int getCurrentPosX() {
		return currentPos.getPosX();
	}
	
	public int getCurrentPosY() {
		return currentPos.getPosY();
	}
	
	public void setCurrentPosY(int y) {
		currentPos.setPosY(y);
	}
	
	public void setCurrentPosX(int x) {
		currentPos.setPosX(x);
	}
	
	public Model getModel() {
		return model;
	}
	public Rectangle getEnemyRectangle() {
		return enemyRectangle;
	}
	
	public void setCurrentLevel(int currentLevel) {
		this.currentLevel = currentLevel;
	}
	
	public int getCurrentLevel() {
		return currentLevel;
	}
	
	public abstract void move();
	
	public abstract void randomize();
	
	public Position getStartPos() {
		return startPos;
	}
	public boolean checkCollision() {
		for (Rectangle r : this.collisionLists.get(getCurrentLevel()).getLevel()) {
			if(enemyRectangle.intersects(r)) {
				return true;
			}
		}
		return false;
	}
	public void setStandardPosition() {
			setCurrentPosX(this.x);
			setCurrentPosY(this.y);
	}
}
	

