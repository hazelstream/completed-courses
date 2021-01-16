package Graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;


/**
 * Graphics and powerups for level two.
 * @author viksv451
 *
 */
public class LevelTwo extends Levels {

	private FivePointPowerUp spu;
	private TenPointPowerUp ten;
	private ArrayList<PowerUp> tenPowerUpList = new ArrayList<>();
	private ArrayList<PowerUp> fivePowerUpList = new ArrayList<>();
	
	public LevelTwo () {	
		this.spu = new FivePointPowerUp(110, 185);
		fivePowerUpList.add(spu);
		this.spu = new FivePointPowerUp(35, 560);
		fivePowerUpList.add(spu);
		this.spu = new FivePointPowerUp(110, 35);
		fivePowerUpList.add(spu);
		this.spu = new FivePointPowerUp(360, 35);
		fivePowerUpList.add(spu);
		this.spu = new FivePointPowerUp(215, 485);
		fivePowerUpList.add(spu);

		this.ten = new TenPointPowerUp(370, 258);
		tenPowerUpList.add(ten);
		this.ten = new TenPointPowerUp(483, 555);
		tenPowerUpList.add(ten);
		this.ten = new TenPointPowerUp(558, 35);
		tenPowerUpList.add(ten);
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.PINK);
		
		//Ramen
		g.fillRect(0, 0, 675, 25);
		g.fillRect(0, 0, 25, 625);
		g.fillRect(600, 0, 25, 625);
		g.fillRect(0, 600, 625, 25);
		
		//Överst - från vänster till höger
		g.fillRect(75, 25, 25, 50);
		g.fillRect(75, 75, 125, 25);
		
		g.fillRect(250, 25, 25, 75);
		g.fillRect(325, 75, 100, 25);
		
		g.fillRect(475, 25, 75, 75);
		
		//Andra raden - från vänster till höger
		g.fillRect(75, 150, 200, 25);
		g.fillRect(325, 150, 175, 25);
		g.fillRect(550, 150, 50, 25);
		
		//Mittenskiktet - från vänster till höger, uppifrån och ned
		g.fillRect(75, 175, 25, 150);
		g.fillRect(100, 225, 75, 100);
		
		g.fillRect(225, 225, 50, 100);
		
		g.fillRect(325, 225, 125, 25);
		g.fillRect(325, 300, 125, 25);
		
		g.fillRect(500, 225, 50, 100);
		
		//Nedre - från vänster till höger, uppifrån och ned
		g.fillRect(75, 375, 250, 25);
		g.fillRect(375, 375, 175, 25);
		
		g.fillRect(75, 450, 50, 50);
		g.fillRect(75, 550, 50, 50);
		
		g.fillRect(175, 450, 25, 100);
		g.fillRect(200, 525, 200, 25);
		
		g.fillRect(250, 450, 150, 25);
		
		g.fillRect(450, 450, 100, 50);
		
		g.fillRect(450, 550, 25, 50);
		g.fillRect(525, 550, 25, 50);

	}

	public ArrayList<PowerUp> getPowerUpList() {
		return fivePowerUpList;
	}
	public ArrayList<PowerUp> getFivePowerUpList() {
		return fivePowerUpList;
	}
	
	public ArrayList<PowerUp> getTenPowerUpList() {
		return tenPowerUpList;
	}
	
}
