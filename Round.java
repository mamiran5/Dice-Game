package diceGame;
import java.util.*;

/**public class Round
 * 
 * This class governs the basic actions that are undertaken within a particular round. It consists of a main
 * driver class, playRound() which calls the other methods of this class in the order that they are needed. 
 * Each step is documented to show the exact action that it represents. This class also stores the round number and 
 * the list of players that will be playing in this round. 
 * 
 * @author mfraiz
 *
 */
public class Round 
{
	//The order this round will be called in a particular turn
	//0 ---->  First Round
	//1 ---->  Second Round
	//2 ---->  Third Round
	private int currentRoundNumber = 0;
	
	//ArrayList of players participating in this round. 
	private ArrayList<Player> playerList;
	
	//Test mode is on, this triggers certain methods that are useful for debugging and testing but will 
	//not be needed later on, particular when the GUI is finished.
	private boolean testModeOn = true;
	
	
	/**Round(int roundNumber, ArrayList<Player> aList)
	 * 
	 * Constructor for the Round class. This allows you to create a round object while specifying the order it will 
	 * execute and the list of players that will be participating in the round.
	 * 
	 * @param roundNumber	This int specifies which round it is. 
	 * @param aList			Player List of player objects representing players playing this round
	 */
	public Round(int roundNumber, ArrayList<Player> aList)
	{
		currentRoundNumber = roundNumber;
		playerList = aList;
	}
	
	/**public void playRound()
	 * Driver Method that contains call to all the modules needed to conduct the actions of one round in the order 
	 * that they need to be called. Refer to JavaDocs for individual methods to see what action is done in each
	 * particular step.
	 * 
	 */
	public void playRound()
	{
		
		
		//Print out the stored roles for this round to show them to the user.
		testPrintCurrentRoundRolls(playerList);
		
		//TO-DO execute selected special moves here before a winner for the round is selected.
		//This will be added for the third Sprint. 
		
		//Determine Winner for the Round based on selected rolls.
		Player aWinner = determineRoundWinner();
		
		//Award Points 
		awardPoints(aWinner);
		
		
	}
	
	/**private Player determineRoundWinner()
	 * 
	 * This method decides on who wins a particular round based on the rolls they have compared to the rolls other 
	 * players have. When done it returns the player object that corresponds to the player who has won the round.
	 * 
	 * @return winner	 Player object that is the player who has won this round 
	 */
	public Player determineRoundWinner()

	{
		
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
		
		//If the winnerList has more than one player, then its a tie, call the tie breaker.
		if (winnerList.size() > 1)
		{
			
			winnerList = breakTie(winnerList);
		}
		
		Player winner = winnerList.get(0);
		System.out.println("The Winner for this round is : " + winnerList.toString());
		System.out.println("");
		System.out.println("----------------------------------------");
		
		return winner;
	}

	/**private ArrayList<Player> breakTie(ArrayList<Player> tiePlayers)
	 * 
	 * This method is here to break ties when needed. If you give it an ArrayList of tied players, it will reroll
	 * the dice until only one player remains then return the list containing just this one winning player. 
	 * 
	 * @param tiePlayers	A list of at least 2 players. 
	 * @return 		An ArrayList<Player> Containing the winning player after the rerolls are done. 
	 */
	public ArrayList<Player> breakTie(ArrayList<Player> tiePlayers)
	{
		Player potentialWinner;
		int highestRoll = 0;
		
		//Tiebreaker!
		while(tiePlayers.size() > 1)
		{
			System.out.println("Tie Detected!");
			
			//Reroll for this round.
			Iterator<Player> tieBreakIterator = tiePlayers.iterator();
			
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
			
			Iterator<Player> checkWinnerIterator = tiePlayers.iterator();
			
			//Reset Winner List
			tiePlayers = new ArrayList<Player>();
			
			//Clear HighestRoll
			highestRoll = 0;
			
			while(checkWinnerIterator.hasNext())
			{
				Player newPlayer = checkWinnerIterator.next();
				
				if(newPlayer.getDicePairs()[currentRoundNumber].getSum() == highestRoll)
				{
					tiePlayers.add(newPlayer);
				}
				else if ((newPlayer.getDicePairs()[currentRoundNumber].getSum()> highestRoll))
				{
					//Reset List
					tiePlayers = new ArrayList<Player>();
					
					//Assign New Highscore + Winner
					highestRoll = newPlayer.getDicePairs()[currentRoundNumber].getSum();
					tiePlayers.add(newPlayer);
				}
			}
		}
		
		return tiePlayers;
		
	}

	/**private void awardPoints(Player pointWinner)
	 * 
	 * This method awards a player points for winning the round. 
	 * 
	 *  There are different award values based on which round it is in a turn:
	 *  1st round - 200 points
	 *  2nd round - 150 points
	 *  3rd round - 100 points
	 * 
	 * @param pointWinner	The player to win points
	 */
	public void awardPoints(Player pointWinner)
	{
		switch(currentRoundNumber)
		{
			
			case 1:
				//Award First Round - 200 Points
				pointWinner.modifyScore(200);
				break;
				
			case 2:
				//Award Second Round - 150 Points
				pointWinner.modifyScore(150);
				break;
				
			case 3:
				//Award Third Round - 100 Points
				pointWinner.modifyScore(100);
				break;
				
			default:
				//Throw Exception, Invalid Round Number
				break;
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
