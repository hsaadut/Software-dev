import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

//Haseeb Saadut

public class InGameMenu extends Player
{
	public int Score;
	public int gameState;
	public String helpCommands;
	
	public InGameMenu(int healthPoints, int manaPoints, int attackPoints,
			int defensePoints, int speed, String playerName, int score,
			int gameState, String helpCommands) 
	{
		super();
		Score = score;
		this.gameState = gameState;
		this.helpCommands = helpCommands;
	}

	public int getScore() {
		return Score;
	}

	public void setScore(int score) {
		Score = score;
	}

	public int getGameState() {
		return gameState;
	}

	public void setGameState(int gameState) {
		this.gameState = gameState;
	}

	public String getHelpCommands() {
		return helpCommands;
	}

	public void setHelpCommands(String helpCommands) {
		this.helpCommands = helpCommands;
	}

	public void saveGame()
	{
		String fileName = "Game.txt";
		try{
			FileWriter fw = new FileWriter(fileName);
			BufferedWriter bufferedWriter = new BufferedWriter(fw);
			bufferedWriter.write("HP " + healthPoints);
			bufferedWriter.write("Mana " + manaPoints);
			bufferedWriter.write("Attack " + attackPoints);
			bufferedWriter.write("Defense " + defensePoints);
			bufferedWriter.write("Speed " + speed);
			//bufferedWriter.write("Items Saved" + inventoryList);
			//bufferedWriter.write("Room location Saved" + roomDescription);
			bufferedWriter.write("Gamestate " + gameState);
			bufferedWriter.close();
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
	}

	public void quitGame()
	{
		new GameSystem().quitGame();
	}

	public void increaseScore(int n)
	{
		Score+=n;
	}

	public void decreaseScore(int n)
	{
		Score-=n;
	}

	public void multiplyScore()
	{
		
	}

	public void getHelp()
	{
		new GameSystem().howToPlay();
	}
}
