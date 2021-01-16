package Logic;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Graphics.DrawingArea;

/**
 * Mouselistener for the menues.
 * @author viksv451
 *
 */

public class MainMenuListener implements MouseListener {

	private int gameStage;
	private DrawingArea drawingArea;
	
	public MainMenuListener(int gameStage, DrawingArea drawingArea) {
		this.gameStage = gameStage;
		this.drawingArea = drawingArea;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		if (gameStage == 1 && e.getX() >= 245 && e.getX() <= 430) {
			if(e.getY() >= 170 && e.getY() <= 210) {
				System.out.println("SPELAR");
				drawingArea.setGameStage(2);
				gameStage = 2;
			}
			else if(e.getY() >= 230 && e.getY() <= 270) {
				System.out.println("HIGHSCORES");
				drawingArea.setGameStage(3);
				gameStage = 3;
			}
			else if(e.getY() >= 290 && e.getY() <= 330) {
				System.out.println("HELP");
				drawingArea.setGameStage(4);
				gameStage = 4;
			}
			else if(e.getY() >= 350 && e.getY() <= 390) {
				System.out.println("EXIT");
				System.exit(0);
			}
		}
		
		if ((gameStage == 3 || gameStage == 4) && e.getX() >= 245 && e.getX() <= 430) {
			if(e.getY() >= 500 && e.getY() <= 540) {
				System.out.println("BACK");
				drawingArea.setGameStage(1);
				gameStage = 1;
			}
		}
	}
	
	@Override
	public void mousePressed(MouseEvent arg0) {}
	
	@Override
	public void mouseExited(MouseEvent arg0) {}
	
	@Override
	public void mouseEntered(MouseEvent arg0) {}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {}

}
