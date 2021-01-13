package dice;

public class Dice6 extends Dice{
	public int roll()
	{
		rollValue = r.nextInt(6)+1;
		return rollValue;
	}
	public int arrayRoll()
	{
		int valueRoll = r.nextInt(6);
		return valueRoll;
	}
}
