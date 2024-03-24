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
		this.word = new char[wordLength];
	}

	public void chooseWord()
	{
		Random rand = new Random();
		int numLetters = this.word.length;
		for(int i = correct; i < numLetters; i++)
			word[i] = (char)(65 + rand.nextInt(26));
	}
	public int getCorrect()
	{
		return this.correct;
	}
	public void setCorrect(int correct)
	{
		this.correct = correct;
	}
	public String printWord()
	{
		return new String(word);
	}
	public char[] getWord()
	{
		return this.word;
	}
	public void setWord(String word)
	{
		this.word = word.toCharArray();
	}
	
	public void setWord(char[] word)
	{
		this.word = word;
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