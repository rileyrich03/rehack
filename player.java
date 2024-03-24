
public class player
{
    private int monkey;
    private int monkeyID;
    private int wager;
    private int wallet;


    public player(int monkeyID, int Wager, int wallet)
    {
        this.monkeyID = monkeyID;
        this.wager = wager;
        this.wallet = wallet;
    }


    public void setChoice(int monkeyID)
    {
        this.MonkeyID = monkeyID;
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


    public void setMoney(int money)
    {
        this.wallet = money
    }

    
    public int getMoney()
    {
        return this.wallet;
    }
    
}