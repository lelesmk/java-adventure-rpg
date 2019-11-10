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
	
	int playerHP, monsterHP, silverRing;
	String weapon, position;
	
	TitleScreenHandler tsHandler = new TitleScreenHandler(); // listen for start button click
	ChoiceHandler choiceHandler = new ChoiceHandler(); // listen for choice button click
	
	
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
	
	

	/* Game Screen */
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
		choice1btn.addActionListener(choiceHandler); // call choice result on click
		choice1btn.setActionCommand("c1"); // set click to c1 so program knows which option was clicked
		choiceButtonPanel.add(choice1btn);
		
		choice2btn = new JButton("Choice 2");
		choice2btn.setBackground(Color.black);
		choice2btn.setForeground(Color.black);
		choice2btn.setFont(buttonFont);
		choice2btn.addActionListener(choiceHandler); // call choice result on click
		choice2btn.setActionCommand("c2"); // set click to c2 so program knows which option was clicked
		choiceButtonPanel.add(choice2btn);
		
		choice3btn = new JButton("Choice 3");
		choice3btn.setBackground(Color.black);
		choice3btn.setForeground(Color.black);
		choice3btn.setFont(buttonFont);
		choice3btn.addActionListener(choiceHandler); // call choice result on click
		choice3btn.setActionCommand("c3"); // set click to c3 so program knows which option was clicked
		choiceButtonPanel.add(choice3btn);
		
		choice4btn = new JButton("Choice 4");
		choice4btn.setBackground(Color.black);
		choice4btn.setForeground(Color.black);
		choice4btn.setFont(buttonFont);
		choice4btn.addActionListener(choiceHandler); // call choice result on click
		choice4btn.setActionCommand("c4"); // set click to c4 so program knows which option was clicked
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
		playSetup();
		
	}
	
	/* Initialize play */
	public void playSetup() {
		
		monsterHP = 20;
		playerHP = 15;
		weapon = "Knife";
		
		hpLabelNumber.setText(Integer.toString(playerHP));
		weaponLabelName.setText(weapon);
		
		/* Player arrives at town gate */
		townGate();
	}
	
	/* Town Gate */
	public void townGate() {
		
		position = "townGate";
		
		/* Player question */
		bodyTextArea.setText("You are at the gate of the town. \nA guard is standing in front of you. \n\nWhat do you do?");
		
		/* Player answer */
		choice1btn.setText("Talk to the guard");
		choice2btn.setText("Attack the guard");
		choice3btn.setText("Leave");
		choice4btn.setText("");
		choice1btn.setVisible(true);
		choice2btn.setVisible(true);
		choice3btn.setVisible(true);
		choice4btn.setVisible(false);
		
	}
	
	public void talkGuard() {
		
		position = "talkGuard";
		
		bodyTextArea.setText("Guard: Hello stranger. I have never seen your \nface. I'm sorry but we cannot let a stranger enter \nour town.");
		
		/* Player answer */
		choice1btn.setText(">> continue >>");
		choice2btn.setText("");
		choice3btn.setText("");
		choice4btn.setText("");
		choice1btn.setVisible(true);
		choice2btn.setVisible(false);
		choice3btn.setVisible(false);
		choice4btn.setVisible(false);
		
		
	}
	
	public void attackGuard() {
		
		position = "attackGuard";
		
		bodyTextArea.setText("Guard: Hey don't be stupid!\n\nThe guard fought back and hit you hard.\n(You receive 3 damage)");
		/* Reduce player health points */
		playerHP = playerHP - 3;
		hpLabelNumber.setText(Integer.toString(playerHP));
		/* Player answer */
		choice1btn.setText(">> continue >>");
		choice2btn.setText("");
		choice3btn.setText("");
		choice4btn.setText("");
		choice1btn.setVisible(true);
		choice2btn.setVisible(false);
		choice3btn.setVisible(false);
		choice4btn.setVisible(false);
		
	}
	
	public void crossRoad() {
		
		position = "crossRoad";
		
		bodyTextArea.setText("You are at a crossroad.\nIf you go south, you will go back to the town.");
		
		/* Player answer */
		choice1btn.setText("Go north");
		choice2btn.setText("Go east");
		choice3btn.setText("Go south");
		choice4btn.setText("Go west");
		choice1btn.setVisible(true);
		choice2btn.setVisible(true);
		choice3btn.setVisible(true);
		choice4btn.setVisible(true);
		
	}
	
	public void north() {
		position = "north";
		
		bodyTextArea.setText("There is a river.\nYou drink the water and rest at the riverside.\n\n(Your health has recovered by 2 points.)");
		/* Recover player health points */
		playerHP = playerHP + 2; // set health points
		hpLabelNumber.setText(Integer.toString(playerHP)); // display health points
		
		/* Player answer */
		choice1btn.setText("Go south");
		choice2btn.setText("");
		choice3btn.setText("");
		choice4btn.setText("");
		choice1btn.setVisible(true);
		choice2btn.setVisible(false);
		choice3btn.setVisible(false);
		choice4btn.setVisible(false);
	}
	
	public void east() {
		position = "east";

		bodyTextArea.setText("You walked into a forest and found a Long Sword!\n\n(You obtained a Long Sword)");
		/* Recover player health points */
		weapon = "Long Sword"; // set weapon
		weaponLabelName.setText(weapon); // display weapon

		/* Player answer */
		choice1btn.setText("Go west");
		choice2btn.setText("");
		choice3btn.setText("");
		choice4btn.setText("");
		choice1btn.setVisible(true);
		choice2btn.setVisible(false);
		choice3btn.setVisible(false);
		choice4btn.setVisible(false);
	}
	
	public void west() {
		position = "west";

		bodyTextArea.setText("You encounter a goblin!");

		/* Player answer */
		choice1btn.setText("Fight");
		choice2btn.setText("Run");
		choice3btn.setText("");
		choice4btn.setText("");
		choice1btn.setVisible(true);
		choice2btn.setVisible(true);
		choice3btn.setVisible(false);
		choice4btn.setVisible(false);
	}
	
	public void fight() {
		position = "fight";

		bodyTextArea.setText("Monster HP: " + monsterHP + "\n\nWhat do you do?");
		/* Recover player health points */
		weapon = "Long Sword"; // set weapon
		weaponLabelName.setText(weapon); // display weapon

		/* Player answer */
		choice1btn.setText("Attack");
		choice2btn.setText("Run");
		choice3btn.setText("");
		choice4btn.setText("");
		choice1btn.setVisible(true);
		choice2btn.setVisible(true);
		choice3btn.setVisible(false);
		choice4btn.setVisible(false);
	}
	
	public void playerAttack() {
		position = "playerAttack";
		
		int playerDamage = 0; // initialize player damage
		
		/* Set damage based on weapon */
		if(weapon.equals("Knife")) {
			playerDamage = new java.util.Random().nextInt(3); // set damage at random number from 0 to 2
		} else if(weapon.equals("Long Sword")) {
			playerDamage = new java.util.Random().nextInt(12); // set damage at random number from 0 to 7
		}
		
		bodyTextArea.setText("You attacked the monster and gave " + playerDamage + " damage!");
		/* Apply player damage to monster */
		monsterHP = monsterHP - playerDamage; // set monster health points

		/* Player answer */
		choice1btn.setText(">> continue >>");
		choice2btn.setText("");
		choice3btn.setText("");
		choice4btn.setText("");
		choice1btn.setVisible(true);
		choice2btn.setVisible(false);
		choice3btn.setVisible(false);
		choice4btn.setVisible(false);
	}
	
	public void monsterAttack() {
		position = "monsterAttack";
		
		int monsterDamage = 0; // initialize player damage
		
		/* Set damage based on weapon */
		monsterDamage = new java.util.Random().nextInt(6); // set damage at random number from 0 to 5
		
		
		bodyTextArea.setText("The monster attacked you and gave " + monsterDamage + " damage!");
		/* Apply player damage to monster */
		playerHP = playerHP - monsterDamage; // set monster health points
		hpLabelNumber.setText(Integer.toString(playerHP)); // display health points

		/* Player answer */
		choice1btn.setText(">> continue >>");
		choice2btn.setText("");
		choice3btn.setText("");
		choice4btn.setText("");
		choice1btn.setVisible(true);
		choice2btn.setVisible(false);
		choice3btn.setVisible(false);
		choice4btn.setVisible(false);
	}
	
	public void win() {
		
		position = "win";
		
		bodyTextArea.setText("You defeated the monster!\nThe monster dropped the ring!\n\n(You obtained a Silver Ring)");
		
		silverRing = 1;
		
		/* Player answer */
		choice1btn.setText("Go east"); // go back to crossRoad
		choice2btn.setText("");
		choice3btn.setText("");
		choice4btn.setText("");
		choice1btn.setVisible(true);
		choice2btn.setVisible(false);
		choice3btn.setVisible(false);
		choice4btn.setVisible(false);

	}

	public void lose() {
		
		position = "lose";
		
		bodyTextArea.setText("You are dead!\n\n<GAME OVER>");
		
		/* Player answer */
		choice1btn.setText("");
		choice2btn.setText("");
		choice3btn.setText("");
		choice4btn.setText("");
		choice1btn.setVisible(false);
		choice2btn.setVisible(false);
		choice3btn.setVisible(false);
		choice4btn.setVisible(false);

	}
	
	public void ending() {

		position = "ending";

		bodyTextArea.setText("Guard: Oh you killed that goblin?\nThank you so much. You are a true hero!\nWelcome to our town!\n\n<THE END>");

		/* Player answer */
		choice1btn.setText("");
		choice2btn.setText("");
		choice3btn.setText("");
		choice4btn.setText("");
		choice1btn.setVisible(false);
		choice2btn.setVisible(false);
		choice3btn.setVisible(false);
		choice4btn.setVisible(false);

	}
	
	/* Start Button Click Event Handler */
	public class TitleScreenHandler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent event) {
			
			createGameScreen(); // result of start button click
			
		}
	}
	
	/* Choice Button Click Event Handler */
	public class ChoiceHandler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent event) {
			
			
			// result of choice button click
			
			String yourChoice = event.getActionCommand(); // set choice to choice button clicked
			
			switch(position) {
			// If player is at the town gate	
			case "townGate":
				switch(yourChoice) {
				case "c1": 
					// If you have the silver ring
					if(silverRing == 1) {
						ending(); // the end of the game
					} else {
						talkGuard();
					} 
					break; // button 1 switch position to talkGuard
				case "c2": attackGuard(); break; // button 2 switch position to attackGuard
				case "c3": crossRoad(); break; // button 3 switch position to crossRoad
				}
				break;
			// If player talks to the guard
			case "talkGuard":
				switch(yourChoice) {
				case "c1": townGate(); break; // button 1 go back to townGate
				}
				break;
			// If player attacks guard
			case "attackGuard":
				switch(yourChoice) {
				case "c1": townGate(); break; // button 1 switch position to townGate
				}
				break;
			// If player is at crossRoad
			case "crossRoad":
				switch(yourChoice) {
				case "c1": north(); break; // button 1 switch position to north
				case "c2": east(); break; // button 2 switch position to east
				case "c3": townGate(); break; // button 3 switch position to townGate
				case "c4": west(); break; // button 4 switch position to west
				}
				break;
			// If player goes north
			case "north":
				switch(yourChoice) {
				case "c1": crossRoad(); break; // button 1 switch position to crossRoad
				}
				break;
			// If player goes east
			case "east":
				switch(yourChoice) {
				case "c1": crossRoad(); break; // button 1 switch position to crossRoad
				}
				break;
			// If player goes west
			case "west":
				switch(yourChoice) {
				case "c1": fight(); break; // button 1 switch position to fight
				case "c2": crossRoad(); break; // button 2 switch position to crossRoad
				}
				break;
			// If player chooses to fight
			case "fight":
				switch(yourChoice) {
				case "c1": playerAttack(); break; // button 1 switch position to playerAttack
				case "c2": crossRoad(); break; // button 2 switch position to crossRoad
				}
				break;
			// If player attacks
			case "playerAttack":
				switch(yourChoice) {
				case "c1": 
					// Check if monster is alive
					if(monsterHP < 1) {
						win();
					} else {
						monsterAttack(); // button 1 switch position to monsterAttack
					}
					break;
				}
				break;
			// If monster attacks
			case "monsterAttack":
				switch(yourChoice) {
				case "c1": 
					// Check if player is alive
					if(playerHP < 1) {
						lose();
					} else {
						fight(); // button 1 switch position to fight
					}
					break;
				}
				break;
			// If player kills the monster
			case "win":
				switch(yourChoice) {
				case "c1": townGate(); break; // button 1 switch position to townGate
				}
				break;
			}
			
			
		}
	}

}
