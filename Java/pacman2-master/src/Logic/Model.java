package Logic;

import java.io.IOException;
import java.util.ArrayList;

import Graphics.DrawingArea;
import Graphics.Enemies;
import Graphics.HSPanel;
import Graphics.HelpMenu;
import Graphics.HighScoreMenu;
import Graphics.LevelOne;
import Graphics.LevelTwo;
import Graphics.Levels;
import Graphics.MainMenu;
import Graphics.NormalEnemy;
import Graphics.Player;


/**
 * Databaseclass that stores everything created.
 * @author viksv451
 *
 */
public class Model {
	
	private ArrayList<Player> playerList = new ArrayList<>();
	private Player player;
	private ArrayList<Levels> levelList = new ArrayList<>();
	private Levels levelOne, levelTwo;
	private Collision collisionLevelOne, collisionLevelTwo;
	private MainMenu mainMenu = new MainMenu();
	private HSPanel highScores;
	private HighScoreMenu highScoresMenu;
	private HelpMenu helpMenu;
	private ArrayList<Enemies> enemyList = new ArrayList<Enemies>();
	private Enemies enemyOne, enemyTwo, enemyThree;
	

	public Model(DrawingArea drawingArea) throws IOException {
		levelOne = new LevelOne();
		levelList.add(levelOne);
		levelTwo = new LevelTwo();
		levelList.add(levelTwo);
		player = new Player(returnModel(), drawingArea);
		playerList.add(player);
		highScores = new HSPanel();
		
		highScoresMenu = new HighScoreMenu(drawingArea.getGame());
		
		helpMenu = new HelpMenu(drawingArea, drawingArea.getGameStage());
		
		
		collisionLevelOne = new CollisionLevelOne();
		collisionLevelTwo = new CollisionLevelTwo();
		
		enemyOne = new NormalEnemy(550, 550, returnModel());
		enemyTwo = new NormalEnemy(75, 400, returnModel());
		enemyThree = new NormalEnemy(550, 105, returnModel());
		enemyList.add(enemyOne);
		enemyList.add(enemyTwo);
		enemyList.add(enemyThree);
		
	}
	
	public Model returnModel() {
		return this;
	}
	
	public ArrayList<Player> getPlayerList(){
		return playerList;
	}
	
	public ArrayList<Levels> getLevelList(){
		return levelList;
		
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public Collision getCollisionOne() {
		return collisionLevelOne;
	}
	
	public Collision getCollisionTwo() {
		return collisionLevelTwo;
	}

	public MainMenu getMainMenu() {
		return mainMenu;
	}
	
	public HSPanel getHSPanel() {
		return highScores;
	}
	public ArrayList<Enemies> getEnemyList() {
		return enemyList;
	}
	
	public HighScoreMenu getHighScoresMenu() {
		return highScoresMenu;
	}

	public HelpMenu getHelpMenu() {
		return helpMenu;
	}
}
