import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class Game {
	
	JFrame window;
	Container con;
	JPanel titlePanel, startButtonPanel, bodyTextPanel, choiceButtonPanel;
	JLabel titleLabel;
	Font titleFont = new Font("Times New Roman",Font.PLAIN, 60);
	Font buttonFont = new Font("Times New Roman",Font.PLAIN, 25);
	Font normalFont = new Font("Times New Roman",Font.PLAIN, 20);
	JButton startButton, choice1, choice2, choice3, choice4;
	JTextArea bodyTextArea;
	
	TitleScreenHandler tsHandler = new TitleScreenHandler(); // listen for button click
	
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
		startButton.addActionListener(tsHandler); // call game screen on click

		/* Add components to panels */
		titlePanel.add(titleLabel);
		startButtonPanel.add(startButton);
		
		/* Add panels to container */
		con.add(titlePanel); // add title panel to container
		con.add(startButtonPanel); // add start button panel to container
		
		
		/* Display window */
		window.setVisible(true);

		
	}
	
	public void createGameScreen() {
		
		/* Disable start screen */
		titlePanel.setVisible(false);
		startButtonPanel.setVisible(false);
		
		/* Create body text panel */
		bodyTextPanel = new JPanel();
		bodyTextPanel.setBounds(100, 100, 600, 250);
		bodyTextPanel.setBackground(Color.black);
		con.add(bodyTextPanel);
		
		/* Add body text area */
		bodyTextArea = new JTextArea("This is the body text area. This game is going to be great I'm sure of it!!! So let's build this thing!");
		bodyTextArea.setBounds(100, 100, 600, 250);
		bodyTextArea.setBackground(Color.black);
		bodyTextArea.setForeground(Color.white);
		bodyTextArea.setFont(normalFont);
		bodyTextArea.setLineWrap(true);
		bodyTextArea.setEditable(false);
		bodyTextPanel.add(bodyTextArea);
		
		
		/* Player choice buttons */
		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(250, 350, 300, 150);
		choiceButtonPanel.setBackground(Color.black);
		choiceButtonPanel.setLayout(new GridLayout(4, 1));
		con.add(choiceButtonPanel);
		
		choice1 = new JButton("Choice 1");
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.black);
		choice1.setFont(buttonFont);
		choiceButtonPanel.add(choice1);
		
		choice2 = new JButton("Choice 2");
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.black);
		choice2.setFont(buttonFont);
		choiceButtonPanel.add(choice2);
		
		choice3 = new JButton("Choice 3");
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.black);
		choice3.setFont(buttonFont);
		choiceButtonPanel.add(choice3);
		
		choice4 = new JButton("Choice 4");
		choice4.setBackground(Color.black);
		choice4.setForeground(Color.black);
		choice4.setFont(buttonFont);
		choiceButtonPanel.add(choice4);
		
	}
	
	public class TitleScreenHandler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			createGameScreen(); // result of button click
			
		}
	}

}
