//Haseeb Saadut

public class Player extends GameSystem
{
	public int healthPoints = 200;
	public int manaPoints = 100;
	public int attackPoints = 10;
	public int defensePoints = 10;
	public int speed = 10;
	public String playerName;
	
	public Player() 
	{
		super();
		this.healthPoints = healthPoints;
		this.manaPoints = manaPoints;
		this.attackPoints = attackPoints;
		this.defensePoints = defensePoints;
		this.speed = speed;
		this.playerName = playerName;
	}
	
	public int getHealthPoints() {
		return healthPoints;
	}
	public void setHealthPoints(int healthPoints) 
	{
		this.healthPoints = healthPoints;
		if (healthPoints == 0)
		{
			System.out.println("Game over");
			System.exit(1);
		}
	}
	public int getManaPoints() {
		return manaPoints;
	}
	public void setManaPoints(int manaPoints) 
	{
		this.manaPoints = manaPoints;
	}
	public int getAttackPoints() {
		return attackPoints;
	}
	public void setAttackPoints(int attackPoints) {
		this.attackPoints = attackPoints;
	}
	public int getDefensePoints() {
		return defensePoints;
	}
	public void setDefensePoints(int defensePoints) {
		this.defensePoints = defensePoints;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public String getPlayername() {
		return playerName;
	}
	public void setPlayername(String playerName) {
		this.playerName = playerName;
	}
	
	public void weapon(int w)
	{
		if(item.weapon.isEquipped) 
		{
			attackPoints = (int)(attackPoints * (w + Math.random()));
			speed = (int)(speed * (w + Math.random()));
		}
		else 
		{
			return;
		}
	}

	public int armor1(int a) 
	{
		if(item.armor1.isEquipped) 
		{
			healthPoints = (int)(healthPoints * (a + Math.random()));
			defensePoints = (int)(defensePoints * (a + Math.random()));

			if(healthPoints < 0) 
			{
				healthPoints = 0;
			}
			return healthPoints;
		}
		else 
		{
			return -1;
		}
	}


	public int armor2(int b) 
	{
		if(item.armor2.isEquipped) 
		{
			healthPoints = (int)(healthPoints * (b + Math.random()));
			defensePoints = (int)(defensePoints * (b + Math.random()));

			if(healthPoints < 0) 
			{
				healthPoints = 0;
			}
			return healthPoints;
		}
		else 
		{
			return -1;
		}
	}	

	public void getItem(Item i)
	{
		Inventory.addElement(i);
	}

	public void useItem()
	{
		//will do
	}

	public void searchRoom()
	{
		System.out.println(roomDescription);
	}
	
	public void equipItem(Item i)
	{
		
	}
}
