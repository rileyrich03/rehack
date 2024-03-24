import java.util.Random;

public class Monkey{
	private String name;
	private Char[] word;
	private int monkeyID;
	private int correct;
	public Monkey()
	{
		this.name = null;
		this.monkeyID = 0;
		this.correct = 0;
		this.word = newChar[0];
	}
	public Monkey(String name, int monkeyID, int wordLength)
	{
		this.name = name;
		this.monkeyID = monkeyID;
		this.correct = 0;
		this.word = new Char[wordLength];
	}

	private char[] chooseWord()
	{
		Random rand = new Random();
		int numLetters = this.word.length();
		for(int i = 0; i < numletters; i++)
			word[i] = 65 + rand.next() % 26;
	
		return 0;
	}
	public String makeWord()
	{
		return null;
	}
	public int getCorrect()
	{
		return 0;
	}
	public void setCorrect(int correct)
	{
		this.correct = correct;
	}
	public String getWord()
	{
		return this.word;
	}
	public void setWord(String word)
	{
		this.word = word;
	}
}