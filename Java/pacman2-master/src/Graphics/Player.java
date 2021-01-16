package Graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

import Logic.Collision;
import Logic.Model;
import Logic.Position;


/**
 * Class responsible for painting, moving the player and the player's intersections.
 * 
 * @author viksv451
 *
 */
public class Player extends JComponent{

	private Position currentPos;
	private Position startPos;
	private int speed = 4; 
	private Model models;
	private Rectangle playerRectangle;
	private Image img;
	private int currentLevel = 0;


	public Player(Model models, DrawingArea drawingArea) {
		this.models = models;
		currentPos = new Position(27, 25);
		startPos = currentPos;
		playerRectangle = new Rectangle(currentPos.getPosX(), currentPos.getPosY(), 40, 40);
		
		ImageIcon i = new ImageIcon("pics/Bert-3.png");
		img = i.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
		
		
		
	}

	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.yellow);
		g.drawImage(img, currentPos.getPosX(), currentPos.getPosY(), null);
	}

	public void setPosition(int x, int y) {
		currentPos.setPosX(currentPos.getPosX() + x);
		currentPos.setPosY(currentPos.getPosY() + y);
	}
	public void setStandardPosition () {
		System.out.println("HAllå");
		currentPos.setPosX(27);
		currentPos.setPosY(25);
		playerRectangle.setLocation(currentPos.getPosX(), currentPos.getPosY());
	}

	public void goLeft() {

		playerRectangle.setLocation(currentPos.getPosX() - speed, currentPos.getPosY());
		if(!checkCollision()) {
			this.setPosition(-1 * speed, 0);
			playerRectangle.setLocation(currentPos.getPosX(), currentPos.getPosY());
		}
		else if (checkCollision()) {
			this.setPosition(0,  0);
			playerRectangle.setLocation(currentPos.getPosX(), currentPos.getPosY());
		}

	}

	public void goUp() {

		playerRectangle.setLocation(currentPos.getPosX(), currentPos.getPosY() - speed);
		if(!checkCollision()) {
			this.setPosition(0, -1 * speed);
			playerRectangle.setLocation(currentPos.getPosX(), currentPos.getPosY());
		}
		else if (checkCollision()) {
			this.setPosition(0,  0);
			playerRectangle.setLocation(currentPos.getPosX(), currentPos.getPosY());
		}
	}

	public void goRight() {


		playerRectangle.setLocation(currentPos.getPosX() + speed, currentPos.getPosY());

		if(!checkCollision()) {
			this.setPosition(1 * speed, 0);
			playerRectangle.setLocation(currentPos.getPosX(), currentPos.getPosY());
		}
		else if (checkCollision()) {
			this.setPosition(0,  0);
			playerRectangle.setLocation(currentPos.getPosX(), currentPos.getPosY());
		}
	}

	public void goDown() {


		playerRectangle.setLocation(currentPos.getPosX(), currentPos.getPosY() + speed);

		if(!checkCollision()) {
			this.setPosition(0, 1 * speed);
			playerRectangle.setLocation(currentPos.getPosX(), currentPos.getPosY());
		}
		else if (checkCollision()) {
			this.setPosition(0,  0);
			playerRectangle.setLocation(currentPos.getPosX(), currentPos.getPosY());
		}
	}

	public Position getCurrentPos() {
		return currentPos;
	}

	public boolean checkCollision() {

		ArrayList<Collision> collisionLists = new ArrayList<>();
		Collections.addAll(collisionLists, models.getCollisionOne(), models.getCollisionTwo());

		for (Rectangle r : collisionLists.get(currentLevel).getLevel()) {
			if(playerRectangle.intersects(r)) {
				return true;
			}
		}

		return false;

	}
	public boolean enemyCollision() {
		for (Enemies e : models.getEnemyList()) {
			if (playerRectangle.intersects(e.getEnemyRectangle())) {
				return true;
			}
		}
		return false;

  }
	public boolean fivePoints () {
			for (PowerUp pu: models.getLevelList().get(currentLevel).getFivePowerUpList()) {
				if (playerRectangle.intersects(pu.getRectangle())){
				models.getLevelList().get(currentLevel).getFivePowerUpList().remove(pu);	
				return true;
				}
			}
		return false;
	}
	
	public boolean tenPoints () {
			for (PowerUp pu: models.getLevelList().get(currentLevel).getTenPowerUpList()) {
				if (playerRectangle.intersects(pu.getRectangle())){
				models.getLevelList().get(currentLevel).getTenPowerUpList().remove(pu);	
				return true;
				}
			}
		return false;
	}
	
	public void setCurrentLevel(int currentLevel) {
		this.currentLevel = currentLevel;
	}
	
	public void setCurrentPosY(int y) {
		currentPos.setPosY(y);
	}
	
	public void setCurrentPosX(int x) {
		currentPos.setPosX(x);
	}
	
	public Position getStartPos() {
		return startPos;
	}

	public boolean testCollison(Enemies e) {
		return playerRectangle.intersects(e.getEnemyRectangle());
	}

}
