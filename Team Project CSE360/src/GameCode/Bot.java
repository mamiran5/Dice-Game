package diceGame;

import java.util.Random;

/** Bot is a class that will control a computer being used in a game as a user.
 * A safe bot would do Lucky Dice every round
 * A neutral bot would do no actions
 * An aggressive bot would do Dice Block and Hinderance only
 * 
 * @author Manuel Aguirre
 * @version April 29, 2016.
*/

public class Bot {
	private int Type; //-1 for safe, 0 for neutral, 1 for aggressive
	private int Action;

	/** Bot constructor would set the bot's type to the parameter 
	 * 
	 * @param type				will be -1 for a safe bot, 0 for a neutral bot, and 1 for an aggressive bot
	 */
	public Bot(int type){
		Type = type; 
		Action = 0;
	}
	
	/** getType will return the integer value corresponding to the bot's type
	 * 
	 * @return Type				the bot's type: -1 for safe, 0 for neutral, and 1 for aggressive
	 */
	public int getType(){
		return Type;
	}
	
	/** chooseAction will set the value of the Action variable according to the type of action that the bot will perform
	 * 
	 */
	public void chooseAction(){
		if(Type == 0) // if a neutral bot, set Action to -1 which will mean no action being performed
			Action = -1;
		else if(Type == -1){ //if a safe bot, set Action to 0 which will cause the bot to always use Lucky Dice
			Action = 0;
		}
		else if(Type == 1){ //if an aggressive bot, it will randomize whether it uses Dice Block or Hinderance, an even number would set Action's value to 1, an odd number woud set Action's value to 2
			Random roll = new Random();
			if(roll.nextInt(10)%2 == 0)
				Action = 1;
			else
				Action = 2;
		}
		
	}
	
	/** getAction will return the Action that the bot will use
	 * 
	 * @return Action			the type of action that will be used
	 */
	public int getAction(){
		return Action;
	}
	
	
}
