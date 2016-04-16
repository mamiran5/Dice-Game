package diceGame;

public class DicePair {
	
	private Dice dice1;
	
	private Dice dice2;
	
	public DicePair(Dice newDice1, Dice newDice2)
	{
		dice1 = newDice1;
		dice2 = newDice2;
	}
	
	public int getSum()
	{
		int sum;
		sum = dice1.getValue() + dice2.getValue();
		return sum;
	}
	public int compare(DicePair anotherPair)
	{
		int win;
		int mySum = getSum();
		int enemySum = anotherPair.getSum();
		if (mySum > enemySum)
			win = 1;
		else if (mySum == enemySum)
			win = 0;
		else
			win = -1;
		return win;
	}

	public void rerollPair()
	{
		dice1 = new Dice(6);
		dice2 = new Dice(6);
	}
}