import java.awt.Color;

import javax.swing.JFrame;

public class Game {
	
	JFrame window; // game window
	
	public static void main(String[] args) {
		
		new Game();
		
	}
	
	public Game() {
		
		/* Create a window */
		window = new JFrame(); // new window
		window.setSize(800, 600); // window size
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close window button
		window.getContentPane().setBackground(Color.BLACK); // window background color
		window.setLayout(null); // disable default layout for customization
		window.setVisible(true); // display the window
		
		
	}

}
