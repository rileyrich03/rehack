import java.util.Scanner;
import java.util.regex.Pattern;

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
		boolean roundFlag = false;
		do
		{
			while(!roundFlag)
			{
				for(int i = 0;i < game.table.length; i++)
				{
					Monkey monkey = game.table[i];
					monkey.chooseGuess();
					monkey.lookWord(game.word);
					roundFlag = game.checkEndRound();
					if(roundFlag)
						i = game.table.length;
				}
			}
			game.endRound();
			roundFlag = false;
		} while(!game.checkEndGame());
		//game.endGame();
	}

	public void startGame()
	{
		System.out.print("1: inky\n"
		               + "2: blinky\n"
					   + "3: pinky\n"
					   + "4: Clyde\n");
        System.out.print("Choose a monkey's ID Badge: ");
        int monkeyChoice = (playerInput.nextInt() - 1) % 4;

        /*System.out.print("\nChoose your Difficulty (1/2): ");
        this.difficultyChoice = playerInput.nextInt();
		*/
		player = new Player(table[monkeyChoice]);
		System.out.println("\nWallet: " + player.getWallet());
        System.out.print("Choose a wager: ");

        wager = playerInput.nextInt();
        if(player.getWallet() < wager)
        {
            while(player.getWallet() < wager)
            {
            System.out.println("choose a bet lower than your wallet!\nChoose a wager: ");
            wager = playerInput.nextInt();
            }
        }
		player.setWallet(player.getWallet() - wager);

		System.out.print("Choose your Word: ");
		playerInput.nextLine();
		String string = playerInput.nextLine().toUpperCase();
		while(!Pattern.matches("[A-Z]+",string)) 
		{
			System.out.println("Word must only contain letters.");
			System.out.print("Choose your Word: ");
			string = playerInput.nextLine().toUpperCase();
		}
		setWord(string);
	}

	public boolean checkEndGame()
	{
		if ((player.getWallet() <= 0) && (wager == 0))
		{
			System.out.println("\nYOURE BROKE!! THE GAME HAS CONCLUDED!!!\n");		
			endGame();
		} else if (player.getWallet() >= 10000)
		{
			System.out.println("\nOH NO! Your pockets were too full and swag too nice.\n"
			                 + "The monkeys stole all your money...THE GAME HAS CONCLUDED!!!");
			endGame();
		}
		return (player.getWallet() <= 0) && (wager == 0);

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
		System.out.println("Would you like to play again? y/n");
		boolean loop = false;
		char choice = playerInput.nextLine().toLowerCase().charAt(0);
		do
		{
			switch(choice)
			{
				case 'y':
					main(null);
					break;
				case 'n':
					System.exit(0);
					break;
				default:
					loop = true;
					System.out.println("Would you like to play again? y/n");
					choice = playerInput.nextLine().toLowerCase().charAt(0);
			}
		}while (loop);
		System.exit(0);		
	}

	public void endRound()
	{
		System.out.println(winner.getName().toUpperCase() + " HAS GUESSED THE WORD!!!\n");		
		//player payout
		if(player.getChoice() == winner) {
			player.setWallet(player.getWallet() + wager * 4);
			System.out.println(wager * 4 + " has been added to your wallet.");		
		} else {
			System.out.println("You have lost " + wager + " to fellow Monkey Money Men.");		
		}
			wager = 0;
		System.out.println("Wallet: " + player.getWallet());
		//Reset monkey correct guess
		for(Monkey monkey : table)
			monkey.setCorrect(0);
		
		//GO AGAIN
		if(checkEndGame())
		{
			return;
		}

		//reprompt monkey
		System.out.print("1: inky\n"
			           + "2: blinky\n"
			           + "3: pinky\n"
			           + "4: Clyde\n");
		System.out.print("Choose a monkey's ID Badge: ");
		player.setChoice(table[(playerInput.nextInt() - 1) % 4]);

		//reprompt wager
        System.out.print("Choose a wager: ");
		wager = playerInput.nextInt();
        if(player.getWallet() < wager)
        {
            while(player.getWallet() < wager)
            {
            System.out.println("choose a bet lower than your wallet!\nChoose a wager: ");
            wager = playerInput.nextInt();
            }
        }
		player.setWallet(player.getWallet() - wager);

		System.out.print("Choose your Word: ");
		playerInput.nextLine();
		setWord(playerInput.nextLine().toUpperCase());
	}

	public void setWord(String word)
	{
        this.word = word;
		for(Monkey monkey : table)
			monkey.setWordLength(word.length());
	}

}