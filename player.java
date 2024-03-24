
public class player
{
    private int monkeyID;
    private int wager;
    private int wallet;


    public player(int monkeyID, int wager, int wallet)
    {
        this.monkeyID = monkeyID;
        this.wager = wager;
        this.wallet = wallet;
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
        //TODO: no wager over amount of money
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
    
}