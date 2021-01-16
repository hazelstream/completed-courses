package Logic;


/**
 * Class for storing players and enemies current positions
 * @author viksv451
 *
 */
public class Position {
	
	private int posX;
	private int posY;

	public Position(int x, int y) {
		posX = x;
		posY = y;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}
}
