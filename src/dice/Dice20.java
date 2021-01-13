package dice;

public class Dice20 extends Dice
{
	public int roll()
	{
		rollValue = r.nextInt(20)+1;
		return rollValue;
	}
}
