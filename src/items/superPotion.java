package items;

public class superPotion extends Item 
{

	public String getName() {
		return "Super Potion";
	}
	@Override
	public int use() {
		return 10;
	}
}
