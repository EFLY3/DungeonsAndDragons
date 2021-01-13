package items;

public class potion extends Item
{
	public String getName() {
		return "Potion";
	}
	@Override
	public int use() {
		return 5;
	}
}
