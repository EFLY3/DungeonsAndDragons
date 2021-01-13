package dice;

public class Dice12 extends Dice
{
	public int roll()
	{
		rollValue = r.nextInt(20)+1;
		return rollValue;
	}
}
