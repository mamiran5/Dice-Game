package diceGame;

import java.util.ArrayList;
import java.util.Collections;

public class Actions {
	
	private Player user;
	private Player recipient;
	private int actionType;
	private int roundNumber;
	
	public Actions(Player performer, Player receiver, int actionNumber, int roundNumber){
		user = performer;
		recipient = receiver;
		actionType = actionNumber;
		roundNumber = roundNumber;
	}
	
	public int getactionType(){
		return actionType;	
	}
	
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
	
	public void Hinderance(int currentRound){
		user.modifyScore(-50);
		
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
	
	public void diceBlock(int currentRound){
		user.modifyScore(-125);
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
	public void luckyDice(){
		user.modifyScore(-100);
		user.setSafe(1);
		
	}
}