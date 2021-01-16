package Graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.ImageIcon;

import Logic.Collision;
import Logic.Model;
import Logic.Position;


/**
 * Class responsible for painting and moving enemies.
 * @author viksv451
 *
 */
public class NormalEnemy extends Enemies {

	private Position currentPos;
	private Rectangle enemyRectangle;
	private int speed = 2;
	private Model model;
	private int random = 2;
	private int currentLevel = 0;
	private Image img;


	public NormalEnemy (int x, int y, Model model) {
		super(x, y, model);
		enemyRectangle = new Rectangle(getCurrentPosX(), getCurrentPosY(), 45, 45);
		ImageIcon i = new ImageIcon("pics/semla-2.png");
		img = i.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.red);
		g.drawImage(img, getCurrentPosX(), getCurrentPosY(), null);
	}


	public void setPosition(int x, int y) {
		setCurrentPosX(getCurrentPosX() + x);
		setCurrentPosY(getCurrentPosY() + y);
	}

	public void goLeft() {


		enemyRectangle.setBounds(getCurrentPosX() - 1 * speed, getCurrentPosY(), 47, 47);

		if(!checkCollision()) {
			this.setPosition(-1 * speed, 0);
			enemyRectangle.setBounds(getCurrentPosX(), getCurrentPosY(), 47, 47);
		}
		else if (checkCollision()) {
			randomize();
			this.setPosition(0,  0);
			enemyRectangle.setBounds(getCurrentPosX(), getCurrentPosY(), 47, 47);
		}

	}

	public void goUp() {


		enemyRectangle.setBounds(getCurrentPosX(), getCurrentPosY() - 1 * speed, 47, 47);

		if(!checkCollision()) {
			this.setPosition(0, -1 * speed);
			enemyRectangle.setBounds(getCurrentPosX(), getCurrentPosY(), 47, 47);
		}
		else if (checkCollision()) {
			randomize();
			this.setPosition(0,  0);
			enemyRectangle.setBounds(getCurrentPosX(), getCurrentPosY(), 47, 47);
		}
	}

	public void goRight() {


		enemyRectangle.setBounds(getCurrentPosX() + 1 * speed, getCurrentPosY(), 47, 47);

		if(!checkCollision()) {
			this.setPosition(1 * speed, 0);
			enemyRectangle.setBounds(getCurrentPosX(), getCurrentPosY(), 47, 47);
		}
		else if (checkCollision()) {
			randomize();
			this.setPosition(0,  0);
			enemyRectangle.setBounds(getCurrentPosX(), getCurrentPosY(), 47, 47);
		}
	}

	public void goDown() {


		enemyRectangle.setBounds(getCurrentPosX(), getCurrentPosY() + 1 * speed, 47, 47);

		if(!checkCollision()) {
			this.setPosition(0, 1 * speed);
			enemyRectangle.setBounds(getCurrentPosX(), getCurrentPosY(), 47, 47);
		}
		else if (checkCollision()) {
			randomize();
			this.setPosition(0,  0);
			enemyRectangle.setBounds(getCurrentPosX(), getCurrentPosY(), 47, 47);
		}
	}

	public boolean checkCollision() {
		ArrayList<Collision> collisionLists = new ArrayList<>();
		Collections.addAll(collisionLists, getModel().getCollisionOne(), getModel().getCollisionTwo());
		
		for (Rectangle r : collisionLists.get(getCurrentLevel()).getLevel()) {
			if(enemyRectangle.intersects(r)) {
				return true;
			}
		}
		return false;
	}

	public void move() {
		int value;
		
		value = this.random;
		
		switch(value) {
		case 1:
			goLeft();
			break;
		case 2:
			goUp();
			break;
		case 3:
			goDown(); 
			break;
		case 4:
			goRight(); 
			break;
		default:
			
		}
	}
	
	public void randomize() {
		int max = 4;
		int min = 1;
		Random rand = new Random();
		this.random = rand.nextInt((max - min) + 1) + min;
	}
	
	public Rectangle getEnemyRectangle() {
		return enemyRectangle;
	}
	
	public NormalEnemy getNormalEnemy() {
		return this;
	}
}
