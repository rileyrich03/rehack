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

	public Driver() 
	{
        this.word = null;

		//create monkey array
        table = new Monkey[4];

        //create each monkey
        table[0] = new Monkey("inky", 0);
        table[1] = new Monkey("blinky", 1);
        table[2] = new Monkey ("pinky", 2);
        table[3] = new Monkey("Clyde", 3);

        //create player input
        playerInput = new Scanner(System.in);
	}
	
	public static void main(String[] args)
	{
        Driver game = new Driver();
		game.startGame();
		boolean flag = false;
		while(!flag)
		{
			for(int i = 0;i < game.table.length; i++)
			{
				Monkey monkey = game.table[i];
				monkey.chooseGuess();
				monkey.lookWord(game.word);
				flag = game.checkEndRound();
				if(flag)
					i = game.table.length;
			}
		}
		game.endRound();
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

		System.out.println("Choose your Word: ");
		playerInput.nextLine();
		setWord(playerInput.nextLine());
	}

	public boolean checkEndGame()
	{
		return player.getWallet() <= 0;

	}

	public boolean checkEndRound()
	{
		for (Monkey monkey : table) 
        {
            if(word.equals(monkey.printGuess()))
            {
				winner = monkey;
                return true;
            }
        }
        return false;
	}

	public void endGame()
	{
		System.out.println("THE GAME HAS CONCLUDED!!!\n");		
	}

	public void endRound()
	{
		System.out.println(winner.getName().toUpperCase() + " HAS GUESSED THE WORD!!!\n");		
		if(player.getChoice() == winner)
		{
			player.setWallet(player.getWallet() + wager * 4);
		}
	}

	public void setWord(String word)
	{
        this.word = word;
		for(Monkey monkey : table)
			monkey.setWordLength(word.length());
	}

}