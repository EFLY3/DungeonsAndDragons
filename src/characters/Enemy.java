package characters;
import attacks.AxeAttack2;
import attacks.AxeAttack3;
import attacks.AxeAttack4;
import attacks.Fire;
import attacks.LanceAttack2;
import attacks.LanceAttack3;
import attacks.LanceAttack4;
import attacks.Lightning;
import attacks.SwordAttack2;
import attacks.SwordAttack3;
import attacks.SwordAttack4;
import attacks.Water;
import attacks.axeSlash;
import attacks.lanceStab;
import attacks.magicSpell;
import attacks.swordSlash;
import characters.Character.Weapon;
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
		case 1: 
			weapon = Weapon.sword; 
			attackList[0] = new swordSlash();
			attackList[1] = new SwordAttack2();
			attackList[2] = new SwordAttack3();
			attackList[3] = new SwordAttack4();
			break;
		case 2: 
			weapon = Weapon.axe; 
			attackList[0] = new axeSlash();
			attackList[1] = new AxeAttack2();
			attackList[2] = new AxeAttack3();
			attackList[3] = new AxeAttack4(); 
			break;
		case 3: 
			weapon = Weapon.lance; 
			attackList[0] = new lanceStab();
			attackList[1] = new LanceAttack2();
			attackList[2] = new LanceAttack3();
			attackList[3] = new LanceAttack4();
			break;
		case 4: 
			weapon = Weapon.magic; 
			attackList[0] = new magicSpell();
			attackList[1] = new Fire();
			attackList[2] = new Water();
			attackList[3] = new Lightning(); 
			break;
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

		             case 1: case 2: choice = 1; break;

		             case 3: case 4: choice = 2; break;

		             case 5: case 6: choice = 3; break;

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

