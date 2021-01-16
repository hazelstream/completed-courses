package Logic;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Graphics.DrawingArea;


/**
 * Arrowkeyslistener used to move the player ingame.
 * @author viksv451
 *
 */
public class MyKeyListener implements KeyListener {
	
	private DrawingArea d;

	public MyKeyListener(DrawingArea drawingArea) {
		this.d = drawingArea;
	}

	@Override
	public void keyPressed(KeyEvent e) {

	     


		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
	    {
			d.getModel().getPlayer().goRight();
			
	    }
		else if (e.getKeyCode() == KeyEvent.VK_UP) {
			d.getModel().getPlayer().goUp();
		}
		
		else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			d.getModel().getPlayer().goDown();
		}

	    else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
	    	d.getModel().getPlayer().goLeft();
	    }

	}

	@Override
	public void keyReleased(KeyEvent arg0) {}

	@Override
	public void keyTyped(KeyEvent arg0) {}

}
