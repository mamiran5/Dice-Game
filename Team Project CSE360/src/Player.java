/** Player is a class that will hold a player's name, dice pairs, and current score. It has four methods, setName, setScore, getName, and getScore
 * @author Manuel Aguirre
 * @version April 6, 2016.
*/
public class Player
{
		/** name is a String that holds the player's name. */
		private String name;
		/** pairs is a dicePair array that holds the player's three dice pairs. */
		private dicePair[] pairs = new dicePair[3];
		/** score is an int that holds the player's current score. */
		private int score;

		/** setName will set local variable 'name' to the contents of the parameter inName
		*
		*@param inName				inName is the player name that user inputs
		*/

		public void setName(String inName){
			name = inName;
		}

		/** setScore will set local variable 'score' to the contents of the parameter inScore
		*
		*@param inScore				inScore is the player's current updated score
		*/

		public void setScore(int inScore){
			score = inScore;
		}

		/** getName will return the name of the player
		*
		*@return name				name is the name of the player
		*/

		public int getName(){
			return name;
		}

		/** getScore will return the player's current score
		*
		*@return score				score is the player's current score
		*/

		public String getScore(){
			return score;
		}
}
