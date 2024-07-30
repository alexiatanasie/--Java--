package section6;

public class Enemy implements Character {

	
	private int health=100;
	private int lives=9;
	public Enemy() {
		System.out.println("constructed");
	}
	
	public Enemy(int i) {
		lives=i;
		
	}

	@Override
	public void ReduceHealth(int damage) {

		setHealth(getHealth() - damage);
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	

}
