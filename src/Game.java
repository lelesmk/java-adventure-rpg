import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Game {
	
	JFrame window;
	Container con;
	JPanel titlePanel, startButtonPanel;
	JLabel titleLabel;
	Font titleFont = new Font("Times New Roman",Font.PLAIN, 60);
	Font buttonFont = new Font("Times New Roman",Font.PLAIN, 30);
	JButton startButton;
	
	public static void main(String[] args) {
		
		new Game();
		
	}
	
	public Game() {
		
		/* Create a window */
		window = new JFrame(); // new window
		window.setSize(800, 600); // window size
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close window button
		window.getContentPane().setBackground(Color.black); // window background color
		window.setLayout(null); // disable default layout for customization
		con = window.getContentPane(); // set content container
		
		/* Create title panel */
		titlePanel = new JPanel(); // new title panel
		titlePanel.setBounds(100, 100, 600, 150); // set text boundary (x,y,width,height)
		titlePanel.setBackground(Color.black); // text background color
		titleLabel = new JLabel("ADVENTURE GAME");
		titleLabel.setForeground(Color.white); // text foreground color
		titleLabel.setFont(titleFont);
		
		/* Create button panel */
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(300, 400, 200, 100);
		startButtonPanel.setBackground(Color.black);
		
		startButton = new JButton("START");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.black);
		startButton.setFont(buttonFont);

		/* Add components to panels */
		titlePanel.add(titleLabel);
		startButtonPanel.add(startButton);
		
		/* Add panels to container */
		con.add(titlePanel); // add title panel to container
		con.add(startButtonPanel); // add start button panel to container
		
		
		/* Display window */
		window.setVisible(true);

		
	}

}
