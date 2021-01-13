package dice;
import java.util.Random;

abstract public class Dice 
{
	int rollValue;
	Random r = new Random();
	abstract int roll();
}

