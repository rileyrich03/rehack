
public class Render 
{
    private String Monkeys;
    private String strung;
    private Driver gameLogic;

    public Render()
    {
        System.out.print("\033[H\033[2J");
        
        for(int i = 0; i < 4; i++)
        {
            System.out.println("-------------------------------------------------");
            System.out.print(gameLogic.getMonkeyName(i));
        }



    }

    public static void main(String[] args)
    {
        Driver gameLogic = new Driver();
        
    }

    public void addLetter(int monkey)
    {
        for(int i = 0; i < 3; i++)
        {
            System.out.print()
        }


    }

}

