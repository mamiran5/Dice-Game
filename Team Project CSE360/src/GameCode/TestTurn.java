package diceGame;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TestTurn 
{

	@Test
	public void testTurnConstructorArrayList() 
	{
		ArrayList<Player> playerList = new ArrayList<Player>();
		Turn newTurn = new Turn(playerList);
		
		assertNotNull(newTurn);
	}
	
	@Test 
	public void testTurnConstructorArray()
	{
		Player[] playerArray = new Player[2];
		playerArray[0] = new Player("Bob", 300);
		playerArray[1] = new Player("Sue", 200);
		
		Turn newTurn = new Turn(playerArray);
		
		assertNotNull(newTurn);
	}
	
	@Test
	
	//This method ensures that the player dice stay within the range of 2 to 12. 
	public void testRollDice()
	{
		ArrayList<Player> playerList = new ArrayList<Player>();
		playerList.add(new Player("Bob", 500));
		playerList.add(new Player("Sue", 400));
		playerList.add(new Player("Paul", 700));

		
		Turn newTurn = new Turn(playerList);
		
		newTurn.rollDice();
		
		//Check to see that Dice pairs from roll dice are not below 2
		
		assertTrue(playerList.get(0).getDiceForRound(0) >= 2 );
		assertTrue(playerList.get(0).getDiceForRound(1) >= 2 );
		assertTrue(playerList.get(0).getDiceForRound(2) >= 2 );
		
		assertTrue(playerList.get(1).getDiceForRound(0) >= 2 );
		assertTrue(playerList.get(1).getDiceForRound(1) >= 2 );
		assertTrue(playerList.get(1).getDiceForRound(2) >= 2 );
		
		assertTrue(playerList.get(2).getDiceForRound(0) >= 2 );
		assertTrue(playerList.get(2).getDiceForRound(1) >= 2 );
		assertTrue(playerList.get(2).getDiceForRound(2) >= 2 );
		
		//Check to see that Dice pairs from roll dice are not above 12
		
		assertTrue(playerList.get(0).getDiceForRound(0) <= 12 );
		assertTrue(playerList.get(0).getDiceForRound(1) <= 12 );
		assertTrue(playerList.get(0).getDiceForRound(2) <= 12 );
		
		assertTrue(playerList.get(1).getDiceForRound(0) <= 12 );
		assertTrue(playerList.get(1).getDiceForRound(1) <= 12 );
		assertTrue(playerList.get(1).getDiceForRound(2) <= 12 );
		
		assertTrue(playerList.get(2).getDiceForRound(0) <= 12 );
		assertTrue(playerList.get(2).getDiceForRound(1) <= 12 );
		assertTrue(playerList.get(2).getDiceForRound(2) <= 12 );
	}
	
	@Test
	public void testPlayerRollDice()
	{
		ArrayList<Player> playerList = new ArrayList<Player>();
		playerList.add(new Player("Bob", 500));
		playerList.add(new Player("Sue", 500));
		playerList.add(new Player("Paul", 500));
		playerList.add(new Player("Laura", 500));
		
		//Set them as all players.
		playerList.get(0).setIsItAComputer(false);
		playerList.get(1).setIsItAComputer(false);
		playerList.get(2).setIsItAComputer(false);
		playerList.get(3).setIsItAComputer(false);
		
		Turn nextTurn = new Turn(playerList);
		
		//Have the players Roll the dice
		nextTurn.rollDice();
		
		
		System.out.println("Test Original Rolls");
		System.out.println(playerList.get(0).getDiceList().toString());
		System.out.println(playerList.get(1).getDiceList().toString());
		System.out.println(playerList.get(2).getDiceList().toString());
		System.out.println(playerList.get(3).getDiceList().toString());
		
		nextTurn.reRollPhase();
		
		System.out.println("Test Re-Rolls");
		System.out.println(playerList.get(0).getDiceList().toString());
		System.out.println(playerList.get(1).getDiceList().toString());
		System.out.println(playerList.get(2).getDiceList().toString());
		System.out.println(playerList.get(3).getDiceList().toString());
	}
	
}
