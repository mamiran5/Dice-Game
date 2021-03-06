package diceGame;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class PlayerTest {

	@Test
	public void testPlayer() {
		Player test = new Player("name", 100);
		assertNotNull(test);
	}
	
	@Test
	public void testgetScore(){
		Player test = new Player("name", 100);
		assertEquals(test.getScore(),100);
	}
	
	@Test
	public void testsetScore(){
		Player test = new Player("name", 100);
		test.setScore(250);
		assertEquals(test.getScore(),250);
	}
	
	@Test
	public void testisAComputer(){
		Player test = new Player("name", 100);
		assertTrue(test.isAComputer());
	}
	
	@Test
	public void testsetIsItAComputer(){
		Player test = new Player("name", 100);
		test.setIsItAComputer(false);
		assertFalse(test.isAComputer());
	}
	
	@Test
	public void testmodifyScore(){
		Player test = new Player("name", 100);
		test.modifyScore(-10);
		assertEquals(test.getScore(),90);
		test.modifyScore(20);
		assertEquals(test.getScore(),110);
	}
	
	@Test
	public void testsetDicePairs(){
		Player test = new Player("name", 100);
		Dice dice1 = new Dice();
		Dice dice2 = new Dice();
		Dice dice3 = new Dice();
		Dice dice4 = new Dice();
		Dice dice5 = new Dice();
		Dice dice6 = new Dice();
		DicePair pair1 = new DicePair(dice1,dice2);
		DicePair pair2 = new DicePair(dice3,dice4);
		DicePair pair3 = new DicePair(dice5,dice6);
		DicePair[] pairArray = {pair1,pair2,pair3};
		test.setDicePairs(pair1, pair2, pair3);
		assertArrayEquals(test.getDicePairs(),pairArray);
	}
	
	@Test
	public void testgetDiceList(){ //Tests both getDiceList and setDiceList
		Player test = new Player("name", 100);
		Dice dice1 = new Dice();
		dice1.roll();
		Dice dice2 = new Dice();
		dice2.roll();
		Dice dice3 = new Dice();
		dice3.roll();
		Dice dice4 = new Dice();
		dice4.roll();
		Dice dice5 = new Dice();
		dice5.roll();
		Dice dice6 = new Dice();
		dice6.roll();
		Dice[] rolled = new Dice[6];
		rolled[0] = dice1;
		rolled[1] = dice2;
		rolled[2] = dice3;
		rolled[3] = dice4;
		rolled[4] = dice5;
		rolled[5] = dice6;
		
		ArrayList<Dice> diceList = new ArrayList<Dice>();
		for (int diceCount = 0; diceCount<rolled.length; diceCount++ )
		{
			diceList.add(rolled[diceCount]);
		}
		test.setDiceList(rolled);
		assertEquals(test.getDiceList(),rolled);	
	}
	
	@Test
	public void testgetName(){
		Player test = new Player("name", 100);
		assertEquals(test.getName(),"name");
	}
	
	@Test
	public void testgetDiceForRound(){
		Player test = new Player("name", 100);
		Dice dice1 = new Dice();
		Dice dice2 = new Dice();
		Dice dice3 = new Dice();
		Dice dice4 = new Dice();
		Dice dice5 = new Dice();
		Dice dice6 = new Dice();
		DicePair pair1 = new DicePair(dice1,dice2);
		DicePair pair2 = new DicePair(dice3,dice4);
		DicePair pair3 = new DicePair(dice5,dice6);
		test.setDicePairs(pair1, pair2, pair3);	
		assertEquals(test.getDiceForRound(0), (test.getDicePairs())[0].getSum());
	}
	
	@Test
	public void testgetDicePairs(){
		Player test = new Player("name", 100);
		Dice dice1 = new Dice();
		Dice dice2 = new Dice();
		Dice dice3 = new Dice();
		Dice dice4 = new Dice();
		Dice dice5 = new Dice();
		Dice dice6 = new Dice();
		DicePair pair1 = new DicePair(dice1,dice2);
		DicePair pair2 = new DicePair(dice3,dice4);
		DicePair pair3 = new DicePair(dice5,dice6);
		DicePair[] pairArray = {pair1,pair2,pair3};
		test.setDicePairs(pair1, pair2, pair3);
		assertArrayEquals(test.getDicePairs(),pairArray);
	}
	
	@Test
	public void testtoString(){
		Player test = new Player("name", 100);
		assertEquals(test.toString(),"name");
	}
	
	@Test
	public void testgetSafe(){
		Player test = new Player("name",100);
		assertFalse(test.getSafe());
	}
	@Test
	public void testsetSafe(){
		Player test = new Player("name",100);
		test.setSafe(1);
		assertTrue(test.getSafe());
	}
}
