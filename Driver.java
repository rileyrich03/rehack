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
	private int difficultyChoice;

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
        System.out.println("Choose a monkey's ID Badge: ");
        int monkeyChoice = playerInput.nextInt();

        System.out.println("\nChoose your Difficulty (1/2): ");
        this.difficultyChoice = playerInput.nextInt();

		player = new Player(table[monkeyChoice]);
		System.out.println("\nWallet: " + player.getWallet());
        System.out.println("Choose a wager: ");

        wager = playerInput.nextInt();
		System.out.println("Your wager:" + wager);
		System.out.println("your wallet:" + player.getWallet());
        if(player.getWallet() < wager)
        {
            while(player.getWallet() < wager)
            {
            System.out.println("choose a bet lower than your wallet!");
            wager = playerInput.nextInt();
            }
        }
		player.setWallet(player.getWallet() - wager);   
        System.exit(0);
	}

	public boolean checkEndGame()
	{
		return player.getWallet() <= 0;

	}

	public boolean checkEndRound()
	{
		for (Monkey monkey : table) 
        {
            if(monkey.getCorrect() == this.word.length())
            {
				winner = monkey;
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
		if(player.getChoice() == winner)
		{
			player.setWallet(player.getWallet() + wager * 4);
		}
	}

	public void setWord(String word)
	{
        this.word = word;
	}

}