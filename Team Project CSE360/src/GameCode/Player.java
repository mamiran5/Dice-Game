package diceGame;

import java.util.ArrayList;

/** Player is a class that will hold a player's name, dice pairs, and current score. It has multiple methods to access and set the private variables.
 * 
 * @author Manuel Aguirre
 * @version April 14, 2016.
*/
public class Player
{
		/** name is a String that holds the player's name. */
		private String name;
		/** pairs is a dicePair array that holds the player's three dice pairs. */
		private DicePair[] pairs = new DicePair[3];
		
		/**This list stores the six dice that are rolled before they are assigned to dicepairs.
		 * 
		 */
		private ArrayList <Dice> diceList = new ArrayList<Dice>();
		
		
		/** score is an int that holds the player's current score. */
		private int score;
		
		/** will determine if the player is safe from other player's actions*/
		private boolean isSafe = false;
		
		//Variable for determining whether the player is computer controlled or player controlled
		private boolean isAComputer = true;
		
		//for statistics and database purposes
				
		private int roundWins; //amount of rounds the player has won
		
		private int pointsSpent; //amount of points the player has spent
		
		private int pointsEarned; //amount of points the player has earned
		
		private int actionsUsed; //amount of actions the player has used
		
		private int wonGame; //will show if the player won the game or not

		/** Player constructor allows the user to set the player's name and scores when the Player object is being created
		 * 
		 * @param inName			inName is the name that the user wants to give the player
		 * @param inScore			inScore is the score that the user wants to give the player
		 */
		
		public Player(String inName, int inScore){
			name = inName;
			score = inScore;
			roundWins = 0;
			pointsSpent = 0;
			pointsEarned = 0;
			actionsUsed = 0;
			wonGame = 0;
		}

		/** setScore will set local variable 'score' to the contents of the parameter inScore
		*
		*@param inScore				inScore is the player's current updated score
		*/

		public void setScore(int inScore){
			score = inScore;
		}
		
		/**
		 * 
		 * @return isAComputer() 	Returns TRUE if player is a computer, Returns FALSE if player is a human person.
		 */
		
		public boolean isAComputer()
		{
			return isAComputer;
		}
		
		/**
		 * 
		 * @param isItAComputer		will let the game know if the player is a computer or not
		 */
		public void setIsItAComputer(boolean isItAComputer)
		{
			isAComputer = isItAComputer;
		}
		
		/** modifyScore will add or subtract from the player's score as needed
		*
		*@param modScore			modScore is the amount that the player's score will be modified(10 for add 10, -10 for subtract 10, etc.)
		*/
		
		public void modifyScore (int modScore)
		{
			score += modScore;
		}
		
		/** setDicePairs will set the contents of the pairs array to the inputed DicePair objects
		*
		*@param first				first is the first DicePair that will be in the array
		*@param second				second is the second DicePair that will be in the array
		*@param third				third is the third DicePair that will be in the array
		*/
		
		public void setDicePairs(DicePair first, DicePair second, DicePair third){
			pairs[0] = first;
			pairs[1] = second;
			pairs[2] = third;				
		}
		
		/** Set Dice List
		 * 
		 */
		public void setDiceList( Dice[] rolledDice )
		{
			//First Clear diceList
			
			diceList = new ArrayList<Dice>();
			
			//Assign the dice in the parameter list to the list of dice owned by the player. 
			for (int diceCount = 0; diceCount<rolledDice.length; diceCount++ )
			{
				diceList.add(rolledDice[diceCount]);
			}
			
		}
		
		/** getDiceList()
		 * 
		 * 
		 * @return the player's dice list
		 */
		public ArrayList<Dice> getDiceList()
		{
			return diceList;
		}
		
		
		/** getName will return the name of the player
		*
		*@return name				name is the name of the player
		*/

		public String getName()
		{
			return name;
		}

		/**public int getDiceForRound(int roundNumber) 
		 * 
		 * returns the sum of the player's rolls for the round indicated.
		 * 
		 * @param roundNumber		The round in which you are checking the player's roll
		 * @return pairRollValue	The value of the rolls they are using for that round.
		 */
		public int getDiceForRound(int roundNumber)
		{
			int pairRollValue = pairs[roundNumber].getSum();
			return pairRollValue;
		}
		
		/** getScore will return the player's current score
		*
		*@return score				score is the player's current score
		*/	
		
		public int getScore(){
			return score;
		}
		
		/** getDicePairs will return the array that holds the player's DicePairs
		*
		*@return pairs				pairs is the array that holds the player's DicePairs
		*/
		
		public DicePair[] getDicePairs()
		{
			return pairs;
		}
		
		/** toString will return the player's name
		 * 
		 *@return name				name is the name of the player
		 */
		
		public String toString()
		{
			return name;
		}
		
		/** Will increase the value of roundWins everytime the player wins a round
		 * 
		 */
		public void roundWinsIncreased(){
			roundWins += 1;
		}
		
		/** Will return the amount of rounds the player won
		 * 
		 * @return roundWins		roundWins is the total number of rounds the player has won
		 */
		public int getRoundWins(){
			return roundWins;
		}
		
		/**Will keep track of the amount of points the player has spent
		 * 
		 * @param actionCost		the amount of points the player spent on an action
		 */
		public void pointsSpentIncreased(int actionCost){
			pointsSpent += actionCost;
		}
		
		/** Will return the amount of points spent during the game
		 * 
		 * @return pointsSpent		the amount of points the player has spent throughout the game
		 */
		public int getPointsSpent(){
			return pointsSpent;
		}
		
		/** Will increase the value of pointsEarned by the amount of the parameter
		 * 
		 * @param roundValue		the amount of points the player earned in the round
		 */
		public void pointsEarnedIncreased(int roundValue){
			pointsEarned += roundValue;
		}
		
		/** Will return the value of pointsEarned 
		 * 
		 * @return pointsEarned		the amount of points the player earned throughout the game
		 */
		public int getPointsEarned(){
			return pointsEarned;
		}
		
		/** Will increment actionsUsed every time the player uses an action
		 * 
		 */
		public void actionsUsedIncreased(){
			actionsUsed += 1;
		}
		
		/** Will return the amount of actions the player used throughout the game
		 * 
		 * @return actionsUsed		the amount of actions the player used throughout the game
		 */
		public int getActionsUsed(){
			return actionsUsed;
		}
		
		/** Will return the value of wonGame which will show if the player is the winner of the game or not
		 * 
		 * @return wonGame			will be 1 if the player won the game
		 */
		public int isWinner(){
			return wonGame;
		}
		
		/** Will set the value of wonGame to 1 if the player won the game
		 * 
		 */
		public void setWinner(){
			wonGame = 1;
		}
		
		/** Will return the value of isSafe
		 * 
		 * @return isSafe			will show if the player is safe from actions or not
		 */
		public boolean getSafe(){
			return isSafe;
		}
		
		/** Will decide if the player is safe from actions 
		 * 
		 * @param value				will be 1 if the player is safe from actions and 0 if not
		 */
		public void setSafe(int value){
			if(value == 1)
				isSafe = true;
			if(value == 0)
				isSafe = false;
		}
}
