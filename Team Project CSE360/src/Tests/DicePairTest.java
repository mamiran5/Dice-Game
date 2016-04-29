package diceGame;

import static org.junit.Assert.*;

import org.junit.Test;

public class DicePairTest {

	@Test
	public void testDicePair() { //test constructor does nto return null
		Dice dice1 = new Dice();
		Dice dice2 = new Dice();
		DicePair myPair = new DicePair(dice1, dice2);
		assertNotNull(myPair);
	}

	@Test
	public void testGetSum() { // make sure sum gets the total of both dice
		Dice dice1 = new Dice();
		dice1.setValue(3);
		Dice dice2 = new Dice();
		dice2.setValue(5);
		DicePair myPair = new DicePair(dice1, dice2);
		assertEquals(myPair.getSum(), 8);
	}

	@Test
	public void testCompareWin() { // test win scenario
		int winner;
		Dice dice1 = new Dice();
		dice1.setValue(3);
		Dice dice2 = new Dice();
		dice2.setValue(5);
		Dice dice3 = new Dice();
		dice3.setValue(1);
		Dice dice4 = new Dice();
		dice4.setValue(4);
		DicePair myPair = new DicePair(dice1, dice2);
		DicePair enemyPair = new DicePair(dice3, dice4);
		winner = myPair.compare(enemyPair);
		assertEquals(winner, 1);
	}
	
	@Test
	public void testCompareTie() { //test tie scenario
		int winner;
		Dice dice1 = new Dice();
		dice1.setValue(3);
		Dice dice2 = new Dice();
		dice2.setValue(5);
		Dice dice3 = new Dice();
		dice3.setValue(4);
		Dice dice4 = new Dice();
		dice4.setValue(4);
		DicePair myPair = new DicePair(dice1, dice2);
		DicePair enemyPair = new DicePair(dice3, dice4);
		winner = myPair.compare(enemyPair);
		assertEquals(winner, 0);
	}
	
	@Test
	public void testCompareLoss() { // test loss scenario
		int winner;
		Dice dice1 = new Dice();
		dice1.setValue(3);
		Dice dice2 = new Dice();
		dice2.setValue(5);
		Dice dice3 = new Dice();
		dice3.setValue(6);
		Dice dice4 = new Dice();
		dice4.setValue(5);
		DicePair myPair = new DicePair(dice1, dice2);
		DicePair enemyPair = new DicePair(dice3, dice4);
		winner = myPair.compare(enemyPair);
		assertEquals(winner, -1);
	}

	@Test
	public void testRerollPair() { // make sure reroll assigns new values
		Dice dice1 = new Dice();
		Dice dice2 = new Dice();
		DicePair myPair = new DicePair(dice1, dice2);
		myPair.rerollPair();
		assertTrue(myPair.getSum() != 0);
	}

}
