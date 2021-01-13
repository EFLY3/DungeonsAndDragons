package items;

public class hyperPotion extends Item
{
	@Override
	public String getName() {
		return "Hyper Potion";
	}
	@Override
	public int use() {
		return 15;
	}
}
