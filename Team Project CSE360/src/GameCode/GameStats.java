package diceGame;

import java.io.*;

public class GameStats {
	
	private int winner;
	
	private String newGame = "******************************************************************************************\n"
						   + "*********                            NEW GAME STARTED                            *********\n"
						   + "******************************************************************************************\n";
	
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
