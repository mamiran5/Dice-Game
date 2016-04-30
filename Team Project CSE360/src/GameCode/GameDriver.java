package diceGame;

import java.util.*;

public class GameDriver 
{

	private ArrayList<Player> playerList = new ArrayList<Player>();
	private Turn currentTurn = null;
	private Player currPlayer = null;
	
	public void addPlayer(Player newPlayer)
	{
		//Set computer status to false
		newPlayer.setIsItAComputer(false);
		playerList.add(newPlayer);
	}
	
	public ArrayList<Player> getCurrPlayers()
	{
		return playerList;
	}
	public void addComputerPlayers()
	{
		while(playerList.size() < 4)
		{
			String playerName = "Computer " + playerList.size(); 
			playerList.add(new Player(playerName, 500));
		}
	}
	
	public void startATurn()
	{
		currentTurn = new Turn(playerList);
	}
	
	public void startRolls()
	{
		currentTurn.rollDice();
	}
	
	public void startReRolls()
	{
		
	}
	
	public String getDiceListRoll(Player currPlayer, int position)
	{
		return "" + currPlayer.getDiceList().get(position); 
	}
	
	public int getDiceListValue(Player currPlayer, int position)
	{
		return currPlayer.getDiceList().get(position).getValue(); 
	}
	
}
