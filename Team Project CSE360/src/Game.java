package diceGame;
import java.util.*;

public class Game {
	
	public static void main (String [] args){
		Scanner in = new Scanner(System.in);
		
		System.out.println("Please enter the number of turns you wish to play!");
		int turnTotal = in.nextInt();
		
		System.out.println("Please enter the number of players that will participate in the game!");
		int playerNum = in.nextInt();
		
		Player [] playerList = new Player[playerNum];
		
		String playerName;
		
		for(int playersAdded = 0; playersAdded < playerNum; playersAdded++){
			System.out.println("Please enter a player name!");
			playerName = in.next();
			playerList[playersAdded] = new Player(playerName, 500);
		}
		
		Turn turns = new Turn(playerList);
		
		for(int turnCount = 0; turnCount < turnTotal; turnCount++){
			turns.startTurn();
		}
		
		Player winner = playerList[0];
		ArrayList <Player> tieWinners = new ArrayList <Player >();
		int tieNumber = 0;
		
		for(int playersChecked = 1; playersChecked < playerNum; playersChecked++){
			int highScore = winner.getScore();
			int newScore = playerList[playersChecked].getScore();
			
			if(newScore == highScore){
				tieWinners.add(playerList[playersChecked]);
				tieNumber += 1;
			}
			else if(newScore > highScore){
				winner = playerList[playersChecked];
				tieWinners.removeAll(tieWinners);
				tieNumber = 0;
			}
		}
		
		if(tieNumber != 0){
			tieWinners.add(winner);
			tieNumber = tieWinners.size();
			
			int highestRoll = 0;
			int newRoll = 0;
			ArrayList <Player> newTieWinners = new ArrayList <Player> ();
			int newTieNumber = 0;
			boolean winnerUndecided = true;
			
			while(winnerUndecided){
				
				turns.rollDice();
				
				for(int winningPlayersChecked = 0; winningPlayersChecked < tieNumber; winningPlayersChecked++){
					
					System.out.println(tieWinners.get(winningPlayersChecked).getName());
					
					for(int numOfPairs = 0; numOfPairs < 3; numOfPairs++){
						newRoll += tieWinners.get(winningPlayersChecked).getDicePairs()[numOfPairs].getSum();
					}
					
					System.out.println("" + newRoll);
					
					if(newRoll == highestRoll){
						newTieWinners.add(tieWinners.get(winningPlayersChecked));
						newTieNumber = 1; 
					}
					
					else if(newRoll > highestRoll){
						
						winner = tieWinners.get(winningPlayersChecked);
						newTieWinners.removeAll(newTieWinners);
						
						highestRoll = newRoll;
						newTieNumber = 0;
					}
					
					newRoll = 0;
				}
				
				if(newTieNumber == 0){
					winnerUndecided = false;
				}
				else{
					newTieWinners.add(winner);
					tieWinners = new ArrayList <Player> (); 
					tieWinners.addAll(newTieWinners);
					
					tieNumber = newTieWinners.size();
					highestRoll = 0;
					newRoll = 0;
				}
				
			}	
			
		}	
		
		System.out.println("The winner is " + winner.getName());
		
	}
	
}
