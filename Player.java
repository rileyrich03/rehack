import java.util.Scanner;

public class Player {
    private Monkey monkey;
    private int wallet;
    private int buyIn;

    public Player(Monkey monkey) 
    {
        this.monkey = monkey;
        //set wallet value initial
        this.wallet = 500;
    }

    public void setChoice(Monkey monkey) 
    {
        this.monkey = monkey;
    }

    public Monkey getChoice() 
    {
        return this.monkey;
    }

    public void setWallet(int wallet) 
    {
        this.wallet = wallet;
    }

    public int getWallet() 
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