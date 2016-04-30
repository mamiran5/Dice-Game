package cse360proj1Test;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import java.awt.ScrollPane;
import java.awt.Scrollbar;

public class DiceGame{

	private JFrame frame;
	private JTextField playerNameTF;
	private JTextField pairDiceOne1;
	private JTextField pairDiceTwo1;
	private JTextField pairDiceOne2;
	private JTextField pairDiceTwo2;
	private JTextField pairDiceOne3;
	private JTextField pairDiceTwo3;
	private JTextField attackPlayerTF1;
	private JTextField attackPlayerTF2;
	private JTextField attackPlayerTF3;
	private int gameSize = 0;
	//private boolean twoPlayers;
	//private boolean threePlayers;
	//private boolean fourPlayers;
	//private int beginPanelIndex;
	//private boolean beginPanelCheck = true;

	//Set up Driver
	GameDriver gameDriver = new GameDriver();
	
	
	/**
	 * Launch the application.
	 * @wbp.parser.entryPoint
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DiceGame window = new DiceGame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public DiceGame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 739, 547);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		//ImageIcon dice1Icon = new ImageIcon(getClass().getResource("C:\\Users\\Marqwon\\Desktop\\Dice Game 1.png"));
		
		// end player count panel
		
		// begin the welcome panel
		
		JPanel welcomePanel = new JPanel();
		frame.getContentPane().add(welcomePanel, "name_531635098628720");
		welcomePanel.setLayout(null);
		welcomePanel.setVisible(true);
		
		JButton addPlayerButton = new JButton("Add New Player");
		addPlayerButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		addPlayerButton.setBounds(0, 390, 357, 110);
		welcomePanel.add(addPlayerButton);
		
		JButton startGameButton = new JButton("Start Game");
		startGameButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		startGameButton.setBounds(364, 390, 357, 110);
		welcomePanel.add(startGameButton);
		
		JLabel welcomeLabel = new JLabel("Welcome to <Insert Game Title Here>!");
		welcomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabel.setBounds(59, 13, 596, 57);
		welcomePanel.add(welcomeLabel);
		
		JLabel instructionLabel = new JLabel("Add players to the game before you start!");
		instructionLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		instructionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		instructionLabel.setBounds(148, 292, 404, 42);
		welcomePanel.add(instructionLabel);
		
		JLabel tooLittleErrorLabel = new JLabel("Game must have at least 1 player!");
		tooLittleErrorLabel.setForeground(Color.RED);
		tooLittleErrorLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tooLittleErrorLabel.setBounds(406, 361, 264, 27);
		welcomePanel.add(tooLittleErrorLabel);
		tooLittleErrorLabel.setVisible(false);
		
		JLabel tooMuchErrorLabel = new JLabel("Game can only have up to 4 players!");
		tooMuchErrorLabel.setForeground(Color.RED);
		tooMuchErrorLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tooMuchErrorLabel.setBounds(44, 361, 270, 23);
		welcomePanel.add(tooMuchErrorLabel);
		tooMuchErrorLabel.setVisible(false);
		
		JLabel player1Label = new JLabel("Player 1:");
		player1Label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		player1Label.setBounds(12, 98, 65, 25);
		welcomePanel.add(player1Label);
		player1Label.setVisible(false);
		
		JLabel player1NameLabel = new JLabel("player1Name");
		player1NameLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		player1NameLabel.setBounds(89, 98, 165, 27);
		welcomePanel.add(player1NameLabel);
		player1NameLabel.setVisible(false);
		
		JLabel player2Label = new JLabel("Player 2:");
		player2Label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		player2Label.setBounds(12, 152, 65, 25);
		welcomePanel.add(player2Label);
		player2Label.setVisible(false);
		
		JLabel player2NameLabel = new JLabel("player2Name");
		player2NameLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		player2NameLabel.setBounds(89, 151, 165, 27);
		welcomePanel.add(player2NameLabel);
		player2NameLabel.setVisible(false);
		
		JLabel player3Label = new JLabel("Player 3:");
		player3Label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		player3Label.setBounds(12, 204, 65, 25);
		welcomePanel.add(player3Label);
		player3Label.setVisible(false);
		
		JLabel player3NameLabel = new JLabel("player3Name");
		player3NameLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		player3NameLabel.setBounds(89, 203, 165, 27);
		welcomePanel.add(player3NameLabel);
		player3NameLabel.setVisible(false);
		
		JLabel player4Label = new JLabel("Player 4:");
		player4Label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		player4Label.setBounds(12, 253, 65, 25);
		welcomePanel.add(player4Label);
		player4Label.setVisible(false);
		
		JLabel player4NameLabel = new JLabel("player4Name");
		player4NameLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		player4NameLabel.setBounds(89, 252, 165, 27);
		welcomePanel.add(player4NameLabel);
		player4NameLabel.setVisible(false);
		
		// end the welcome panel
		
		// begin the begin game panel to enter the players names
		
		JPanel beginPanel = new JPanel();
		frame.getContentPane().add(beginPanel, "name_367137273659616");
		beginPanel.setLayout(null);
		beginPanel.setVisible(false);
		
		JLabel enterNameLabel = new JLabel("Enter your name:");
		enterNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		enterNameLabel.setBounds(169, 216, 155, 22);
		beginPanel.add(enterNameLabel);
		
		playerNameTF = new JTextField();
		playerNameTF.setFont(new Font("Tahoma", Font.PLAIN, 20));
		playerNameTF.setBounds(336, 216, 218, 22);
		beginPanel.add(playerNameTF);
		playerNameTF.setColumns(10);
		
		JButton enterButton = new JButton("Enter");
		enterButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		enterButton.setBounds(259, 245, 203, 50);
		beginPanel.add(enterButton);
		
		JLabel nameErrorLabel = new JLabel("You must enter a name first!");
		nameErrorLabel.setForeground(Color.RED);
		nameErrorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameErrorLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		nameErrorLabel.setBounds(219, 308, 257, 22);
		beginPanel.add(nameErrorLabel);
		nameErrorLabel.setVisible(false);
		
		// end the begin game panel
		
		// begin the turn 1 panel
		
		JPanel turn1Panel = new JPanel();
		frame.getContentPane().add(turn1Panel, "name_367142879603335");
		turn1Panel.setLayout(null);
		turn1Panel.setVisible(false);
		
		JButton turn1Button = new JButton("Turn 1");
		turn1Button.setFont(new Font("Tahoma", Font.PLAIN, 38));
		turn1Button.setBounds(0, 0, 721, 500);
		turn1Panel.add(turn1Button);
		
		// end the turn 1 panel
		
		// begin the turn 2 panel
		
		JPanel turn2Panel = new JPanel();
		frame.getContentPane().add(turn2Panel, "name_367152099556187");
		turn2Panel.setLayout(null);
		turn2Panel.setVisible(false);
		
		JButton turn2Button = new JButton("Turn 2");
		turn2Button.setFont(new Font("Tahoma", Font.PLAIN, 38));
		turn2Button.setBounds(0, 0, 721, 500);
		turn2Panel.add(turn2Button);
		
		// end the turn 2 panel
		
		// begin the turn 3 panel
		
		JPanel turn3Panel = new JPanel();
		frame.getContentPane().add(turn3Panel, "name_367194793283143");
		turn3Panel.setLayout(null);
		turn3Panel.setVisible(false);
		
		JButton turn3Button = new JButton("Turn 3");
		turn3Button.setFont(new Font("Tahoma", Font.PLAIN, 38));
		turn3Button.setBounds(0, 0, 721, 500);
		turn3Panel.add(turn3Button);
		
		// end the turn 3 panel
		
		// begin the roll dice panel
		
		JPanel rollDicePanel = new JPanel();
		frame.getContentPane().add(rollDicePanel, "name_367207112608369");
		rollDicePanel.setLayout(null);
		rollDicePanel.setVisible(false);
		
		JButton rollDiceButton = new JButton("Roll Dice");
		rollDiceButton.setFont(new Font("Tahoma", Font.PLAIN, 38));
		rollDiceButton.setBounds(0, 290, 361, 100);
		rollDicePanel.add(rollDiceButton);
		
		JButton nextButton = new JButton("Next");
		nextButton.setFont(new Font("Tahoma", Font.PLAIN, 38));
		nextButton.setBounds(0, 403, 721, 97);
		rollDicePanel.add(nextButton);
		
		JLabel die1ImageLabel = new JLabel("Die 1");
		die1ImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		die1ImageLabel.setBounds(70, 13, 125, 113);
		rollDicePanel.add(die1ImageLabel);
		
		JLabel die2ImageLabel = new JLabel("Die 2");
		die2ImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		die2ImageLabel.setBounds(273, 13, 125, 113);
		rollDicePanel.add(die2ImageLabel);
		
		JLabel die3ImageLabel = new JLabel("Die 3");
		die3ImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		die3ImageLabel.setBounds(469, 13, 125, 113);
		rollDicePanel.add(die3ImageLabel);
		
		JLabel die4ImageLabel = new JLabel("Die 4");
		die4ImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		die4ImageLabel.setBounds(70, 164, 125, 113);
		rollDicePanel.add(die4ImageLabel);
		
		JLabel die5ImageLabel = new JLabel("Die 5");
		die5ImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		die5ImageLabel.setBounds(273, 164, 125, 113);
		rollDicePanel.add(die5ImageLabel);
		
		JLabel die6ImageLabel = new JLabel("Die 6");
		die6ImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		die6ImageLabel.setBounds(469, 164, 125, 113);
		rollDicePanel.add(die6ImageLabel);
		
		JButton rerollDiceButton = new JButton("Re-Roll");
		rerollDiceButton.setFont(new Font("Tahoma", Font.PLAIN, 38));
		rerollDiceButton.setBounds(373, 290, 348, 100);
		rollDicePanel.add(rerollDiceButton);

		// end the roll dice panel
		
		// begin the pair dice panel
		
		JPanel pairDicePanel = new JPanel();
		frame.getContentPane().add(pairDicePanel, "name_367285440542054");
		pairDicePanel.setLayout(null);
		pairDicePanel.setVisible(false);
		
		JLabel dicePairLabel = new JLabel("What dice would you like to pair?");
		dicePairLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		dicePairLabel.setBounds(117, 13, 453, 37);
		pairDicePanel.add(dicePairLabel);
		
		JLabel dicePair1Label = new JLabel("Pair 1:");
		dicePair1Label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		dicePair1Label.setHorizontalAlignment(SwingConstants.CENTER);
		dicePair1Label.setBounds(12, 122, 73, 16);
		pairDicePanel.add(dicePair1Label);
		
		pairDiceOne1 = new JTextField();
		pairDiceOne1.setHorizontalAlignment(SwingConstants.CENTER);
		pairDiceOne1.setBounds(97, 122, 49, 22);
		pairDicePanel.add(pairDiceOne1);
		pairDiceOne1.setColumns(10);
		
		pairDiceTwo1 = new JTextField();
		pairDiceTwo1.setHorizontalAlignment(SwingConstants.CENTER);
		pairDiceTwo1.setBounds(158, 122, 49, 22);
		pairDicePanel.add(pairDiceTwo1);
		pairDiceTwo1.setColumns(10);
		
		JLabel dicePair2Label = new JLabel("Pair 2:");
		dicePair2Label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		dicePair2Label.setHorizontalAlignment(SwingConstants.CENTER);
		dicePair2Label.setBounds(12, 205, 73, 16);
		pairDicePanel.add(dicePair2Label);
		
		pairDiceOne2 = new JTextField();
		pairDiceOne2.setHorizontalAlignment(SwingConstants.RIGHT);
		pairDiceOne2.setBounds(97, 205, 49, 22);
		pairDicePanel.add(pairDiceOne2);
		pairDiceOne2.setColumns(10);
		
		pairDiceTwo2 = new JTextField();
		pairDiceTwo2.setHorizontalAlignment(SwingConstants.CENTER);
		pairDiceTwo2.setBounds(158, 205, 49, 22);
		pairDicePanel.add(pairDiceTwo2);
		pairDiceTwo2.setColumns(10);
		
		JLabel dicePair3Label = new JLabel("Pair 3:");
		dicePair3Label.setHorizontalAlignment(SwingConstants.CENTER);
		dicePair3Label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		dicePair3Label.setBounds(12, 284, 73, 16);
		pairDicePanel.add(dicePair3Label);
		
		pairDiceOne3 = new JTextField();
		pairDiceOne3.setHorizontalAlignment(SwingConstants.CENTER);
		pairDiceOne3.setBounds(97, 284, 49, 22);
		pairDicePanel.add(pairDiceOne3);
		pairDiceOne3.setColumns(10);
		
		pairDiceTwo3 = new JTextField();
		pairDiceTwo3.setHorizontalAlignment(SwingConstants.CENTER);
		pairDiceTwo3.setBounds(158, 284, 49, 22);
		pairDicePanel.add(pairDiceTwo3);
		pairDiceTwo3.setColumns(10);
		
		JButton pairButton = new JButton("Pair!");
		pairButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		pairButton.setBounds(12, 349, 195, 63);
		pairDicePanel.add(pairButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(405, 83, 56, 16);
		pairDicePanel.add(lblNewLabel);
		
		JLabel dicePairError1Label = new JLabel("Check your dice pairs!");
		dicePairError1Label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		dicePairError1Label.setForeground(Color.RED);
		dicePairError1Label.setBounds(12, 414, 195, 27);
		pairDicePanel.add(dicePairError1Label);
		dicePairError1Label.setVisible(false);
		
		JLabel dicePairError2Label = new JLabel("(Each die can only be used once!)");
		dicePairError2Label.setForeground(Color.RED);
		dicePairError2Label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		dicePairError2Label.setBounds(12, 439, 258, 22);
		pairDicePanel.add(dicePairError2Label);
		dicePairError2Label.setVisible(false);
		
		JLabel blankDicePair1ErrorLabel = new JLabel("Enter a dice pair!");
		blankDicePair1ErrorLabel.setForeground(Color.RED);
		blankDicePair1ErrorLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		blankDicePair1ErrorLabel.setBounds(22, 151, 185, 22);
		pairDicePanel.add(blankDicePair1ErrorLabel);
		blankDicePair1ErrorLabel.setVisible(false);
		
		JLabel blankDicePair2ErrorLabel = new JLabel("Enter a dice pair!");
		blankDicePair2ErrorLabel.setForeground(Color.RED);
		blankDicePair2ErrorLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		blankDicePair2ErrorLabel.setBounds(22, 236, 185, 22);
		pairDicePanel.add(blankDicePair2ErrorLabel);
		blankDicePair2ErrorLabel.setVisible(false);
		
		JLabel blankDicePair3ErrorLabel = new JLabel("Enter a dice pair!");
		blankDicePair3ErrorLabel.setForeground(Color.RED);
		blankDicePair3ErrorLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		blankDicePair3ErrorLabel.setBounds(22, 314, 185, 22);
		pairDicePanel.add(blankDicePair3ErrorLabel);
		blankDicePair3ErrorLabel.setVisible(false);
		
		// end the dice pair panel
		
		// begin the attack panel
		
		JPanel attackPanel = new JPanel();
		frame.getContentPane().add(attackPanel, "name_367291419902653");
		attackPanel.setLayout(null);
		attackPanel.setVisible(false);
		
		JLabel player1ScoreLabel = new JLabel("Player 1 Score:");
		player1ScoreLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		player1ScoreLabel.setBounds(12, 15, 134, 16);
		attackPanel.add(player1ScoreLabel);
		
		JLabel player1Score = new JLabel("Score1");
		player1Score.setFont(new Font("Tahoma", Font.PLAIN, 17));
		player1Score.setBounds(158, 16, 93, 16);
		attackPanel.add(player1Score);
		
		JLabel player2ScoreLabel = new JLabel("Player 2 Score:");
		player2ScoreLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		player2ScoreLabel.setBounds(12, 46, 134, 16);
		attackPanel.add(player2ScoreLabel);
		
		JLabel player2Score = new JLabel("Score2");
		player2Score.setFont(new Font("Tahoma", Font.PLAIN, 17));
		player2Score.setBounds(158, 47, 93, 16);
		attackPanel.add(player2Score);
		
		JLabel player3ScoreLabel = new JLabel("Player 3 Score:");
		player3ScoreLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		player3ScoreLabel.setBounds(12, 77, 134, 16);
		attackPanel.add(player3ScoreLabel);
		
		JLabel player3Score = new JLabel("Score3");
		player3Score.setFont(new Font("Tahoma", Font.PLAIN, 17));
		player3Score.setBounds(158, 78, 93, 16);
		attackPanel.add(player3Score);
		
		JLabel player4ScoreLabel = new JLabel("Player 4 Score:");
		player4ScoreLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		player4ScoreLabel.setBounds(12, 108, 134, 16);
		attackPanel.add(player4ScoreLabel);
		
		JLabel player4Score = new JLabel("Score4");
		player4Score.setFont(new Font("Tahoma", Font.PLAIN, 17));
		player4Score.setBounds(158, 109, 93, 16);
		attackPanel.add(player4Score);
		
		JLabel attackQuestionLabel = new JLabel("Who would you like to attack in each round? How?");
		attackQuestionLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		attackQuestionLabel.setBounds(318, 15, 391, 54);
		attackPanel.add(attackQuestionLabel);
		
		JLabel round1Label = new JLabel("Round 1:");
		round1Label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		round1Label.setBounds(318, 80, 76, 16);
		attackPanel.add(round1Label);
		
		ButtonGroup attackButtons1 = new ButtonGroup();
		ButtonGroup attackButtons2 = new ButtonGroup();
		ButtonGroup attackButtons3 = new ButtonGroup();
		
		attackPlayerTF1 = new JTextField();
		attackPlayerTF1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		attackPlayerTF1.setBounds(406, 77, 209, 22);
		attackPanel.add(attackPlayerTF1);
		attackPlayerTF1.setColumns(10);
		
		JRadioButton hindranceButton1 = new JRadioButton("Hindrance!");
		hindranceButton1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		hindranceButton1.setBounds(318, 126, 127, 25);
		attackPanel.add(hindranceButton1);
		
		JRadioButton luckyDiceButton1 = new JRadioButton("Lucky Dice!");
		luckyDiceButton1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		luckyDiceButton1.setBounds(449, 128, 127, 25);
		attackPanel.add(luckyDiceButton1);
		
		JRadioButton diceBlockButton1 = new JRadioButton("Dice Block!");
		diceBlockButton1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		diceBlockButton1.setBounds(318, 168, 127, 25);
		attackPanel.add(diceBlockButton1);
		
		attackButtons1.add(hindranceButton1);
		attackButtons1.add(luckyDiceButton1);
		attackButtons1.add(diceBlockButton1);
		
		JLabel round2Label = new JLabel("Round 2:");
		round2Label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		round2Label.setBounds(318, 216, 76, 16);
		attackPanel.add(round2Label);
		
		attackPlayerTF2 = new JTextField();
		attackPlayerTF2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		attackPlayerTF2.setBounds(406, 213, 209, 22);
		attackPanel.add(attackPlayerTF2);
		attackPlayerTF2.setColumns(10);
		
		JRadioButton hindranceButton2 = new JRadioButton("Hindrance!");
		hindranceButton2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		hindranceButton2.setBounds(318, 267, 127, 25);
		attackPanel.add(hindranceButton2);
		
		JRadioButton luckyDiceButton2 = new JRadioButton("Lucky Dice!");
		luckyDiceButton2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		luckyDiceButton2.setBounds(449, 267, 127, 25);
		attackPanel.add(luckyDiceButton2);
		
		JRadioButton diceBlockButton2 = new JRadioButton("Dice Block!");
		diceBlockButton2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		diceBlockButton2.setBounds(318, 307, 127, 25);
		attackPanel.add(diceBlockButton2);
		
		attackButtons2.add(hindranceButton2);
		attackButtons2.add(luckyDiceButton2);
		attackButtons2.add(diceBlockButton2);
		
		JLabel round3Label = new JLabel("Round 3:");
		round3Label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		round3Label.setBounds(318, 354, 76, 16);
		attackPanel.add(round3Label);
		
		attackPlayerTF3 = new JTextField();
		attackPlayerTF3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		attackPlayerTF3.setBounds(406, 353, 209, 22);
		attackPanel.add(attackPlayerTF3);
		attackPlayerTF3.setColumns(10);
		
		JRadioButton hindranceButton3 = new JRadioButton("Hindrance!");
		hindranceButton3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		hindranceButton3.setBounds(318, 402, 127, 25);
		attackPanel.add(hindranceButton3);
		
		JRadioButton luckyDiceButton3 = new JRadioButton("Lucky Dice!");
		luckyDiceButton3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		luckyDiceButton3.setBounds(449, 402, 127, 25);
		attackPanel.add(luckyDiceButton3);
		
		JRadioButton diceBlockButton3 = new JRadioButton("Dice Block!");
		diceBlockButton3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		diceBlockButton3.setBounds(318, 440, 127, 25);
		attackPanel.add(diceBlockButton3);
		
		attackButtons3.add(hindranceButton3);
		attackButtons3.add(luckyDiceButton3);
		attackButtons3.add(diceBlockButton3);
		
		JLabel playerDicePairLabel = new JLabel("Your Dice Pairs");
		playerDicePairLabel.setHorizontalAlignment(SwingConstants.CENTER);
		playerDicePairLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		playerDicePairLabel.setBounds(60, 168, 127, 16);
		attackPanel.add(playerDicePairLabel);
		
		JButton attackButton = new JButton("Attack!");
		attackButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		attackButton.setBounds(12, 433, 239, 54);
		attackPanel.add(attackButton);
		
		// end attack panel
		
		// begin winner panel
		
		JPanel winnerPanel = new JPanel();
		frame.getContentPane().add(winnerPanel, "name_434395284492036");
		winnerPanel.setLayout(null);
		winnerPanel.setVisible(false);
		
		JLabel gameOverLabel = new JLabel("Game Over!");
		gameOverLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
		gameOverLabel.setHorizontalAlignment(SwingConstants.CENTER);
		gameOverLabel.setBounds(249, 13, 220, 49);
		winnerPanel.add(gameOverLabel);
		
		JLabel finalScoreLabel = new JLabel("Final Score:");
		finalScoreLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		finalScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		finalScoreLabel.setBounds(249, 96, 220, 36);
		winnerPanel.add(finalScoreLabel);
		
		
		// Actions to be performed for certain button combinations
		
		// welcome panel actions
		
		addPlayerButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if(gameSize >= 4)
				{
					tooMuchErrorLabel.setVisible(true);
				}
				else
				{
					tooMuchErrorLabel.setVisible(false);
					beginPanel.setVisible(true);
					welcomePanel.setVisible(false);
				}
			}
		});
		
		startGameButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if(gameSize >= 1)
				{
					//tooLittleErrorLabel.setVisible(false);
					turn1Panel.setVisible(true);
					welcomePanel.setVisible(false);
					
					//Fill up with computers. 
					gameDriver.addComputerPlayers();
				}
				else
				{
					tooLittleErrorLabel.setVisible(true);
				}
			}
		});
		
		// end welcome panel actions
		
		// start turn 1 panel actions
		
		turn1Button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				rollDicePanel.setVisible(true);
				turn1Panel.setVisible(false);
				
				//Start Turn!
				gameDriver.startATurn();
				rerollDiceButton.setEnabled(false);
				nextButton.setEnabled(false);
								
			}
		});	
		
		
		// end of turn 1 panel actions
		
		// start begin panel actions
		
		enterButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if(playerNameTF.getText().equals(""))
				{
					nameErrorLabel.setVisible(true);
				}
				else
				{
					gameSize++;
					if(gameSize == 1)
					{
						player1NameLabel.setText(playerNameTF.getText());
						player1Label.setVisible(true);
						player1NameLabel.setVisible(true);
						
						//Create New Player Object
						gameDriver.addPlayer(new Player(playerNameTF.getText(), 500));
					}
					if(gameSize == 2)
					{
						player2NameLabel.setText(playerNameTF.getText());
						player2Label.setVisible(true);
						player2NameLabel.setVisible(true);
						
						//Create New Player Object
						gameDriver.addPlayer(new Player(playerNameTF.getText(), 500));
						
					}if(gameSize == 3)
					{
						player3NameLabel.setText(playerNameTF.getText());
						player3Label.setVisible(true);
						player3NameLabel.setVisible(true);
						
						//Create New Player Object
						gameDriver.addPlayer(new Player(playerNameTF.getText(), 500));
						
					}if(gameSize == 4)
					{
						player4NameLabel.setText(playerNameTF.getText());
						player4Label.setVisible(true);
						player4NameLabel.setVisible(true);
						
						//Create New Player Object
						gameDriver.addPlayer(new Player(playerNameTF.getText(), 500));
					}
					
					playerNameTF.setText("");
					nameErrorLabel.setVisible(false);
					tooLittleErrorLabel.setVisible(false);
					welcomePanel.setVisible(true);
					beginPanel.setVisible(false);
				}
			}
		});
		
		// end begin panel actions
		
		rollDiceButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				
				gameDriver.startRolls();
				rollDiceButton.setEnabled(false);
				//Change Labels
				die1ImageLabel.setText(gameDriver.getDiceListRoll(gameDriver.getCurrPlayers().get(0), 0));
				die2ImageLabel.setText(gameDriver.getDiceListRoll(gameDriver.getCurrPlayers().get(0), 1));
				die3ImageLabel.setText(gameDriver.getDiceListRoll(gameDriver.getCurrPlayers().get(0), 2));
				die4ImageLabel.setText(gameDriver.getDiceListRoll(gameDriver.getCurrPlayers().get(0), 3));
				die5ImageLabel.setText(gameDriver.getDiceListRoll(gameDriver.getCurrPlayers().get(0), 4));
				die6ImageLabel.setText(gameDriver.getDiceListRoll(gameDriver.getCurrPlayers().get(0), 5));
				
				if(die1ImageLabel.getText().equals(1))
				{
					die1ImageLabel.setIcon(new ImageIcon("C:\\Users\\Marqwon\\Desktop\\DiceGame1.png"));
					die1ImageLabel.validate();
				}
				else if(die2ImageLabel.getText().equals(2))
				{
					die2ImageLabel.setIcon(new ImageIcon("C:\\Users\\Marqwon\\Desktop\\DiceGame2.png"));
					die2ImageLabel.validate();
				}
				else if(die3ImageLabel.getText().equals(3))
				{
					die3ImageLabel.setIcon(new ImageIcon("C:\\Users\\Marqwon\\Desktop\\DiceGame3.png"));
					die3ImageLabel.validate();
				}
				else if(die4ImageLabel.getText().equals(4))
				{
					die4ImageLabel.setIcon(new ImageIcon("C:\\Users\\Marqwon\\Desktop\\DiceGame4.png"));
					die4ImageLabel.validate();
				}
				else if(die5ImageLabel.getText().equals(5))
				{
					die5ImageLabel.setIcon(new ImageIcon("C:\\Users\\Marqwon\\Desktop\\DiceGame5.png"));
					die5ImageLabel.validate();
				}
				else if(die6ImageLabel.getText().equals(6))
				{
					die6ImageLabel.setIcon(new ImageIcon("C:\\Users\\Marqwon\\Desktop\\DiceGame6.png"));
					die6ImageLabel.validate();
				}
				

				rerollDiceButton.setEnabled(true);
				nextButton.setEnabled(true);
			}
		});		
		
		rerollDiceButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				
				gameDriver.startRolls();
				//Change Labels
				die1ImageLabel.setText(gameDriver.getDiceListRoll(gameDriver.getCurrPlayers().get(0), 0));
				die2ImageLabel.setText(gameDriver.getDiceListRoll(gameDriver.getCurrPlayers().get(0), 1));
				die3ImageLabel.setText(gameDriver.getDiceListRoll(gameDriver.getCurrPlayers().get(0), 2));
				die4ImageLabel.setText(gameDriver.getDiceListRoll(gameDriver.getCurrPlayers().get(0), 3));
				die5ImageLabel.setText(gameDriver.getDiceListRoll(gameDriver.getCurrPlayers().get(0), 4));
				die6ImageLabel.setText(gameDriver.getDiceListRoll(gameDriver.getCurrPlayers().get(0), 5));
				
				rerollDiceButton.setEnabled(false);
				
			}
		});		
		// begin pair dice panel actions
		
		pairButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if(pairDiceOne1.getText().equals("") || pairDiceTwo1.getText().equals("") || (pairDiceOne1.getText().equals("") && pairDiceTwo1.getText().equals("")))
				{
					blankDicePair1ErrorLabel.setVisible(true);
				}
				if(pairDiceOne2.getText().equals("") || pairDiceTwo2.getText().equals("") || (pairDiceOne2.getText().equals("") && pairDiceTwo2.getText().equals("")))
				{
					blankDicePair2ErrorLabel.setVisible(true);
				}
				if(pairDiceOne3.getText().equals("") || pairDiceTwo3.getText().equals("") || (pairDiceOne3.getText().equals("") && pairDiceTwo3.getText().equals("")))
				{
					blankDicePair3ErrorLabel.setVisible(true);
				}
				if(pairDiceOne1.getText().equals(pairDiceTwo1.getText()) || 
				   pairDiceOne1.getText().equals(pairDiceOne2.getText())  ||
				   pairDiceOne1.getText().equals(pairDiceTwo2.getText())  ||
				   pairDiceOne1.getText().equals(pairDiceOne3.getText())  ||
				   pairDiceOne1.getText().equals(pairDiceTwo3.getText()))
				{
					   dicePairError1Label.setVisible(true);
					   dicePairError2Label.setVisible(true);	   
				}
				if(pairDiceTwo1.getText().equals(pairDiceOne1.getText()) || 
				   pairDiceTwo1.getText().equals(pairDiceOne2.getText()) ||
				   pairDiceTwo1.getText().equals(pairDiceTwo2.getText()) ||
				   pairDiceTwo1.getText().equals(pairDiceOne3.getText()) ||
				   pairDiceTwo1.getText().equals(pairDiceTwo3.getText()))
				{
					   dicePairError1Label.setVisible(true);
					   dicePairError2Label.setVisible(true);	   
				}
				if(pairDiceOne2.getText().equals(pairDiceOne1.getText()) || 
				   pairDiceOne2.getText().equals(pairDiceTwo1.getText()) ||
				   pairDiceOne2.getText().equals(pairDiceTwo2.getText()) ||
				   pairDiceOne2.getText().equals(pairDiceOne3.getText()) ||
				   pairDiceOne2.getText().equals(pairDiceTwo3.getText()))
				{
					   dicePairError1Label.setVisible(true);
					   dicePairError2Label.setVisible(true);	   
				}
				if(pairDiceTwo2.getText().equals(pairDiceOne1.getText()) || 
				   pairDiceTwo2.getText().equals(pairDiceTwo1.getText()) ||
				   pairDiceTwo2.getText().equals(pairDiceOne2.getText()) ||
				   pairDiceTwo2.getText().equals(pairDiceOne3.getText()) ||
				   pairDiceTwo2.getText().equals(pairDiceTwo3.getText()))
				{
					   dicePairError1Label.setVisible(true);
					   dicePairError2Label.setVisible(true);	   
				}
				if(pairDiceOne3.getText().equals(pairDiceOne1.getText()) || 
				   pairDiceOne3.getText().equals(pairDiceTwo1.getText()) ||
				   pairDiceOne3.getText().equals(pairDiceTwo2.getText()) ||
				   pairDiceOne3.getText().equals(pairDiceOne3.getText()) ||
				   pairDiceOne3.getText().equals(pairDiceTwo3.getText()))
				{
					   dicePairError1Label.setVisible(true);
					   dicePairError2Label.setVisible(true);	   
				}
			}
		});
		
		nextButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				rollDicePanel.setVisible(false);
				pairDicePanel.setVisible(true);
			}
		});
			
	}
}
