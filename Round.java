package diceGame;
import java.util.*;

public class Round 
{
	private int numberOfRound = 0;
	private ArrayList<Player> playerList = null;
	
	public Round(int roundNumber, ArrayList<Player> aList)
	{
		numberOfRound = roundNumber;
		playerList = aList;
	}
	
	/**Compare everyone's dice in order to determine a winner.
	 * 
	 */
	public void playRound()
	{
		//Find a Winner
		
		//Is it a tie? use a tiebreaker. 
		
		//Reward Points based on Round Number.
		
		//Test Rolls
		Iterator<Player> rollingPlayerIterator = playerList.iterator();
		
		
		int testCount = 1;
		
		while (rollingPlayerIterator.hasNext()) 
		{
			Player newPlayer = rollingPlayerIterator.next();
			
			System.out.println("Player " + testCount + " rolled a : " 
						+ newPlayer.getDicePairs()[numberOfRound].getSum() );
			testCount++;
				
		}
		
		System.out.println();
		
		//Declare Winner
		
		
		switch(numberOfRound)
		{
			
			case 1:
				//Award First Round Points
				
			case 2:
				//Award Second Round Points
				
			case 3:
				//Award Third Round Points
				
			default:
				//Throw Exception, Invalid Round Number
		}
		
		
	}
	
}