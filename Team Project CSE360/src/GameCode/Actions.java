package diceGame;

import java.util.ArrayList;
import java.util.Collections;
/** Actions is the class that holds the actions that players can perform on other players.
 * 
 * @author Manuel Aguirre
 * @version April 28, 2016.
*/
public class Actions {
	
	private Player user; //The player that will perform the action
	private Player recipient; //The player that will have the action performed on them
	private int actionType; //An int corresponding to the action being performed
	private int roundNumber; //The round that the action is being performed in
	
	/**Actions is the constructor that takes a performer, a receiver, an actionNumber corresponding to the action type, and the round number
	 * 
	 * @param performer				the player using the action
	 * @param receiver				the recipient of the action
	 * @param actionNumber			an int corresponding to the action being used
	 * @param roundNumber			the round the action is being performed in
	 */
	public Actions(Player performer, Player receiver, int actionNumber, int roundNumber){
		user = performer;
		recipient = receiver;
		actionType = actionNumber;
		roundNumber = roundNumber;
	}
	
	/** returns the int corresponding to the action being used
	 * 
	 * @return actionType			an int corresponding to the action being used
	 */
	public int getactionType(){
		return actionType;	
	}
	
	/**perform is the method that calls the method for the action being used
	 * 
	 */
	public void perform(){
		switch(actionType){
		case 0:		luckyDice();
					break;
		case 1:		diceBlock(roundNumber);
					break;
		case 2:		Hinderance(roundNumber);
					break;
		default:	break;
		}
	}
	
	/** Hinderance will cost 50 points and will subtract the sum of the user's two lowest dice from the targets dice sum for the selected round
	 * 
	 * @param currentRound			the round that hinderance will be used in
	 */
	public void Hinderance(int currentRound){
		user.modifyScore(-50);
		user.pointsSpentIncreased(50);
		user.actionsUsedIncreased();
		
		if(!recipient.getSafe()){
			int min1 = 7;
			int min2 = 7;
			
			for(int dicePairIndex = 0; dicePairIndex < 3; dicePairIndex++){
				
				for(int diceIndex = 0; diceIndex < 2; diceIndex++){
					int value = user.getDicePairs()[dicePairIndex].getDie(diceIndex);
					
					if(value <= min1){
						min2 = min1;
						min1 = value;
						
					}
					else if(value > min1 && value < min2){
						min2 = value;
					}
					
				}
			
			}
			recipient.getDicePairs()[currentRound].setModifier(-(min1+min2));
		}
	}
	
	/** Dice Block will cost 125 points and will subtract the user's third and fourth lowest dice from the target's dice sum for the selected round
	 * 
	 * @param currentRound			the round that Dice Block will be used in
	 */
	public void diceBlock(int currentRound){
		user.modifyScore(-125);
		user.pointsSpentIncreased(125);
		user.actionsUsedIncreased();

		if(!recipient.getSafe()){
			ArrayList<Integer> dice = new ArrayList<Integer>(6);
			
			for(int dicePairIndex = 0; dicePairIndex < 3; dicePairIndex++){	
				for(int diceIndex = 0; diceIndex < 2; diceIndex++){
					 dice.add(user.getDicePairs()[dicePairIndex].getDie(diceIndex));
				}
			}
			
			Collections.sort(dice);
			int min3 = dice.get(2);
			int min4 = dice.get(3);
			
			recipient.getDicePairs()[currentRound].setModifier(-(min3+min4));
		}
		
	}
	
	/**luckyDice will cost 100 points and will protect the user from any actions that someone else chooses to use on them for one round
	 * 
	 */
	public void luckyDice(){
		user.modifyScore(-100);
		user.pointsSpentIncreased(100);
		user.actionsUsedIncreased();
		
		user.setSafe(1);
		
	}
}
