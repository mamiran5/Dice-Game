package diceGame;
import java.util.*;

public class Round 
{
	private int currentRoundNumber = 0;
	private ArrayList<Player> playerList = null;
	
	private boolean testModeOn = true;
	
	public Round(int roundNumber, ArrayList<Player> aList)
	{
		currentRoundNumber = roundNumber;
		playerList = aList;
	}
	
	/**Compare everyone's dice in order to determine a winner.
	 * 
	 */
	public void playRound()
	{
		
		
		//Test Rolls
		
		testPrintCurrentRoundRolls(playerList);
		
		//Determine Winner for the Round:
		
		//Iterator for List
		Iterator<Player> rollingPlayerIterator = playerList.iterator();
		
		//Store the highest Roll for comparisons
		int highestRoll = 0;
		
		//Store list of winner or winner player objects
		ArrayList<Player> winnerList = new ArrayList<Player>();		
		
		while (rollingPlayerIterator.hasNext()) 
		{
			Player newPlayer = rollingPlayerIterator.next();
			
			if(newPlayer.getDicePairs()[currentRoundNumber].getSum()== highestRoll)
			{
				winnerList.add(newPlayer);
			}
			else if ((newPlayer.getDicePairs()[currentRoundNumber].getSum()> highestRoll))
			{
				//Reset List
				winnerList = new ArrayList<Player>();
				
				//Assign New Highscore + Winner
				highestRoll = newPlayer.getDicePairs()[currentRoundNumber].getSum();
				winnerList.add(newPlayer);
			}
			
		}
		
		
		Player potentialWinner;
		
		//Tiebreaker!
		while(winnerList.size() > 1)
		{
			System.out.println("Tie Detected!");
			
			//Reroll for this round.
			Iterator<Player> tieBreakIterator = winnerList.iterator();
			
			while(tieBreakIterator.hasNext())
			{
				potentialWinner = tieBreakIterator.next();
				
				//Reroll the Dice!
				potentialWinner.getDicePairs()[currentRoundNumber].rerollPair();
				//Print The Roll!
				if (testModeOn)
				{
					System.out.println(potentialWinner.toString() + " rolled a " + 
					potentialWinner.getDicePairs()[currentRoundNumber].getSum());
				}
					
				
			}
			
			Iterator<Player> checkWinnerIterator = winnerList.iterator();
			
			//Reset Winner List
			winnerList = new ArrayList<Player>();
			
			//Clear HighestRoll
			highestRoll = 0;
			
			while(checkWinnerIterator.hasNext())
			{
				Player newPlayer = checkWinnerIterator.next();
				
				if(newPlayer.getDicePairs()[currentRoundNumber].getSum() == highestRoll)
				{
					winnerList.add(newPlayer);
				}
				else if ((newPlayer.getDicePairs()[currentRoundNumber].getSum()> highestRoll))
				{
					//Reset List
					winnerList = new ArrayList<Player>();
					
					//Assign New Highscore + Winner
					highestRoll = newPlayer.getDicePairs()[currentRoundNumber].getSum();
					winnerList.add(newPlayer);
				}
			}
			
			
		}
		
		
		System.out.println("The Winner for this round is : " + winnerList.toString());
		System.out.println("");
		System.out.println("----------------------------------------");
		
		//
		switch(currentRoundNumber)
		{
			
			case 1:
				//Award First Round - 200 Points
				winnerList.get(0).modifyScore(200);
				
			case 2:
				//Award Second Round - 150 Points
				winnerList.get(0).modifyScore(150);
				
			case 3:
				//Award Third Round - 100 Points
				winnerList.get(0).modifyScore(100);
				
			default:
				//Throw Exception, Invalid Round Number
		}
		
		
	}
	
	/**Helper function that prints out everyone's score for the current Round.
	 * 
	 * @param listOfPlayers
	 */
	private void testPrintCurrentRoundRolls(ArrayList<Player> listOfPlayers)
	{
		Iterator<Player> rollingPlayerIterator = playerList.iterator();
		
		
		int testCount = 1;
		
		while (rollingPlayerIterator.hasNext()) 
		{
			Player newPlayer = rollingPlayerIterator.next();
			
			System.out.println("Player " + testCount + " : " + newPlayer.toString() + " rolled a : " 
						+ newPlayer.getDicePairs()[currentRoundNumber].getSum() );
			testCount++;
				
		}
		
		System.out.println();
		
	}
}
