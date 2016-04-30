package diceGame;

import java.io.*;

/**
 * The GameStats class is sued to record the game stats to the database as a history file. 
 * It also reads from the file and prints it if the player wishes to see the stats.
 * 
 * @author Mauricio Gutierrez for CSE 360, PIN: 402
 * @version April 15, 2016
 * 
 */
public class GameStats {
	
	private int winner;
	
	private String newGame = "******************************************************************************************\n"
						   + "*********                            NEW GAME STARTED                            *********\n"
						   + "******************************************************************************************\n";
	
	/**
	 * updateHistory - a function to append to the history file the stats of the game that has just been played.
	 * If there is no history file then it creates a brand new one as "StatsHistory.txt".
	 * 
	 * @throws IOException - if the file cannot be accessed
	 * 
	 * @param playerList - an array list of all the current players in the game
	 */
	public void updateHistory(Player[] playerList) throws IOException
	{
	    File output = new File("StatsHistory.txt");
	    FileWriter fWriter = new FileWriter (output, true); // to append to history file
	    BufferedWriter bWriter = new BufferedWriter(fWriter);
	    PrintWriter printer = new PrintWriter(bWriter);
	    printer.println(newGame);
		for(int playerIndex = 0; playerIndex < playerList.length; playerIndex++)
		{
			printer.println("Player " + (playerIndex + 1) + ": " + playerList[playerIndex].getName());
			printer.println("	Game Score: " + playerList[playerIndex].getScore());
			printer.println("	Rounds Won: " + playerList[playerIndex].getRoundWins());
			printer.println("	Points Spent: " + playerList[playerIndex].getPointsSpent());
			printer.println("	Points Earned: " + playerList[playerIndex].getPointsEarned());	
			printer.println("	Number of Actions Used: " + playerList[playerIndex].getActionsUsed());
			if(playerList[playerIndex].isWinner() == 1)
			{
				winner = playerIndex;
			}
		}
		printer.println("The Winner is: " + playerList[winner].getName() + "!");
		printer.close();
	}
	
	/**
	 * printHistory - a function to read from the "StatsHistory.txt" and print all its info to the screen for the player to see.
	 * 
	 * @throws IOException - if the file cannot be accessed
	 */
	public void printHistory() throws IOException
	{
		FileReader fReader = new FileReader("StatsHistory.txt");
		BufferedReader bReader = new BufferedReader(fReader);
		String line = bReader.readLine();
		while (line != null)
		{
			System.out.println(line);
			line = bReader.readLine();
		}
		bReader.close();
	}
}
