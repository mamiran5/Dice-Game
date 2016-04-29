package diceGame;

import java.io.*;
import java.util.*;

public class HighScoreStats {
	
	private PrintWriter writer;
	Scanner scan = new Scanner("masterfile.txt");
	
	public HighScoreStats(Player [] playerList) throws FileNotFoundException{
		writer = new PrintWriter("masterfile.txt");
	}
	
	public void updateMasterFile(Player [] playerList) throws IOException{
		if(!scan.hasNextLine()){
			
			for(int playerIndex = 0; playerIndex < playerList.length; playerIndex++){
				writer.write(playerList[playerIndex].getName() + "\n");
			}
			scan.close();
			
		}
		
		else{
			for(int playerIndex = 0; playerIndex < playerList.length; playerIndex++){
				
				boolean newPlayer = true;
				scan = new Scanner("masterfile.txt");
				
				while(scan.hasNextLine()){
				
					String check = scan.nextLine();
					
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
	
	public void rankings() throws FileNotFoundException{
		Scanner masterScan = new Scanner("masterfile.txt");
		PrintWriter rankingWriter = new PrintWriter("ranking.txt");
		
		int counter = 0;
		
		while(masterScan.hasNextLine()){
			counter += 1;
		}
		
		masterScan.close();
		
		masterScan = new Scanner("masterfile.txt");
		
		Comparator<String> comparator = new PlayerStatsComparator();
	    PriorityQueue<String> queue = new PriorityQueue<String>(counter, comparator);
		
		while(masterScan.hasNextLine()){
			String name = masterScan.nextLine();
			Scanner scan = new Scanner(name + ".txt");
			
			for(int lineNumber = 0; lineNumber < 3; lineNumber++){
				scan.nextLine();
			}
			
			String gamesPlayed = scan.nextLine().substring(15);
			scan.nextLine(); //skip over Games Won
			String gameRatio = scan.nextLine().substring(12);
			String compareInfo = gameRatio + " " + gamesPlayed + " " + name + ".txt";
			
			queue.add(compareInfo);
			
			scan.close();
			
		}
		
		rankingWriter.println("Name RoundsWon HighestScore GamesPlayed GamesWon	GameWin/LossPercentage PointsSpent PointsEarned	ActionsUsed");
		
		
		masterScan.close();
		
		while(!queue.isEmpty()){
			String playerFile = queue.remove().split(" ", 3)[2];
			Scanner playerScan = new Scanner(playerFile);
			
			
		}
		
	}
	
	public void createPlayerFile(Player playerInfo) throws FileNotFoundException{
		PrintWriter writer = new PrintWriter(playerInfo.getName() + ".txt");
	    
		writer.println(playerInfo.getName());
		writer.println("Rounds Won: " + playerInfo.getRoundWins());
		writer.println("Highest Score: " + playerInfo.getScore());
		writer.println("Games Played: 1"); 
		writer.println("Games Won: " + playerInfo.isWinner());
		writer.println("Game Win/Loss Percentage: " + playerInfo.isWinner() * 100);
		writer.println("Points Spent: " + playerInfo.getPointsSpent());
		writer.println("Points Earned: " + playerInfo.getPointsEarned());
		writer.println("Actions Used: " + playerInfo.getActionsUsed());
		
		writer.close();
	}
	
	public void updatePlayerFile(Player playerInfo) throws FileNotFoundException{
		Scanner scan = new Scanner(playerInfo.getName() + ".txt");
		PrintWriter playerWriter = new PrintWriter(playerInfo.getName() + ".txt");
		
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
		
		double winRatio = Double.parseDouble(scan.nextLine().substring(27));
		winRatio = ((double)pastGamesWon)/pastGamesPlayed*100;
		
		int pointsSpent = playerInfo.getPointsSpent();
		int pastPointsSpent = Integer.parseInt(scan.nextLine().substring(15));
		pastPointsSpent += pointsSpent;
		
		int pointsEarned = playerInfo.getPointsEarned();
		int pastPointsEarned = Integer.parseInt(scan.nextLine().substring(16));
		pastPointsEarned += pointsEarned;
		
		int actionsUsed = playerInfo.getActionsUsed();
		int pastActionsUsed = Integer.parseInt(scan.nextLine().substring(15));
		pastActionsUsed += actionsUsed;
		
		playerWriter.println(playerInfo.getName());
		playerWriter.println("Rounds Won: " + savedRoundWins);
		playerWriter.println("Highest Score: " + highestScore);
		playerWriter.println("Games Played: " + pastGamesPlayed); 
		playerWriter.println("Games Won: " + pastGamesWon);
		playerWriter.println("Game Win/Loss Percentage: " + winRatio);
		playerWriter.println("Points Spent: " + pastPointsSpent);
		playerWriter.println("Points Earned: " + pastPointsEarned);
		playerWriter.println("Actions Used: " + pastActionsUsed);
		
		playerWriter.close();
		scan.close();
	}
	
}
