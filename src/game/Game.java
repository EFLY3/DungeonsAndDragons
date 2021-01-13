package game;
import dice.*;
import java.util.Scanner;
import characters.*;
import characters.Character;

public class Game 
{
	Dice4 d4 = new Dice4();
	Dice6 d6 = new Dice6();
	Dice12 d12 = new Dice12();
	Dice20 d20 = new Dice20();
	Hero hero = new Hero();
	int round = 0;
	String[][] story = {{"a", "b","c","d"},{"e","f","g","h"},{"i","j","k","l"}};
	Scanner scan = new Scanner(System.in);
	public void run()
	{
		Introduction();
		setCharacter(hero);
		while (hero.isDefeated() == false && round < 3)
		{
			runRound();
			hero.battleReset(); 
			round++;
		}
		Ending();	
	}
	public void Introduction()
	{System.out.println("Welcome to my Dungeons and Dragons prototype! Here, you will create a character and have it go to battle against different enemies! Get to victory without loosing your HP! \n Please keep in mind that this is an experimental game, so many features of the actual DND game will not be available. \n This game is also under construction, so many features will be coming soon!");}
	public void setCharacter(Character c)
	{
		c.setName();
		c.setRace();
		c.setCharaClass();
		c.setWeapon();
		c.setHP();
		c.setAtk();
		c.setDef();
		/*c.setAttacks();
		c.setItems(); */
	}
	public void runRound()
	{
		Enemy e = new Enemy();
		setCharacter(e); 
		System.out.println(createStory());
		while (hero.isDefeated() == false && e.isDefeated()==false)
		{
			turn(hero, e);
			if (hero.isDefeated() == false && e.isDefeated()==false)
			{
				turn(e,hero);
			}
			else if(hero.isDefeated() == true)
			{
				Ending();
			}
			else
			{
				System.out.println(e.getName() + " was defeated!");
			}
		}
	}
	public String createStory()
	{
		String storyString = story[round][d4.arrayRoll()];
		return storyString;
	}
	public void turn(Character attacker, Character defender)
	{	
		System.out.println(attacker.getName() + "'s Stats: \t HP: " + attacker.getHP() + " Attack: " + attacker.getAtk() + " Defense: " + attacker.getDef());
		System.out.println(defender.getName() + "'s Stats: \t HP: " + defender.getHP() + " Attack: " + defender.getAtk() + " Defense: " + defender.getDef());
		switch (attacker.chooseAction())
		{
		case 1: int hpLoss = defender.loseHP(attacker.chooseAttack()); System.out.println(defender.getName() + " lost " + hpLoss + " hp."); break;
		case 2: attacker.defend(); System.out.println(attacker.getName() + " is defending this turn!");break;
		case 3: int recover = attacker.chooseItem(); System.out.println(attacker.getName() + " recovered" + recover + " hp."); break;
		}
	}
   
	public void Ending()
	{
		if(hero.isDefeated()==true)
		{
			System.out.println("Oh no, it looks like you have lost. Try again! \n\n GAME OVER");
		}
		else
		{
			System.out.println("Congratulations! You and " + hero.getName() + " have prevailed! Test your skills again?");
		}
	}
	
	
}
