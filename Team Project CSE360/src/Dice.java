package diceGame;

import java.util.Random;

public class Dice {
	
	private int value;
	
	/**Default Constructor
	 * 
	 */
	public Dice()
	{
		
	}
	
	/**Constructor + Roll
	 * 
	 * @param numberOfSides
	 */
	public Dice(int numberOfSides)
	{
		Random roll = new Random();
		value = roll.nextInt(numberOfSides)+ 1;
	}
	
	public void roll()
	{
		Random roll = new Random();
		value = roll.nextInt(6) + 1;
	}
	
	public void setValue(int newValue)
	{
		value = newValue;
	}
	
	public int getValue()
	{
		return value;
	}

}