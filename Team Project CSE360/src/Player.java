package diceGame;
/** Player is a class that will hold a player's name, dice pairs, and current score. It has four methods, setName, setScore, getName, and getScore
 * @author Manuel Aguirre
 * @version April 6, 2016.
*/
public class Player
{
		/** name is a String that holds the player's name. */
		private String name;
		/** pairs is a dicePair array that holds the player's three dice pairs. */
		private DicePair[] pairs = new DicePair[3];
		/** score is an int that holds the player's current score. */
		private int score;

		public Player(String inName, int inScore){
			name = inName;
			score = inScore;
		}

		/** setScore will set local variable 'score' to the contents of the parameter inScore
		*
		*@param inScore				inScore is the player's current updated score
		*/

		public void setScore(int inScore){
			score = inScore;
		}
		
		public void setDicePairs(DicePair first, DicePair second, DicePair third){
			pairs[0] = first;
			pairs[1] = second;
			pairs[2] = third;				
		}

		/** getName will return the name of the player
		*
		*@return name				name is the name of the player
		*/

		public String getName(){
			return name;
		}

		/** getScore will return the player's current score
		*
		*@return score				score is the player's current score
		*/

		public int getScore(){
			return score;
		}
		public DicePair[] getDicePairs(){
			return pairs;
		}
		
}
