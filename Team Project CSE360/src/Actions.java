package diceGame;

public class Actions {
	
	private Player user;
	private Player recipient;
	
	public Actions(Player performer, Player receiver){
		user = performer;
		recipient = receiver;
	}
	
	public void hinderance(){
		user.modifyScore(-50);
		
		int min1 = 7;
		int min2 = 7;
		
		for(int dicePairIndex = 0; dicePairIndex < 3; dicePairIndex++){
			
			for(int diceIndex = 0; diceIndex < 2; diceIndex++){
				int value = user.getDicePairs()[dicePairIndex].getDie(diceIndex);
				
				if(value < min1){
					min1 = value;
				}
				else if(value >= min1 && value < min2){
					min2 = value;
				}
				
			}
		
		}
		
	}
	
}
