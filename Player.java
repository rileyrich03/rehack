import java.util.Scanner;

public class Player {
    private Monkey monkey;
    private int wager;
    private int wallet;
    private int buyIn;
    Scanner wagerChoice;

    public Player(Monkey monkey, int wager, int wallet) 
    {
        this.monkey = monkey;
        this.wager = wager;
        this.wallet = wallet;
        this.wagerChoice = new Scanner(System.in);
    }

    public void setChoice(Monkey monkey) 
    {
        this.monkey = monkey;
    }

    public Monkey getChoice() 
    {
        return this.monkey;
    }

    public void setWager(int wager)
    {
        this.wager = wager;
    }

    public int getWager() 
    {
        return this.wager;
    }

    public void setMoney(int wallet) 
    {
        this.wallet = wallet;
    }

    public int getMoney() 
    {
        return this.wallet;
    }

    public void setBuyIn(int buyIn)
    {
        this.buyIn = buyIn;
    }

    public int getBuyIn()
    {
        return buyIn;
    }

}