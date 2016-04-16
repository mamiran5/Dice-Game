package diceGame;
import java.util.*;

/**public class Turn
 * 
 * This class governs Turn behavior. Specifically, it creates a turn object that will run set up for the turn 
 * which includes rolling the dice, rerolling (if a player wants for a cost of 50 points), putting the rolls in dice 
 * pairs and then starting the three rounds where players can win points if they have the highest roll. Eventually
 * functionality will also be added for the Turn class to call an action class that will let players risk points
 * on special moves in order to potential win more points. 
 * 
 * @author mfraiz
 *
 */
public class Turn
{
	private ArrayList <Player> playerList = new ArrayList<Player>();
	
	/**Constructor with ArrayList<Player>
	 * 
	 * @param turnPlayers
	 */
	public Turn( ArrayList<Player> turnPlayers)
	{
		playerList = turnPlayers;	
	}
	
	/**Constructor with a standard Array of Players 
	 * 
	 * @param aPlayerArray
	 */
	public Turn(Player[] aPlayerArray)
	{
		for ( int i = 0; i<aPlayerArray.length;i++)
		{
			playerList.add(aPlayerArray[i]);
		}
	}
	
	/**public void turnStart()
	 * 
	 * This can be called to Start a turn. 
	 */
	public void startTurn()
	{
		//Create Round Objects
		Round firstRound = new Round(0,playerList);
		Round secondRound = new Round(1,playerList);
		Round thirdRound = new Round(2,playerList);
		
		//Put Round Objects in Round Array
		ArrayList <Round> roundList = new ArrayList<Round>();
		roundList.add(0,firstRound);
		roundList.add(1,secondRound);
		roundList.add(2,thirdRound);
		
		//Roll the Dice Phase
		rollDice();
		
		//Re-roll Dice Phase
		//TO-DO Reroll Dice!
		
		//Select Ability Phase
		//Will be implemented in Sprint 3. 
		
		//Round Compare!
		System.out.println("Turn Start!");
		startRounds(roundList);
		
	}

	/**public void startRounds(ArrayList<Round> aRoundList)
	 * 
	 * startRounds method.
	 * 
	 * @param aRoundList
	 */
	public void startRounds(ArrayList<Round> aRoundList)
	{
		Iterator<Round> roundIterator = aRoundList.iterator();
		Round currentRound;
		
		while(roundIterator.hasNext())
		{
			currentRound = roundIterator.next();
			currentRound.playRound();
		}
		
	}

	/**public void rollDice()
	 * 
	 * Rolls the dice for the turn.
	 */
	public void rollDice() 
	{
		//Roll the Dice Phase
		
		//Iterate through list
		Iterator<Player> rollingPlayerIterator = playerList.iterator();
		
		//Temp Dice
		Dice tempDice;
		Dice tempDice2;
		
		while (rollingPlayerIterator.hasNext()) 
		{
			
			ArrayList<DicePair> diceList = new ArrayList<DicePair>();
			
			for (int diceCounter = 0; diceCounter < 3; diceCounter++)
			{
				tempDice = new Dice();
				tempDice2 = new Dice();
				
				tempDice.roll();
				tempDice2.roll();
				
				diceList.add(diceCounter ,new DicePair(tempDice,tempDice2));
				
				
			}
			
				Player rollPlayer = rollingPlayerIterator.next();
				rollPlayer.setDicePairs(diceList.get(0), diceList.get(1), diceList.get(2));
								
		}
	
	}

}
