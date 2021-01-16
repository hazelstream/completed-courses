package Graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;


/**
 * Class creating the JFrame that contains all the other elements.
 * @author viksv451
 *
 */
public class GameFrame extends JFrame {
	
	private HSPanel highScores;
	private DrawingArea drawingArea;
	private int height;

	
	
	public GameFrame(DrawingArea drawingArea) {
		this.drawingArea = drawingArea;
		this.setTitle("BK-MAN");
		this.setLayout(new BorderLayout());

		this.add(drawingArea, BorderLayout.CENTER);
		
		
		
		
		this.setSize(625, 647);
		this.setResizable(false);
		this.setBackground(Color.green);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
		height = this.getHeight();
		System.out.println("Framens höjd är " + height);
	}
	
	public DrawingArea getDrawingArea() {
		return drawingArea;
	}
	
	public HSPanel getHighScores() {
		return highScores;
	}
}
