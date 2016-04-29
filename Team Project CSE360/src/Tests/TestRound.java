package diceGame;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TestRound {

	@Test
	public void testRoundConstructor() 
	{
		ArrayList<Player> playerList = new ArrayList<Player>();
		Round newRound = new Round(0, playerList);
		
		assertNotNull(newRound);
	}
	
	@Test
	//Determine that a winner is selected in a round.
	public void testDetermineRoundWinner()
	{
		ArrayList<Player> playerList = new ArrayList<Player>();
		playerList.add(new Player("Bob", 200));
		playerList.add(new Player("Sue", 200));

		Turn newTurn = new Turn(playerList);
		
		//Roll the dice
		newTurn.rollDice();
		
		//Check to see if determineRoundWinner produces a valid player object.
		Round newRound = new Round(0, playerList);
		Player winner = null;
		winner = newRound.determineRoundWinner();
		
		//Assert Winner Exists
		assertNotNull(winner);
		
		//Assert Winner has name
		assertNotNull(winner.getName());
		
		//Assert Winner Score has not changed from above. 
		assertEquals(200, winner.getScore());
		
	}
	
	@Test
	//Determine that testBreakTie() always produces a list with only one player in it.
	public void testBreakTie()
	{
		ArrayList<Player> playerList = new ArrayList<Player>();
		playerList.add(new Player("Bob", 200));
		playerList.add(new Player("Sue", 400));
		playerList.add(new Player("Linda", 6700));
		playerList.add(new Player("Laura", 2320));
		playerList.add(new Player("Duke", 20023));
		playerList.add(new Player("Thomas", 13500));
		playerList.add(new Player("Harold", 4500));
		playerList.add(new Player("Mic", 4500));
		playerList.add(new Player("Bob", 400));
		
		//Check that playerList has 9 members
		assertEquals(9,playerList.size());
		
		Turn newTurn = new Turn(playerList);
		newTurn.rollDice();
		Round aRound = new Round(1,playerList);
		
		ArrayList<Player> winnerList = aRound.breakTie(playerList);
		
		//Assert that the list of winners is 1 after running breakTie
		assertEquals(1,winnerList.size());
		
	}
	
	@Test
	//Test that points are correctly awarded after a round. 
	public void testAwardPoints()
	{
		ArrayList<Player> playerList = new ArrayList<Player>();
		playerList.add(new Player("Player One", 500));
		playerList.add(new Player("Player Two", 500));
		playerList.add(new Player("Player Three", 500));
		playerList.add(new Player("Player Four", 500));
		
		assertEquals(500, playerList.get(0).getScore());
		assertEquals(500, playerList.get(1).getScore());
		assertEquals(500, playerList.get(2).getScore());
		assertEquals(500, playerList.get(3).getScore());
		
		Turn newTurn = new Turn(playerList);
		newTurn.rollDice();
		
		//Test that someone gets 200 points after first round!
		Round firstRound = new Round(0,playerList);
		Player winner = firstRound.determineRoundWinner();
		
		//This passes in the player with the best roll which should always be one of our four players.
		firstRound.awardPoints(winner);

		
		int scoreDifference = (playerList.get(0).getScore() - 500) + (playerList.get(1).getScore() - 500) +
				(playerList.get(2).getScore() - 500) + (playerList.get(3).getScore() - 500);
		
		//A total of 200 points will be gained from the first round so test that is the total difference from the original score of the players!
		assertEquals(200, scoreDifference);
		
		//Reset Scores and check Second Round!
		
		playerList.get(0).setScore(500);
		playerList.get(1).setScore(500);
		playerList.get(2).setScore(500);
		playerList.get(3).setScore(500);
		
		Round secondRound = new Round(1,playerList);
		winner = secondRound.determineRoundWinner();
		
		secondRound.awardPoints(winner);
		
		scoreDifference = (playerList.get(0).getScore() - 500) + (playerList.get(1).getScore() - 500) +
				(playerList.get(2).getScore() - 500) + (playerList.get(3).getScore() - 500);
		
		//A total of 150 points will be gained from the 2nd round so test that is the total difference from the original score of the players!
		assertEquals(150,scoreDifference);
		
		//Reset Scores and check Third Round!
		
		playerList.get(0).setScore(500);
		playerList.get(1).setScore(500);
		playerList.get(2).setScore(500);
		playerList.get(3).setScore(500);
		
		Round thirdRound = new Round(2,playerList);
		winner = thirdRound.determineRoundWinner();
		
		thirdRound.awardPoints(winner);
		
		scoreDifference = (playerList.get(0).getScore() - 500) + (playerList.get(1).getScore() - 500) +
				(playerList.get(2).getScore() - 500) + (playerList.get(3).getScore() - 500);
		
		//A total of 100 points will be gained from the 3rd round so test that is the total difference from the original score of the players!
		assertEquals(100,scoreDifference);
		
		
		
	}

}
