package characters;
import java.util.Scanner;

public class Hero extends Character{
	Scanner scan;
	
	public Hero()
	{
		super();
		scan = new Scanner(System.in);
	}
    public void setName()
	{
		System.out.println("What would you like to name your hero?");
		name = scan.nextLine();
	}
	public void setRace() 
	{
		boolean validInput = false;
		while (validInput == false)
		{
		System.out.println("Next, what race would you like your character to be?");
		String raceName = scan.nextLine();
		switch(raceName) {
		case "dragon": race = Race.dragon; validInput = true; break;
		case "human": race = Race.human; validInput = true; break;
		case "elf": race = Race.elf; validInput = true; break;
		case "dwarf": race = Race.dwarf; validInput = true; break;
		case "goblin": race = Race.goblin; validInput = true; break;
		case "demon": race = Race.demon; validInput = true; break;
		default: System.out.print("Sorry, that race is not supported in this version of the game. Please pick again");
		}}
	}
	public void setCharaClass()
	{
		boolean validInput = false;
		while (validInput == false)
		{
		System.out.println("Next, what class would you like your character to be?");
		String charaClassName = scan.nextLine();
		switch(charaClassName) {
		case "fighter": charaClass = characterClass.fighter; validInput = true; break;
		case "paladin": charaClass = characterClass.paladin; validInput = true; break;
		case "mage": charaClass = characterClass.mage; validInput = true; break;
		case "cleric": charaClass = characterClass.cleric; validInput = true; break;
		default: System.out.print("Sorry, that class is not supported in this version of the game. Please pick again");
		}}
	}
	public void setWeapon() 
	{
		boolean validInput = false;
		while (validInput == false)
		{
		System.out.println("What weapon would you like to use?");
		String weaponChoice = scan.nextLine();
		switch(weaponChoice) {
		case "sword": weapon = Weapon.sword; validInput = true; break;
		case "axe": weapon = Weapon.axe; validInput = true; break;
		case "lance": weapon = Weapon.lance; validInput = true; break;
		case "magic": weapon = Weapon.magic; validInput = true; break;
		default: System.out.print("Sorry, that weapon is not supported in this version of the game. Please pick again");
		}}
	}
	/*public void setAttacks()
	{}
    public void setItems() 
    {} */
	 public int chooseAction() {
		 boolean validInput = false;
			int choice = 0;
			while(validInput == false)
			{
				System.out.println("Your turn! Press 1 to attack, 2 to defend, and 3 to use an item");
				choice = scan.nextInt();
				if(choice == 1 || choice == 2 || choice == 3)
				{validInput=true;}
				else { System.out.println("That is not a valid option. Select again");}
				}
			return choice;
	}
    public int chooseAttack() {
		boolean validInput = false;
		int choice = 0;
		System.out.println("Here is your current list of attacks: \n");
		for (int i = 1; i < 5; i++)
		{
			System.out.println(i + ".\t"+attackList[i-1].getName());
		}
		while (validInput == false)
		{
			System.out.println("Press the number corresponding to the attack you want to use.");
			choice = scan.nextInt()-1;
			if(choice == 0 || choice == 1 || choice ==2)
			{
				validInput=true;
				System.out.println("You used " + attackList[choice].getName() + "!");
			}
			else {
			 System.out.println("That is not a valid option. Select again");
			}
		}	
		return attackList[choice].use(d20.roll(), atk);
	}
    public int chooseItem() {
		boolean validInput = false;
		int choice = 0;
		System.out.println("Here is your current list of items: ");
		for (int i = 1; i<4; i++)
		{
			System.out.println(i+".\t"+itemList[i-1].getName());
		}
		while (validInput == false)
		{
			System.out.println("Press the number corresponding to the item you want to use.");
			choice = scan.nextInt()-1;
			if(choice == 0 || choice == 1 || choice == 2)
			{validInput = true;
			System.out.println("You used " + itemList[choice].getName() + "!");} 
			else {System.out.println("That is not a valid option. Select again.");}
		}
		return itemList[choice].use();
	}
}


