package attacks;

public class lanceStab extends Attack
{public int use(int roll, int atk) {
		int damage = 0;
		int adjustedAtk;
		if (atk <10)
		{
			adjustedAtk = atk * 2;
			if(adjustedAtk < 10)
			{
				adjustedAtk = atk * 3;
			}
		}
		else if(atk >30)
		{
			adjustedAtk = atk/2;
		}
		else
			{adjustedAtk = atk;}
		switch (roll)
		{
		case 1: case 2: case 3: case 4:
			damage = 1 + adjustedAtk; break;
		case 5: case 6: case 7: case 8:
			damage = 2 + adjustedAtk; break;
		case 9: case 10: case 11: case 12:
			damage = 3 + adjustedAtk; break;
		case 13: case 14: case 15: case 16:
			damage = 4 + adjustedAtk; break;
		case 17: case 18: case 19: case 20:
			damage = 5 + adjustedAtk; break;
		}
		return damage;
	}

@Override
public String getName() {
	// TODO Auto-generated method stub
	return "Lance Stab";
}}


