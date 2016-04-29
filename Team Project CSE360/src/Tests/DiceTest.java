package diceGame;

import static org.junit.Assert.*;

import org.junit.Test;

public class DiceTest {

	@Test
	public void testDice() { // test that constructor does not return null
		Dice myDice = new Dice();
		assertNotNull(myDice);
	}
	
	@Test
	public void testDiceValue() { // test that default constructor initializes to 0
		Dice myDice = new Dice();
		assertEquals(myDice.getValue(), 0);
	}

	@Test
	public void testDiceInt() { // test that defined constructor does not return null
		Dice myDice = new Dice(16);
		assertNotNull(myDice);
	}

	@Test
	public void testRollMin() { // test range of dice created is above 0
		Dice myDice = new Dice();
		myDice.roll();
		assertTrue(myDice.getValue() > 0);
	}
	
	@Test
	public void testRollMax() { // test range of dice created is below 7
		Dice myDice = new Dice();
		myDice.roll();
		assertTrue(myDice.getValue() < 7);
	}
	

	@Test
	public void testSetValue() { // test that it can set the value of the dice
		Dice myDice = new Dice();
		myDice.setValue(3);
		assertEquals(myDice.getValue(), 3);
	}

	@Test
	public void testSetValueRange() { // TODO: right now we can set it to anything, that may not be what we want so does it need to be private so only we can set values or do we need to make sure it stays within range?
		Dice myDice = new Dice();
		myDice.setValue(10);
		assertEquals(myDice.getValue(), 10);
	}
	
	@Test
	public void testGetValue() { // test that it gets the value fo the dice
		Dice myDice = new Dice();
		myDice.setValue(1);
		int value = myDice.getValue();
		assertEquals(value, 1);
	}

}
