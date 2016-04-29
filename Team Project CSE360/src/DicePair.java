package diceGame;

/**
 * The DicePair class is keeps track of the dice pairs that the user makes for each turn. As such it has two dice objects
 * that make up the pair and provides the ability to compare and reroll.
 * 
 * @author Mauricio Gutierrez for CSE 360, PIN: 402
 * @version April 15, 2016
 * 
 */
public class DicePair 
{
	
	private Dice dice1;
	
	private Dice dice2;
	
	private int modifier = 0;
	/**
	 * Constructor that initializes the object to the two die chosen to be paired by the player, passed in as parameters. 
	 * 
	 * @param newDice1 - the first dice of the pair
	 * @param newDice2 - the fother dice chosen to be paired
	 */
	public DicePair(Dice newDice1, Dice newDice2)
	{
		dice1 = newDice1;
		dice2 = newDice2;
	}
	
	/**
	 * getSum - the sum of the rolls for the pair of dice
	 * 
	 * @return sum - the total number rolled on the dice pair
	 */
	public int getSum()
	{
		int sum;
		sum = dice1.getValue() + dice2.getValue();
		return sum + modifier;
	}
	
	public void setModifier(int mod)
	{
		modifier += mod;
	}
	
	/**
	 * compare - compares this pair of dice to the one passed in as a parameter
	 * and returns an iteger depending on the outcome as follows:
	 * 1 - this pair wins;
	 * 0 - tie;
	 * -1 - this pair loses.
	 * 
	 * @param neanotherPair - the pair of dice we want to compare to
	 * @return win - integer indicating win, loss or draw.
	 */
	public int compare(DicePair anotherPair)
	{
		int win;
		int mySum = getSum();
		int enemySum = anotherPair.getSum();
		if (mySum > enemySum) // if I win return 1
			win = 1;
		else if (mySum == enemySum)
			win = 0; // if I draw return 0
		else
			win = -1; // if I lose return -1
		return win;
	}

	/**
	 * rerollPair - this function allows us to reroll the dice in the pair to get new values for each.
	 */
	public void rerollPair()
	{
		dice1 = new Dice(6);
		dice2 = new Dice(6);
	}

	public int getDie(int diceIndex) {
		if(diceIndex==0)
			return dice1.getValue();
		else
			return dice2.getValue();
	}
}
