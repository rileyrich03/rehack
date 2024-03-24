import java.util.Scanner;

public class Driver
{
	private Monkey[] table;
	private Player player;
	private String word;
    private int wallet;
    private Scanner playerInput;
    private int wager;
    private Monkey winner;

	public Driver(String word) 
	{
        this.word = word;

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
	
	public static void main(String[] args)
	{
        Driver game = new Driver("Word");
		game.startGame();

		while(!game.checkEndGame())
		{
			for(Monkey monkey : game.table)
			{
				monkey.chooseWord();
				System.out.println("Monkey: " + monkey.getName() + " says " + monkey.printWord());
			}
		}
	}

	public void startGame()
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
		return player.getMoney() <= 0;

	}

	public boolean checkEndRound()
	{
		for (Monkey monkey : table) 
        {
            if(monkey.getCorrect() == this.word.length())
            {
                return true;
            }
        }
        return false;
	}

	public boolean endGame()
	{
		return false;
	}

	public void endRound()
	{
		if(player.getChoice() == )
	}

	public void setWord(String word)
	{
        this.word = word;
	}

}