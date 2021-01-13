package characters;
import dice.*;

public class Enemy extends Character{
    Dice6 choiceDice1;
    Dice4 choiceDice2;
    String[] names = {"Merle","Magnus","Taako","Arthur","Aragon","Richard"};
	
    public Enemy()
    {
    	super();
    	choiceDice1 = new Dice6();
    	choiceDice2 = new Dice4();
    }
	public void setName() 
	{this.name = names[choiceDice1.arrayRoll()];}
	public void setRace() 
	{
		switch(choiceDice1.roll())
		{
		case 1: this.race = Race.dragon; break;
		case 2: this.race = Race.human; break;
		case 3: this.race = Race.elf; break;
		case 4: this.race = Race.dwarf; break;
		case 5: this.race = Race.goblin; break;
		case 6: this.race = Race.demon; break;
		}
	}
	public void setCharaClass() 
	{
		switch(choiceDice2.roll())
		{
		case 1: this.charaClass = characterClass.fighter; break;
		case 2: this.charaClass = characterClass.paladin; break;
		case 3: this.charaClass = characterClass.mage; break;
		case 4: this.charaClass = characterClass.cleric; break;
		}
	}
	public void setWeapon() 
	{
		switch(choiceDice2.roll())
		{
		case 1: this.weapon = Weapon.sword; break;
		case 2:  this.weapon = Weapon.axe; break;
		case 3: this.weapon = Weapon.lance; break;
		case 4: this.weapon = Weapon.magic; break;
		}
	}
	public void setAttacks() 
	{}
	public void setItems() 
	{}
	public int chooseAction()
	{
		int choice = 0;
		switch(choiceDice1.roll())
		{
		case 1: case 2: choice = 1;
		case 3: case 4: choice = 2;
		case 5: case 6: choice = 3;
		}
		return choice;
	}
    public int chooseAttack() 
    {
		int choice = 0;
		switch(choiceDice1.roll())
		{
		case 1: case 2: choice = 0; break;
		case 3: case 4: choice = 1; break;
		case 5: case 6: choice = 2; break;
		}
		System.out.println(name +" used " + attackList[choice].getName() + "!");
        return attackList[choice].use(d20.roll(), atk);
	}
    public int chooseItem() 
    {
		int choice = 0;
		int roll = choiceDice1.roll();
		switch(roll)
		{
		case 1: case 2: choice = 0; break;
		case 3: case 4: choice = 1; break;
		case 5: case 6: choice = 2; break;
		}
		System.out.println(name +" used " + itemList[choice].getName() + "!");
		return itemList[choice].use();
	}
}

