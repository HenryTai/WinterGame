package Game;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

//This class define the object which display the window
public class Window extends Canvas{

	private static final long serialVersionUID = 1L;

	public Window(int width, int height, String title, Main main){

		JFrame frame = new JFrame(title);
		
		//set the size of the window
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		
		//enable close button
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//make the size of window fixed
		frame.setResizable(false);
		//just make sure the window will be popped out in the middle of our screen
		frame.setLocationRelativeTo(null);
		//add the content of the game to the window
		frame.add(main);
		//make the window visible
		frame.setVisible(true);
		
		//Start running the content of the game
		main.start();
	}
	
}
