package diceGame;

import java.io.*;
import java.util.*;

public class HighScoreStats {
	
	private PrintWriter writer;
	private Scanner scan;
	private File file;
	
	/** HighScoreStats - Constructor for the class that initializes the Objects that read from and write to files
	 * 
	 * @throws FileNotFoundException
	 */
	
	public HighScoreStats() throws FileNotFoundException{
		file = new File("masterfile.txt");
		writer = new PrintWriter(new FileOutputStream(file,true));
		scan = new Scanner(file);
	}
	
	
	/** updateMastreFile - Decides whether a player's name needs to be appended to the end of the masterfile that contains all past players.
	 * 
	 * @param playerList - Gives the current playerList to check if one or more of the players already played before, or if this is the first game to be played ever, the masterfile is initialized to contain these players.  
	 * @throws FileNotFoundException
	 */
	
	public void updateMasterFile(Player [] playerList) throws FileNotFoundException{
		if(!scan.hasNextLine()){
			
			for(int playerIndex = 0; playerIndex < playerList.length; playerIndex++){
				writer.println(playerList[playerIndex].getName());
				createPlayerFile(playerList[playerIndex]);
			}
			
			scan.close();
			writer.close();
		}
		
		else{
			for(int playerIndex = 0; playerIndex < playerList.length; playerIndex++){
				
				boolean newPlayer = true;
				
				while(scan.hasNextLine()){
				
					String check = scan.nextLine();
					
					if(check.equals(playerList[playerIndex].getName())){
						updatePlayerFile(playerList[playerIndex]);
						newPlayer = false;
					}
				
				}
				
				if(newPlayer){
					writer.println(playerList[playerIndex].getName());
					createPlayerFile(playerList[playerIndex]);
				}
				
				scan.close();
				
				scan = new Scanner(file);
				
			}
			
			scan.close();
			writer.close();
			
		}
		
	}
	
	public void Rankings() throws FileNotFoundException{
		File rankFile = new File("rankings.txt");
		Scanner masterScan = new Scanner(file);
		PrintWriter rankingWriter = new PrintWriter(new FileOutputStream(rankFile,false));
		
		int counter = 0;
		
		while(masterScan.hasNextLine()){
			counter += 1;
			masterScan.nextLine();
		}
		
		masterScan.close();
		
		masterScan = new Scanner(file);
		
		Comparator<String> comparator = new PlayerStatsComparator();
	    PriorityQueue<String> queue = new PriorityQueue<String>(counter, comparator);
		
		while(masterScan.hasNextLine()){
			String name = masterScan.nextLine();
			
			File playerFile = new File(name + ".txt");
			Scanner scan = new Scanner(playerFile);
			
			for(int lineNumber = 0; lineNumber < 3; lineNumber++){
				scan.nextLine();
			}
			
			String gamesPlayed = scan.nextLine().substring(14);
			scan.nextLine(); //skip over Games Won
			String gameRatio = scan.nextLine().substring(26);
			String compareInfo = gameRatio + " " + gamesPlayed + " " + name + ".txt";
			
			queue.add(compareInfo);
			
			scan.close();
			
		}

		
		rankingWriter.println("****************************************************************************************************************************************");
		rankingWriter.println("********************************                                RANKINGS                                ********************************");
		rankingWriter.println("****************************************************************************************************************************************");
		
		rankingWriter.println("Ranking       Name       Rounds Won   Highest Score   Games Played   Games Won   Points Spent   Points Earned   Actions Used   Win Ratio");
		rankingWriter.println("-------   ------------   ----------   -------------   ------------   ---------   ------------   -------------   ------------   ---------");
		
		
		masterScan.close();
		
		int rank = 0;
		
		while(!queue.isEmpty()){
			String player = queue.remove().split(" ", 3)[2];
			File fileInfo = new File(player);
			Scanner playerScan = new Scanner(fileInfo);
			
			rank++;
			
			String name = playerScan.nextLine();
			int roundWins = Integer.parseInt(playerScan.nextLine().substring(12));
			int highestScore = Integer.parseInt(playerScan.nextLine().substring(15));
			int gamesPlayed = Integer.parseInt(playerScan.nextLine().substring(14));
			int gamesWon = Integer.parseInt(playerScan.nextLine().substring(11));
			
			double winRatio = Double.parseDouble(playerScan.nextLine().substring(26));
			
			int pointsSpent = Integer.parseInt(playerScan.nextLine().substring(14));
			int pointsEarned = Integer.parseInt(playerScan.nextLine().substring(15));
			int actionsUsed = Integer.parseInt(playerScan.nextLine().substring(14));
			
			String statInfo = String.format("%-7d   %-12s   %-10d   %-13d   %-12d   %-9d   %-12d   %-13d   %-12d   %3.5f", rank, name, roundWins, highestScore, gamesPlayed, gamesWon, pointsSpent, pointsEarned, actionsUsed, winRatio);
		
			rankingWriter.println(statInfo);
			
			playerScan.close();
			
		}
		
		rankingWriter.close();
		
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
		File playerFile = new File (playerInfo.getName() + ".txt");
		Scanner scan = new Scanner(playerFile);
		
		scan.nextLine();
		
		int roundWins = playerInfo.getRoundWins();
		int savedRoundWins = Integer.parseInt(scan.nextLine().substring(12));
		savedRoundWins += roundWins;

		int currentScore = playerInfo.getScore();
		int highestScore = Integer.parseInt(scan.nextLine().substring(15));
		
		if(currentScore > highestScore){
			highestScore = currentScore;
		}
		
		int pastGamesPlayed = Integer.parseInt(scan.nextLine().substring(14));
		pastGamesPlayed += 1;
		
		int winner = playerInfo.isWinner();
		int pastGamesWon = Integer.parseInt(scan.nextLine().substring(11));
		pastGamesWon += winner;
		
		double winRatio = Double.parseDouble(scan.nextLine().substring(26));
		winRatio = ((double)pastGamesWon)/pastGamesPlayed*100;
		
		int pointsSpent = playerInfo.getPointsSpent();
		int pastPointsSpent = Integer.parseInt(scan.nextLine().substring(14));
		pastPointsSpent += pointsSpent;
		
		int pointsEarned = playerInfo.getPointsEarned();
		int pastPointsEarned = Integer.parseInt(scan.nextLine().substring(15));
		pastPointsEarned += pointsEarned;
		
		int actionsUsed = playerInfo.getActionsUsed();
		int pastActionsUsed = Integer.parseInt(scan.nextLine().substring(14));
		pastActionsUsed += actionsUsed;
		
		PrintWriter playerWriter = new PrintWriter(playerInfo.getName() + ".txt");
		
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
