package diceGame;

/** The Game class contains the methods that decide the winner of the game based on score
 *  as well as based on a final dice roll of all 6 dice added together in the case of a tie.
 *  In addition, this method adds Players to a list of players that will be used to keep track
 *  of everyone's score and dice rolls. This class also contains a method to print out who the
 *  winner of the game is.
 *  
 * @author Michael Saul
 * @version April 25, 2016.
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Game {
	
	public static void main (String [] args) throws FileNotFoundException{
		Scanner in = new Scanner(System.in);
		
		System.out.println("Please enter the number of turns you wish to play!");
		int turnTotal = in.nextInt();
		
		System.out.println("Please enter the number of players that will participate in the game!");
		int playerNum = in.nextInt();
		
		Player [] playerList = new Player[playerNum];
		
		String playerName;
		
		in.nextLine();
		
		//Adds all the players to an array
		for(int playersAdded = 0; playersAdded < playerNum; playersAdded++){
			System.out.println("Please enter a player name!");
			playerName = in.nextLine();
			playerList[playersAdded] = new Player(playerName, 500);
		}
		
		Turn turns = new Turn(playerList);
		
		//Plays the number of turns that the player specified earlier
		for(int turnCount = 0; turnCount < turnTotal; turnCount++){
			turns.startTurn();
		}
		
		Player winner = playerList[0];
		ArrayList <Player> winners = new ArrayList <Player>();
		
		//Determines who has the highest score and sets that peson as the winner, unless there is a tie in which case an array is created containing those who have the same highest score
		for(int playersChecked = 1; playersChecked < playerNum; playersChecked++){
			int highScore = winner.getScore();
			int newScore = playerList[playersChecked].getScore();
			
			if(newScore == highScore){
				winners.add(playerList[playersChecked]);
			}
			
			else if(newScore > highScore){
				winner = playerList[playersChecked];
				winners.removeAll(winners);
				winners.add(winner);
			}
			
		}
		
		//Determines the winner of the game in the event of a tie when comparing each player's score. Each player that tied rolls all their dice and adds up the sum of the dice rolls.
		//Whichever player has the highest sum of the die will win the game, unless some players tie with the largest dice roll sum in which case they roll again and repeat this process until one player is victorious.
		if(winners.size() != 1){
			System.out.println("Not everyone can be a Winner! It's time for a tie breaker! \n");
			
			int tieNumber = winners.size();
			
			int highestRoll = 0;
			int newRoll = 0;
			ArrayList <Player> newWinners = new ArrayList <Player> ();
			int newTieNumber = 0;
			boolean winnerUndecided = true;
			
			while(winnerUndecided){
				
				turns.rollDice();
				
				for(int winningPlayersChecked = 0; winningPlayersChecked < tieNumber; winningPlayersChecked++){
					
					
					for(int numOfPairs = 0; numOfPairs < 3; numOfPairs++){
						newRoll += winners.get(winningPlayersChecked).getDicePairs()[numOfPairs].getSum();
					}
					
					System.out.println("Player " + (winningPlayersChecked + 1) + " : " + 
					winners.get(winningPlayersChecked).getName() +" rolled a : " + newRoll);
					
					if(newRoll == highestRoll){
						newWinners.add(winners.get(winningPlayersChecked));
						newTieNumber = 1; 
					}
					
					else if(newRoll > highestRoll){
						
						winner = winners.get(winningPlayersChecked);
						newWinners.removeAll(winners);
						newWinners.add(winner);
						
						highestRoll = newRoll;
						newTieNumber = 0;
					}
					
					newRoll = 0;
				}
				
				if(newTieNumber == 0){
					winnerUndecided = false;
					System.out.println("");
					System.out.println("----------------------------------------");
				}
				
				else{
					winners = new ArrayList <Player> (); 
					winners.addAll(winners);
					
					tieNumber = winners.size();
					highestRoll = 0;
					System.out.println("");
					System.out.println("----------------------------------------");
					System.out.println("Another tie?!? This calls for a tie breaker!");
				}
				
			}	
			
		}	
		
		for(int playerIndex = 0; playerIndex < playerNum; playerIndex++){
			System.out.println("Player " + (playerIndex + 1) + " : " + playerList[playerIndex].getName() + " ended with a score of : " + playerList[playerIndex].getScore());
		}
		
		System.out.println("");
		System.out.println("----------------------------------------");
		System.out.println("The Winner is : [" + winner.getName() + "]");
		
		winner.setWinner();
		
		HighScoreStats stats = new HighScoreStats();
		
		stats.updateMasterFile(playerList);
		
		System.out.println("Would you like to view the current Rankings? If so, please enter a 1, otherwise just press enter.");
		
		Scanner scan = new Scanner(System.in);
		
		String show = scan.nextLine();
		
		in.close();
		scan.close();
		
		if(show.equals("1")){
			stats.Rankings();
			
			File rankfile = new File("rankings.txt");
			Scanner ranks = new Scanner(rankfile);
			
			String viewRankings = "";
			
			while(ranks.hasNextLine()){
				viewRankings += ranks.nextLine() + "\n";
			}
			
			System.out.println(viewRankings);
			
			ranks.close();
		}
	}
}
