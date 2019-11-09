import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
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
	JPanel titlePanel, startButtonPanel, bodyTextPanel, choiceButtonPanel, playerPanel;
	JLabel titleLabel, hpLabelText, hpLabelNumber, weaponLabelText, weaponLabelName;
	Font titleFont = new Font("Times New Roman",Font.PLAIN, 60);
	Font buttonFont = new Font("Times New Roman",Font.PLAIN, 25);
	Font normalFont = new Font("Times New Roman",Font.PLAIN, 30);
	JButton startButton, choice1btn, choice2btn, choice3btn, choice4btn;
	JTextArea bodyTextArea;
	
	int playerHP;
	String weapon;
	
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
		
		choice1btn = new JButton("Choice 1");
		choice1btn.setBackground(Color.black);
		choice1btn.setForeground(Color.black);
		choice1btn.setFont(buttonFont);
		choiceButtonPanel.add(choice1btn);
		
		choice2btn = new JButton("Choice 2");
		choice2btn.setBackground(Color.black);
		choice2btn.setForeground(Color.black);
		choice2btn.setFont(buttonFont);
		choiceButtonPanel.add(choice2btn);
		
		choice3btn = new JButton("Choice 3");
		choice3btn.setBackground(Color.black);
		choice3btn.setForeground(Color.black);
		choice3btn.setFont(buttonFont);
		choiceButtonPanel.add(choice3btn);
		
		choice4btn = new JButton("Choice 4");
		choice4btn.setBackground(Color.black);
		choice4btn.setForeground(Color.black);
		choice4btn.setFont(buttonFont);
		choiceButtonPanel.add(choice4btn);
		
		/* Create player header panel */
		playerPanel = new JPanel();
		playerPanel.setBounds(100, 15, 600, 50);
		playerPanel.setBackground(Color.black);
		playerPanel.setLayout(new GridLayout(1, 4));
		
		/* Health Points */
		hpLabelText = new JLabel("HP: ");
		hpLabelText.setFont(normalFont);
		hpLabelText.setForeground(Color.white);
		playerPanel.add(hpLabelText);
		hpLabelNumber = new JLabel();
		hpLabelNumber.setFont(normalFont);
		hpLabelNumber.setForeground(Color.white);
		playerPanel.add(hpLabelNumber);
		
		/* Weapon */
		weaponLabelText = new JLabel("Weapon: ");
		weaponLabelText.setFont(normalFont);
		weaponLabelText.setForeground(Color.white);
		playerPanel.add(weaponLabelText);
		weaponLabelName = new JLabel();
		weaponLabelName.setFont(normalFont);
		weaponLabelName.setForeground(Color.white);
		playerPanel.add(weaponLabelName);
		
		con.add(playerPanel);
		
		/* Set player */
		playerSetup();
		
	}
	
	public void playerSetup() {
		
		playerHP = 15;
		weapon = "Knife";
		
		hpLabelNumber.setText(Integer.toString(playerHP));
		weaponLabelName.setText(weapon);
		
	}
	
	public class TitleScreenHandler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			createGameScreen(); // result of button click
			
		}
	}

}
