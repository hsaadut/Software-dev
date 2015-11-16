import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Scanner;

//Haseeb Saadut

public class GameSystem 
{
	public int gameState;
	public String credits;
	public String Help;
	
	public static void newGame() throws IOException
	{
		Player p = new Player();
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome player to ANIME: Please enter username");
		String userinput = input.nextLine();
		p.setPlayername(userinput);
		String playerName = p.getPlayername();
		File f = new File(playerName + " -Game.txt");
		System.out.println("Creating game...");
		PrintWriter pw = new PrintWriter((new FileWriter(f)));
		pw.println(playerName);
		pw.close();
	}
	
	public void loadGame() throws IOException
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the name of the file");
		String playerName = input.next();
		File f = new File(playerName + " -Game.txt");
		if(f.exists())
		{
		String fileName = (playerName + " -Game.txt");
		String GameTextLine = null;
		try{
			FileReader fr = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fr);
			System.out.println(fileName);
			
			while((GameTextLine = bufferedReader.readLine()) != null) {
                System.out.println(GameTextLine);
            }   
			bufferedReader.close();  
		}
		catch(FileNotFoundException ex) {
			System.out.println("Error loading file " + fileName);
		}
		catch(IOException ex) {
			ex.printStackTrace(); 
		}
		}
		
	}
	
	public void howToPlay()
	{
		System.out.println("Command Name             Command Description                                                 ");
		System.out.println("------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("New Game                 Creates a new Game                                                                            ");
		System.out.println("Load Game                This will load a gamestate at previous savepoint                                                     ");
		System.out.println("Display Credits          Shows names of people who contributed to game                                                        ");
		System.out.println("Quit Game                Quits the game after confirming with player                                                          ");
		System.out.println("Move                     Changes the location of the player after answering a prompt of which rooms are available to travel to");
		System.out.println("Display Room Scene       Describe for the player once more what is in the room                                                ");
		System.out.println("Search Room              Player will search the room for an item that will go into inventory                                  ");
		System.out.println("Equip item               Take an item found from room or inventory  and equip onto player                                     ");
		System.out.println("Use Item                 Use an item for a variety of effects that will either affect the player or monster                   ");
		System.out.println("Help                     Display a list of commands that will tell the player what he can do at any point in the game         ");
		System.out.println("Save Game                Gives code so that player may enter that Title Screen to re-enter the game with the same progress    ");
		System.out.println("Quit Game                Quits the game without saving");
		System.out.println("Attack                   Gives player the action to attack an enemy with/without weapon  ");
		System.out.println("Use Item                 Allows player to use item in game for a variety of effects");
		System.out.println("Run                      Allows player the option to flee from enemy");
		System.out.println("Ask Riddle               ???");
		System.out.println("Answer Riddle            Gives player option to input an answer for a question");
		System.out.println("Get Hint                 Shows a hint for the riddle ");
	}
	
	public void displayCredits()
	{
		System.out.println("These are the people who contributed to the game...");
	}
	
	public void quitGame()
	{
		System.out.println("The game will now close...");
		System.out.println("Are you sure?");
		System.out.println("Yes       No");
		Scanner input = new Scanner(System.in);
		String userinput = input.nextLine();
		
		if(userinput.equals("yes"))
		{
			System.exit(1);
		}
				
		else 
		{
			return;
		}
	}
	
	
	public static void main (String args[]) throws IOException
	{	
		Scanner input = new Scanner(System.in);	
		
		System.out.println("Welcome to the A Night To The Movies project: ");
		System.out.println(" 1. New Game" );
		System.out.println(" 2. Load Game");
		System.out.println(" 3. Help");
		System.out.println(" 4. Credits");
		System.out.println(" 5. Quit");	
		
		int userInput = input.nextInt();
		
		if (userInput == 1)
        {
			GameSystem.newGame();
        } 
		
		else if (userInput == 2)
        {
			new GameSystem().loadGame();
        } 
		
		else if (userInput == 3)
        {
			new GameSystem().howToPlay();
        } 
		
		else if (userInput == 4)
        {
			new GameSystem().displayCredits();
        } 
		
		else if (userInput == 5)
        {
			new GameSystem().quitGame();
        } 
		
		else 
        {
			System.out.println("Invalid choice....please choose from the above options");
        } 
	}
}

