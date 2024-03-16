package ro.ase.acs.classes;

import ro.ase.acs.interfaces.Taxable;

//cls Car sa deriveze interfata Taxable
public final class Car  extends Vehicle implements Taxable{
	private String color;
	private int capacity;
	public Car() {
		super();
		color="white";
		capacity=49;
	}
	public Car(String name, int speed, String color,int capacity) {
		super(name,speed);
		this.color = color;
		this.capacity = capacity;
	}

	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	@Override
	public double computeTax() {
		float tax=0;
		
		if(capacity<2000) {
			tax=(float) capacity/1000*50;
		}
		else {
			tax= (float)capacity/1000*100;
			
		}
		return tax <MIN_TAX ? MIN_TAX:tax;
	}

	@Override
	public void move() {
		System.out.println("the car is moving");
		
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		Car copy=(Car)super.clone();
		copy.color=color;
		copy.capacity=capacity;
		return copy;
		
		
	}

	
}
