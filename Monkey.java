import java.util.Random;

public class Monkey{
	private String name;
	private char[] word;
	private int monkeyID;
	private int correct;
	public Monkey()
	{
		this.name = null;
		this.monkeyID = 0;
		this.correct = 0;
		this.word = new char[0];
	}
	public Monkey(String name, int monkeyID, int wordLength)
	{
		this.name = name;
		this.monkeyID = monkeyID;
		this.correct = 0;
		this.guess = new char[wordLength];
	}

	public void chooseWord()
	{
		Random rand = new Random();
		int numLetters = this.guess.length;
		for(int i = correct; i < numLetters; i++)
			guess[i] = (char)(65 + rand.nextInt(26));
	}

	public boolean lookWord(String word)
	{
		char[] wordArr = word.toCharArray();
		for(int i = correct; i < guess.length; i++)
		{
			if(wordArr[i] == guess[i])
			{
				correct++;
				System.out.print(this.name.toUpperCase() + " HAS LOCKED IN ");
				for(int j = 0; j < correct; j++)
					System.out.print(guess[j]);
				System.out.println();
			}
			else
				return false;
		}
		return true;
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
	public String getName()
	{
		return this.name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
}