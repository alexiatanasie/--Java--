package ro.ase.acs.main;

import ro.ase.acs.classes.Car;

public class Main {

	public static void main(String[] args) {

		Car c1=new Car("Tesla",4000);
		System.out.println(c1.getProducer());
		
		Car c2=(Car)c1.clone(); //car explicit
		c1.setPrice(30000);
		c1.setProducer("Dacia");
		System.out.println(c2.getPrice());
		System.out.println(c2.getProducer());
		int[] vector=new int[] {100,200,150};
		c1.setDistances(vector);
		vector[0]=5000;
		
		int[]distances=c1.getDistances();//ca sa afiseze elem cu element
		distances[0]=8000;
		
		for(int x:distances) {
			System.out.println(x);
		}
		String s="something";
		s="smth else";
		System.out.println(s);

	}

}
