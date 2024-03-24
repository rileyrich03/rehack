import java.util.Scanner;

public class Player {
    private int monkeyID;
    private int wager;
    private int wallet;
    private int buyIn;
    Scanner wagerChoice;

    public Player(int monkeyID, int wager, int wallet) 
    {
        this.monkeyID = monkeyID;
        this.wager = wager;
        this.wallet = wallet;
        this.wagerChoice = new Scanner(System.in);
    }

    public void setChoice(int monkeyID) 
    {
        this.monkeyID = monkeyID;
    }

    public int getChoice() 
    {
        return this.monkeyID;
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