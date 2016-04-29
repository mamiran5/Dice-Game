package diceGame;

import java.io.*;
import java.util.*;

public class HighScoreStats {
	
	private BufferedReader reader;
	private PrintWriter writer;
	Scanner scan = new Scanner("masterfile.txt");
	
	public HighScoreStats(Player [] playerList) throws FileNotFoundException{
		reader = new BufferedReader(new FileReader("masterfile.txt"));
		writer = new PrintWriter("masterfile.txt");
	}
	
	public void updateMasterFile(Player [] playerList) throws IOException{
		if(!scan.hasNextLine()){
			
			for(int playerIndex = 0; playerIndex < playerList.length; playerIndex++){
				writer.write(playerList[playerIndex].getName());
			}
			
			scan.close();
			
		}
		
		else{
			String newFileInput = "";
			for(int playerIndex = 0; playerIndex < playerList.length; playerIndex++){
				
				boolean newPlayer = true;
				scan = new Scanner("masterfile.txt");
				
				while(scan.hasNextLine()){
				
					String check = reader.readLine();
					
					if(check.equals(playerList[playerIndex].getName())){
						updatePlayerFile(playerList[playerIndex]);
						newPlayer = false;
					}
				
				}
				
				if(newPlayer){
					createPlayerFile(playerList[playerIndex]);
				}
				
				scan.close();
			
			}
			
		}
		
	}
	
	public void rankings(Player [] players){
		
	}
	
	public void createPlayerFile(Player playerInfo) throws FileNotFoundException{
		PrintWriter writer = new PrintWriter(playerInfo.getName() + ".txt");
		String player = playerInfo.getName() + 
				"\nRounds Won: " + playerInfo.getRoundWins() +
				"\nHighest Score: " + playerInfo.getScore() + 
				"\nGames Played: 1" + 
				"\nGames Won: " + playerInfo.isWinner() + 
				"\nGame Win/Loss Percentage: 0.0" +
				"\nPoints Spent: " + playerInfo.getPointsSpent() + 
				"\nPoints Earned: " + playerInfo.getPointsEarned() + 
				"\nActions Used: " + playerInfo.getActionsUsed();
		writer.write(player);
		writer.close();
	}
	
	public void updatePlayerFile(Player playerInfo) throws FileNotFoundException{
		Scanner scan = new Scanner(playerInfo.getName() + ".txt");
		PrintWriter writer = new PrintWriter(playerInfo.getName() + ".txt");
		
		scan.nextLine();
		
		int roundWins = playerInfo.getRoundWins();
		int savedRoundWins = Integer.parseInt(scan.nextLine().substring(13));
		savedRoundWins += roundWins;

		int currentScore = playerInfo.getScore();
		int highestScore = Integer.parseInt(scan.nextLine().substring(16));
		
		if(currentScore > highestScore){
			highestScore = currentScore;
		}
		
		int pastGamesPlayed = Integer.parseInt(scan.nextLine().substring(15));
		pastGamesPlayed += 1;
		
		int winner = playerInfo.isWinner();
		int pastGamesWon = Integer.parseInt(scan.nextLine().substring(12));
		pastGamesWon += winner;
		
		double WinRatio = Double.parseDouble(scan.nextLine().substring(27));
		WinRatio = ((double)pastGamesWon)/pastGamesPlayed;
		
		int pointsSpent = playerInfo.getPointsSpent();
		int pastPointsSpent = Integer.parseInt(scan.nextLine().substring(15));
		pastPointsSpent += pointsSpent;
		
		int pointsEarned = playerInfo.getPointsEarned();
		int pastPointsEarned = Integer.parseInt(scan.nextLine().substring(16));
		pastPointsEarned += pointsEarned;
		
		int actionsUsed = playerInfo.getActionsUsed();
		int pastActionsUsed = Integer.parseInt(scan.nextLine().substring(15));
		pastActionsUsed += actionsUsed;
		
		String player = "";
		
		player = playerInfo.getName() + 
				"\nRounds Won: " + savedRoundWins +
				"\nHighest Score: " + highestScore + 
				"\nGames Played: " + pastGamesPlayed + 
				"\nGames Won: " + pastGamesWon +
				"\nGame Win/Loss Percentage: " + WinRatio +
				"\nPoints Spent: " + pastPointsSpent + 
				"\nPoints Earned: " + pastPointsEarned + 
				"\nActions Used: " + pastActionsUsed;
		
		writer.print("");
		writer.print(player);
		
		scan.close();
	}
	
}
