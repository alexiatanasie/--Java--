//section 6 :classes & OOP
import section6.Enemy;
import section6.SuperEnemy;
import section6.Character;
public class Section6 {

	public static void main(String[]args) {
		/*Enemy e1=new Enemy();
		e1.lives=9;
		
		Enemy e2=new Enemy();
		System.out.println(e2.lives);
		
		e2.ReduceHealth(8);
		//System.out.println(e1.health);

		//System.out.println(e2.health);
		
		Enemy e3=new Enemy(7);
		System.out.println(e3.lives);
		
		//e3.SetHealth(90);
		//System.out.println(e3.GetHealth());
		System.out.println(e3.health);
		SuperEnemy se=new SuperEnemy();
		System.out.println(se.health);*/
		
		Enemy e1=new Enemy();
		System.out.println(e1.getHealth());
		
		e1.ReduceHealth(1);
		System.out.println(e1.getHealth());

		
		SuperEnemy se=new SuperEnemy();
		System.out.println(se.getHealth());
		
		se.ReduceHealth(1);
		System.out.println(se.getHealth());
		
		//Character c1=new Character();
		
	}
}
