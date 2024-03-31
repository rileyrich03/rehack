import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Monkey{
	private String name;
	private char[] guess;
	private int correct;
	public Monkey()
	{
		this.name = null;
		this.correct = 0;
		this.guess = new char[0];
	}
	public Monkey(String name, int monkeyID)
	{
		this.name = name;
		this.correct = 0;
		this.guess = new char[0];
	}

	public void chooseGuess()
	{
		Random rand = new Random();
		int numLetters = this.guess.length;
		for(int i = correct; i < numLetters; i++)
			guess[i] = (char)('A' + rand.nextInt(26));
	}

	public boolean lookWord(String word)
	{
		boolean flag = false;
		char[] wordArr = word.toCharArray();
		for(int i = correct; i < guess.length; i++)
		{
			if(wordArr[i] == guess[i])
			{
				flag = true;
				correct++;
				//System.out.print(this.name.toUpperCase() + " HAS LOCKED IN ");
				//for(int j = 0; j < correct; j++)
				//	System.out.print(guess[j]);
				//System.out.println();
				//try
				//{
				//	TimeUnit.MILLISECONDS.sleep(350);
				//} 
				//catch (InterruptedException ie) 
				//{
				//	System.out.println("ERROR ERROR ERROR");
				//	System.exit(0);
				//}

			}
			else
				return flag;
		}
		return flag;
	}
	public int getCorrect()
	{
		return this.correct;
	}
	public void setCorrect(int correct)
	{
		this.correct = correct;
	}
	public String printGuess()
	{
		return new String(guess);
	}
	public char[] getGuess()
	{
		return this.guess;
	}
	public void setGuess(String guess)
	{
		this.guess = guess.toCharArray();
	}
	
	public void setWord(char[] guess)
	{
		this.guess = guess;
	}

	public void setWordLength(int length)
	{
		this.guess = new char[length];
	}

	public String getName()
	{
		return this.name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String toString()
	{
		String locked = new String(guess).substring(0, correct).toUpperCase();
		String loose = new String(guess).substring(correct).toLowerCase();
		String string = name + ": " + locked + loose;
		return string;
	}
}