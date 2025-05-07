package com.university.traffic.models;

import com.university.traffic.contracts.Rideable;

public abstract class Vehicle implements Rideable,Cloneable {
	protected String make;
	protected String model;
	protected int year;
	public Vehicle(String make, String model, int year) {
		super();
		this.make = make;
		this.model = model;
		this.year = year;
	}
	@Override
	public int getMaxSpeed() {
		return 100;
	}
	public abstract float getFuelEfficiency();
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Vehicle copy=(Vehicle)super.clone();
		copy.make=this.make;
		copy.model=this.model;
		copy.year=this.year;
		return copy;
	}
	
}
