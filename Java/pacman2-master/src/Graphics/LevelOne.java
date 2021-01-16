package Graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;


/*'
 * Graphics and powerups for level one.
 */
public class LevelOne extends Levels {

	private ArrayList<PowerUp> tenPowerUpList = new ArrayList<>();
	private ArrayList<PowerUp> fivePowerUpList = new ArrayList<>();
	private FivePointPowerUp spu;
	private TenPointPowerUp ten;
	
	public LevelOne () {
		this.spu = new FivePointPowerUp(312, 35);
		fivePowerUpList.add(spu);
		this.spu = new FivePointPowerUp(110, 185);
		fivePowerUpList.add(spu);
		this.spu = new FivePointPowerUp(312, 275);
		fivePowerUpList.add(spu);
		this.spu = new FivePointPowerUp(110, 365);
		fivePowerUpList.add(spu);
		this.spu = new FivePointPowerUp(119, 487);
		fivePowerUpList.add(spu);
		this.ten = new TenPointPowerUp(380, 230);
		tenPowerUpList.add(ten);
		this.ten = new TenPointPowerUp(305, 550);
		tenPowerUpList.add(ten);
		this.ten = new TenPointPowerUp(555, 35);
		tenPowerUpList.add(ten);

		
	}
	
	public void paintComponent (Graphics g) {
		g.setColor(Color.GREEN);
		
		//Ramen
		g.fillRect(0, 0, 625, 25);
		g.fillRect(0, 0, 25, 625);
		g.fillRect(600, 0, 25, 625);
		g.fillRect(0, 600, 625, 25);
		
		//Översta linjen - från vänster till höger
		g.fillRect(75, 75, 100, 50);
		g.fillRect(225, 75, 75, 50);
		g.fillRect(350, 25, 50, 100);
		g.fillRect(450, 75, 25, 50);
		g.fillRect(525, 75, 25, 50);
		
		//Mittenskiktet - från vänster till höger
		g.fillRect(75, 175, 25, 50);
		g.fillRect(75, 275, 25, 125);
		
		g.fillRect(150, 175, 50, 225);
		g.fillRect(200, 275, 100, 25);
		
		g.fillRect(250, 175, 200, 50);
		g.fillRect(350, 225, 25, 125);
		
		g.fillRect(250, 350, 125, 50);
		g.fillRect(425, 225, 25, 175);
		
		g.fillRect(500, 175, 50, 225);
		
		//Nedre - från vänster till höger
		g.fillRect(75, 450, 125, 25);
		g.fillRect(75, 525, 125, 25);
		
		g.fillRect(250, 450, 50, 150);
		
		g.fillRect(350, 450, 100, 25);
		g.fillRect(350, 525, 100, 75);
		
		g.fillRect(500, 450, 50, 50);
		g.fillRect(500, 550, 50, 50);
	}
	public ArrayList<PowerUp> getTenPowerUpList() {	
		return tenPowerUpList;
	}
	
	public ArrayList<PowerUp> getFivePowerUpList() {
		return fivePowerUpList;
	}
	
}
