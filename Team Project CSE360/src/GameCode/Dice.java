package diceGame;

import java.util.Random;

/**
 * The Dice class is used to keep track of the dice in our game. It has a value which
 * represents the number rolled on the dice. There are multiple constructors
 * to create dice of different or preset values as well as a method to be 
 * able to roll the dice even after being created. It also has getter and setter
 * methods.
 * 
 * @author Mauricio Gutierrez for CSE 360, PIN: 402
 * @version April 15, 2016
 * 
 */
public class Dice 
{
	
	private int value;
	
	/**
	 * Default Constructor that just creates a dice with the default value of 0.
	 */
	public Dice()
	{
		
	}
	
	/**
	 * Constructor to roll a dice with the specified number of sides 
	 * 
	 * @param numberOfSides - the number of sides or possible values that the dice could have
	 */
	public Dice(int numberOfSides) //for future use potentially
	{
		Random roll = new Random();
		value = roll.nextInt(numberOfSides)+ 1;
	}
	
	/**
	 * roll - the function to simulate the rolling of the dice, assigns a random value between 1-6 to the dice. 
	 */
	public void roll()
	{
		Random roll = new Random();
		value = roll.nextInt(6) + 1;
	}
	
	/**
	 * setValue - a function to manually set a dice to a desired value 
	 * 
	 * @param newValue - the new value the dice would have rolled
	 */
	public void setValue(int newValue)
	{
		value = newValue;
	}
	
	/**
	 * getValue - returns the value that was rolled
	 * 
	 * @return value - the number rolled on the dice
	 */
	public int getValue()
	{
		return value;
	}
	
	public String toString()
	{
		return  "" + value ;
	}

}
