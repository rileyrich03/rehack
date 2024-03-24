
public class Render 
{
    private String Monkeys;
    private String strung;
    private Driver gameLogic;

    public Render()
    {
        System.out.print("\033[H\033[2J");
        System.out.println("-------------------------------------------------");
        for(int i = 0; i < 4; i++)
        {
            System.out.print(gameLogic.getMonkeyName(i));

            for(int j = 0; j < gameLogic.getWord().length(); j++)
            {
                int c = gameLogic.getTable()[i].getCorrect();

                for(int k = 0 ; k < c; k++)
                {
                    System.out.print(gameLogic.getWord().charAt(k));
                }
            }
            System.out.println();
        }
        System.out.println("-------------------------------------------------");



    }

    public static void main(String[] args)
    {
        Driver gameLogic = new Driver();
        gameLogic.play();
        
    }

}

