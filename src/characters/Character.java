package characters;
import attacks.*;
import items.*;
import dice.*;

abstract public class Character {
	boolean isDefeated, isDefending;
	String name;
	enum Race {dragon, human, elf, dwarf, goblin, demon};
	enum characterClass {fighter, paladin, mage, cleric};
	enum Weapon {sword, lance, axe, magic};
	Race race;
	characterClass charaClass;
	Weapon weapon;
	int currentHP, BASEHP, atk, def;
	public Attack[] attackList= {new swordSlash(), new lanceStab(), new axeSlash(), new magicSpell()};
	public Item[] itemList={new potion(), new superPotion(), new hyperPotion()};
	Dice20 d20;
	
	
	public Character() {
		isDefeated = false;
		name = " ";
		race = Race.human;
		charaClass = characterClass.fighter;
		weapon = Weapon.sword;
		currentHP=BASEHP=10;
		atk = 14;
		def = 7;
		isDefending = false;
		//attackList = new Attack[3];
		//itemList = new Item[3];
		d20 = new Dice20();
	}
	public boolean isDefeated()
	{
		return isDefeated;
	}
	public String getName()
	 {
		 return name;
	 }
	public Race getRace()
	{
		return race;
	}
    public characterClass getCharaClass()
	 {
		 return charaClass;
	 }
	public Weapon getWeapon()
	 {
		 return weapon;
	 }
	public Attack[] getAttacks()
	 {return attackList;}
	public Item[] getItems()
	{return itemList;}
	public int getHP() 
	{return currentHP;}
	public void setHP() {
		BASEHP = 10;
		switch (race) {
		case dragon:
			BASEHP += 20;
			break;
		case elf:
			BASEHP += 10;
			break;
		case dwarf:
			BASEHP += 5;
			break;
		case goblin:
			BASEHP += 1;
			break;
		case human:
			BASEHP += 2;
			break;
		case demon:
			BASEHP += 10;
			break;
		}
		switch (charaClass) {
		case fighter:
			BASEHP -= 2;
			break;
		case mage:
			BASEHP += 5;
			break;
		case cleric:
			BASEHP += 10;
			break;
		default:
			break;
		}
		currentHP = BASEHP;
	}
    public int loseHP(int attack) {
		int damage;
		if (isDefending == true) {
			damage = attack - def;
		} else {
			damage = attack - (def / 2);
		}
		if (damage < 0)
		{
			damage = 0;
		}
		currentHP -= damage;
		if (currentHP <= 0)
		{
			isDefeated = true;
		}
		return damage;
	}
	public void gainHP(int recover) {
		currentHP += recover;
		if (currentHP > BASEHP)
		{battleReset();}
	}
	public void battleReset() 
	{currentHP = BASEHP;}
	public int getAtk() 
	{return atk;}
    public void setAtk() {
		atk = 10;
		switch (race) {
		case dragon:
			atk += 5;
			break;
		case elf:
			atk += 1;
			break;
		case dwarf:
			atk += 3;
			break;
		case goblin:
			atk -= 3;
			break;
		default:
			break;
		}
		switch (charaClass) {
		case fighter:
			atk += 2;
			break;
		case paladin:
			atk += 5;
			break;
		case cleric:
			atk -= 4;
			break;
		case mage:
			atk -= 3;
			break;
		}
		switch (weapon) {
		case sword:
			atk += 2;
			break;
		case axe:
			atk += 5;
			break;
		case lance:
			atk += 1;
			break;
		default:
			break;
		}
	}
    public int getDef() 
	{return def;}
    public void setDef() {
		def = 10;
		switch (race) {
		case dragon:
			def -= 5;
			break;
		case elf:
			def += 10;
			break;
		case dwarf:
			def += 3;
			break;
		case goblin:
			def += 5;
			;
			break;
		case human:
			def -= 1;
			break;
		case demon:
			def -= 5;
			break;
		}
		switch (charaClass) {
		case fighter:
			def -= 2;
			break;
		case cleric:
			def += 10;
			;
			break;
		case mage:
			def += 5;
			break;
		default:
			break;
		}
	}
	public void defend()
	{
		System.out.println(getName() + " is defending this turn.");
		isDefending = true;
	}
    
	abstract public int chooseAction();
	abstract public int chooseAttack();
	abstract public int chooseItem();
	abstract public void setName();
	abstract public void setRace();
	abstract public void setCharaClass();
	abstract public void setWeapon();
	/*abstract public void setAttacks();
	abstract public void setItems();*/
	
}
