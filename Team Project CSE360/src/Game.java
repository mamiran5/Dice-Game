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
		Turn turns = new Turn();
		String playerName;
		
		for(int playersAdded = 0; playersAdded < playerNum; playersAdded++){
			System.out.println("Please enter a player name!");
			playerName = in.next();
			playerList[playersAdded] = new Player();
			playerList[playersAdded].setName(playerName);
			playerList[playersAdded].setScore(500);
		}
		
		for(int turnCount = 0; turnCount < turnTotal; turnCount++){
			turns.turnStart();
		}
		
		Player winner = playerList[0];
		ArrayList <Player> tieWinners = new <Player> ArrayList();
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
			int highestRoll = 0;
			int newRoll = 0;
			ArrayList <Player> newTieWinners = new <Player> ArrayList();
			int newTieNumber = 0;
			boolean winnerUndecided = true;
			
			while(winnerUndecided){
				
				turns.rollDice();
				
				for(int winningPlayersChecked = 0; winningPlayersChecked < tieNumber; winningPlayersChecked++){
				
					for(int numOfPairs = 0; numOfPairs < 3; numOfPairs++){
						newRoll += tieWinners.get(winningPlayersChecked).getDicePairs()[numOfPairs].getSum();
					}
					
					if(newRoll == highestRoll){
						newTieWinners.add(tieWinners.get(winningPlayersChecked));
						newTieNumber += 1; 
					}
					else if(newRoll > highestRoll){
						winner = tieWinners.get(winningPlayersChecked);
						newTieWinners.removeAll(newTieWinners);
						newTieNumber = 0;
					}
					
				}
				
				if(newTieNumber == 0){
					winnerUndecided = false;
				}
				else{
					tieNumber = newTieNumber;
					tieWinners = newTieWinners;
				}
				
			}	
			
		}	
		
		System.out.println("The winner is " + winner.getName());
		
	}
	
}
