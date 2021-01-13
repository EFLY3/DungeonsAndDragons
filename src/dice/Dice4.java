package dice;

public class Dice4 extends Dice{
	public int roll()
	{
		rollValue = r.nextInt(4)+1;
		return rollValue;
	}

	public int arrayRoll()
	{
		int valueRoll = r.nextInt(4);
		return valueRoll;
	}
}