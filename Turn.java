package diceGame;
import java.util.*;

public class Turn
{
	private ArrayList <Player> playerList = null;
	public Turn()
	{
		
	}
	
	/**public void turnStart()
	 * 
	 * This can be called to Start a turn. 
	 */
	public void turnStart()
	{
		//Create Round Objects
		Round firstRound = new Round(1,playerList);
		Round secondRound = new Round(2,playerList);
		Round thirdRound = new Round(3,playerList);
		
		//Put Round Objects in Round Array
		ArrayList <Round> roundList = new ArrayList<Round>();
		roundList.add(0,firstRound);
		roundList.add(1,secondRound);
		roundList.add(2,thirdRound);
		
		//Roll the Dice Phase
		
		//TO-DO 	Roll Dice!
		
		//Re-roll Dice Phase
		
		//TO-DO     Reroll Dice!
		
		//Select Ability Phase
		
		//Round Compare!
		
		Round currentRound = null;
		for (int counter = 0; counter < 3; counter++)
		{
			currentRound = roundList.get(counter);
			currentRound.playRound();
		}
		
		//Clear roundList
		roundList = null;
		
	}

}
