package diceGame;
import java.util.*;

public class Turn
{
	private ArrayList <Player> playerList = new ArrayList<Player>();
	
	public Turn( ArrayList<Player> turnPlayers)
	{
		playerList = turnPlayers;
		
	}
	
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
		Round firstRound = new Round(1,playerList);
		Round secondRound = new Round(2,playerList);
		Round thirdRound = new Round(3,playerList);
		
		//Put Round Objects in Round Array
		ArrayList <Round> roundList = new ArrayList<Round>();
		roundList.add(0,firstRound);
		roundList.add(1,secondRound);
		roundList.add(2,thirdRound);
		
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
		
		//Re-roll Dice Phase
		
		//TO-DO     Reroll Dice!
		
		//Select Ability Phase
		
		//Round Compare!
		System.out.println("Turn Start!");
		Round currentRound = null;
		for (int counter = 0; counter < 3; counter++)
		{
			currentRound = new Round(counter, playerList);
			currentRound.playRound();
		}
		
		//Clear roundList
		roundList = null;
		
	}

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