package diceGame;

import java.util.*;

/**This GameDriver Class serves as a link between the GUI and the other driver systems by allowing the GUI to call various 
 * methods when buttons are pressed as well as access variables of various data classes that are utilized by the dice game.
 * 
 * @author mfraiz
 *
 */
public class GameDriver 
{

	//This list stores the current players
	private ArrayList<Player> playerList = new ArrayList<Player>();
	private Turn currentTurn = null;
	
	
	/**addPlayer(Player newPlayer)
	 * 
	 * Add a player through the welcome screen
	 * @param newPlayer Player Object to be added.
	 */
	public void addPlayer(Player newPlayer)
	{
		//Set computer status to false
		newPlayer.setIsItAComputer(false);
		playerList.add(newPlayer);
	}
	
	/**
	 * Get current players
	 * @return playerList 	A list of the current Players
	 */
	public ArrayList<Player> getCurrPlayers()
	{
		return playerList;
	}
	
	/**addComputerPlayers()
	 * 
	 * Fills in the rest of the player slots with computer AI players
	 */
	public void addComputerPlayers()
	{
		while(playerList.size() < 4)
		{
			String playerName = "Computer " + playerList.size(); 
			playerList.add(new Player(playerName, 500));
		}
	}
	
	/**startAturn()
	 * Signals the start of a new turn and the creation of a turn object to represent that turn
	 * 
	 */
	public void startATurn()
	{
		currentTurn = new Turn(playerList);
	}
	
	/**startRolls()
	 * Starts the rollphase of a turn.
	 * 
	 */
	public void startRolls()
	{
		currentTurn.rollDice();
	}
	
	/**getDiceListRoll
	 * 
	 * @param currPlayer	the player who's dice rolls you wish to retrieve
	 * @param position  the roll you wish to retrieve (0 is the first roll, 5 is the last roll)
	 * 
	 * @return Returns a String representation of a player's dice roll indexed by position
	 */
	public String getDiceListRoll(Player currPlayer, int position)
	{
		return "" + currPlayer.getDiceList().get(position); 
	}
	
	/**getDiceListValue
	 * 
	 * @param currPlayer	the player who's dice rolls you wish to retrieve
	 * @param position  the roll you wish to retrieve (0 is the first roll, 5 is the last roll)
	 * 
	 * @return Returns an int representation of a player's dice roll indexed by position
	 */
	public int getDiceListValue(Player currPlayer, int position)
	{
		return currPlayer.getDiceList().get(position).getValue(); 
	}
	
}
