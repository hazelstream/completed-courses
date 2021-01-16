package Graphics;

import Logic.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


/**
 * Game loop class with corresponding methods to run the game.
 * @author viksv451
 *
 */
public class Game {


	private boolean isRunning = true;
	private File highScoreFile;
	private DrawingArea drawingArea;
	private GameFrame frame;
	private int scoreStyr = 0;
	private int gameStage = 1;
	private int monsterStyr = 0;
	private int monsterRandom = 0;
	private int currentLevel = 0;
	private ArrayList<MyPair> scoreList = new ArrayList<>();
	private MyPair par;



	public Game() throws IOException {

		loadScore();



		if (highScoreFile == null) {
			highScoreFile = new File("HIGHSCORES.txt");
			drawingArea = new DrawingArea(this);
		}
		else {
			drawingArea = new DrawingArea(this);
		}

	}

	public void run() throws InterruptedException, IOException  {
		frame = new GameFrame(drawingArea);
		frame.addKeyListener(new MyKeyListener(drawingArea));
		setCurrentLevel(currentLevel);

		while(isRunning) {
			Thread.sleep(5);
			if (scoreStyr >= 200 && gameStage == 2) {
				updateScore();
				scoreStyr = 0;

			}
			if (gameStage == 2 && monsterStyr >= 5) {
				updateMonster();
				monsterStyr = 0;
				monsterRandom ++;
				if (monsterRandom >= 50) {
					for (Enemies e: drawingArea.getModel().getEnemyList()) {
						e.randomize();
						monsterRandom = 0;
					}
				}
			}
			scoreStyr += 1;
			monsterStyr ++;
			updateGameStage();
			if (drawingArea.getModel().getLevelList().get(currentLevel).getFivePowerUpList().size() == 0 && 
					drawingArea.getModel().getLevelList().get(currentLevel).getTenPowerUpList().size() == 0 && currentLevel == 0) {
				setCurrentLevel(1);
				this.currentLevel = 1;
				nextLevel();
			}
			else if (drawingArea.getModel().getLevelList().get(currentLevel).getFivePowerUpList().size() == 0 && 
					drawingArea.getModel().getLevelList().get(currentLevel).getTenPowerUpList().size() == 0 && currentLevel == 1) {
				isRunning = false;
				saveScore();
			}
			if (drawingArea.getModel().getPlayer().fivePoints()) {
				drawingArea.getModel().getHSPanel().addScore(5);
			}
			if (drawingArea.getModel().getPlayer().tenPoints()) {
				drawingArea.getModel().getHSPanel().addScore(10);
			}
			if (drawingArea.getModel().getPlayer().enemyCollision()) {
				drawingArea.getModel().getHSPanel().removeScore(30);
				isRunning = false;
				saveScore();
			}
			if (drawingArea.getModel().getHSPanel().getScore() <= 0) {
				isRunning = false;
				saveScore();
			}
			drawingArea.repaint();


		}

	}



	//Uppdaterar fienders position. 
	public void updateMonster() {
		for(Enemies e : drawingArea.getModel().getEnemyList()) {
			e.move();
		}
	}


	public void setCurrentLevel(int currentLevel) {
		drawingArea.setCurrentLevel(currentLevel);
	}

	public void updateScore() {
		drawingArea.getModel().getHSPanel().removeScore(1);
	}

	public void saveScore() throws IOException {
		String name = drawingArea.saveScore();
		int score = drawingArea.getModel().getHSPanel().getScore();
		par = new MyPair(score, name);
		insertSorted(par);
		ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream("HIGHSCORES.txt"));

		outStream.writeObject(scoreList);

		outStream.close();
	}


	public void loadScore() {

		ObjectInputStream inStream = null;

		try {
			inStream = new ObjectInputStream(new FileInputStream("HIGHSCORES.txt"));

			scoreList = (ArrayList<MyPair>) inStream.readObject();

		} catch (FileNotFoundException e) {
			scoreList = new ArrayList<MyPair>();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (inStream != null) {
					inStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();

			}
		}
	}

	public void updateGameStage() {
		this.gameStage = drawingArea.getGameStage();
	}

	public int getGameStage() {
		return gameStage;
	}

	public void setGameStage(int gameStage) {
		this.gameStage = gameStage;
	}


	public void nextLevel() {
		drawingArea.getModel().getPlayer().setStandardPosition();
		for(Enemies e : drawingArea.getModel().getEnemyList()) {
			e.setStandardPosition();	
		}
	}

	public void insertSorted (MyPair par) {
		int index = 0;
		if(scoreList.isEmpty()) {
			scoreList.add(par);
		}

		else if(!scoreList.isEmpty()) {
			for (MyPair p : scoreList) {
				if(par.getKey() > p.getKey()) {
					scoreList.add(index, par);
					break;
				}
				++index;
			}
		}

		else {
			scoreList.add(par);
		}

	}

	public Game getGame() {
		return this;
	}

	public ArrayList<MyPair> getScoreList(){
		return scoreList;
	}




}




