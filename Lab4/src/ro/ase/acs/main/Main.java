package ro.ase.acs.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ro.ase.acs.classes.Car;
import ro.ase.acs.classes.Vehicle;
import ro.ase.acs.interfaces.Taxable;

public class Main {

	public static void main(String[] args) throws CloneNotSupportedException {
		Car car = new Car("Porsche", 90, "blue", 1400);
		System.out.println(car.getName());
		System.out.println(car);

		Taxable t = car;
		double tax = t.computeTax();
		System.out.println(tax);
		Vehicle v = new Car();
		v.move();

		if (car instanceof Cloneable) {
			Car c2 = (Car) car.clone();
			c2.setCapacity(1900);
			System.out.println(car.getCapacity());
		}

		// cast implicit->transformarea din int in Integer se face prin cast implicit
		Integer x = 5;
		int y = x;

		List<Integer> list = new ArrayList<Integer>();
		list.add(4);
		list.add(5);
		list.add(6);

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		//sterg elemente
		list.remove(2);//sterge elem de pe pozitia 2, adica 6
		System.out.println();
		list.add(1,3); //adauga 3 pe poz 1
		
		for(Integer i :list) {
			System.out.println(i);
		}
		list.set(0,9);
		System.out.println();
		for(Iterator<Integer>it=list.iterator();it.hasNext();) {
			System.out.println(it.next());
		}
				
	}
}
