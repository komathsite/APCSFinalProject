import GameUtility.*;

public class Cleric extends Character
{
	public Cleric ()
	{
		int Con = 8 + diceRoll(8);
		int Wis = diceRoll(8);
		initStat("Con", Con);
		initStat("Dice", 8);
		super(Con, 2);	
		initStat("Wis", Wis);
		initStat("Search", 2);
	}
	


	public String type()
	{
		return "Cleric";
	}
	
	public LevelUP()
	{
	}
	
	
}