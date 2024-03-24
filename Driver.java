import java.util.Scanner;

public class Driver
{
	private Monkey[] table;
	private Player player;
	private String word;
    private int wallet;
    private Scanner playerInput;
    int wager;

	public Driver() 
	{
        //create monkey array
        table = new Monkey[4];

        //create each monkey
        table[0] = new Monkey("inky", 0, word.length());
        table[1] = new Monkey("blinky", 1, word.length());
        table[2] = new Monkey ("pinky", 2, word.length());
        table[3] = new Monkey("Clyde", 3, word.length());

        //set wallet value initial
        this.wallet = 500;

        //create player input
        playerInput = new Scanner(System.in);
	}
	
	public static void Main(String[] args)
	{
        
	}

	public void StartGame()
	{
        System.out.print("Choose a monkey's ID Badge");
        int monkeyChoice = playerInput.nextInt();

        System.out.print("\nChoose your Difficulty (1/2)");
        int difficultyChoice = playerInput.nextInt();

        System.out.print("Choose a wager: ");

        wager = playerInput.nextInt();
        if(this.wallet < wager)
        {
            while(this.wallet < wager)
            {
            System.out.println("choose a bet lower than your wallet!");
            wager = playerInput.nextInt();
            }
        }   
        
        player = new Player(monkeyChoice, wager, difficultyChoice);


	}

	public boolean checkEndGame()
	{
		return false;
	}

	public boolean checkEndRound()
	{
		return false;
	}

	public boolean endGame()
	{
		return false;
	}

	public boolean endRound()
	{
		return false;
	}

	public void setWord(String word)
	{
        this.word = word;
	}

}