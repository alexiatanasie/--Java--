package com.university.traffic.models;

import java.util.Arrays;
import java.util.Set;

public class Car extends Vehicle implements Cloneable{
	private int[] distances;
	public Car(String make, String model, int year, FuelType fuelType) {
		super(make, model, year);
		this.fuelType=fuelType;
	}

	private FuelType fuelType;

	@Override
	public float getFuelEfficiency() {
		switch(fuelType) {
		case PETROL: return 12.5f;
		case DIESEL: return 15;
		case ELECTRIC: return 0;
		default: return 0f;
		}
	}

	public int[] getDistances() {
		if(distances!=null) {
			return Arrays.copyOf(distances, distances.length);
		}else {
			return null;
		}
	}

	public void setDistances(int[] distances) {
		if(distances!=null) {
			this.distances= Arrays.copyOf(distances, distances.length);
		}else {
			this.distances= null;
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		Car copy=(Car)super.clone();
		copy.fuelType=this.fuelType;
		copy.setDistances(distances);
		return copy;
	}

	public FuelType getFuelType() {
		return fuelType;
	}

	public void setFuelType(FuelType fuelType) {
		this.fuelType = fuelType;
	}

	@Override
	public String toString() {
		return make+ " "+model+" "+year+" - "+fuelType;
	}

	@Override
	public int getMaxSpeed() {
		switch(fuelType) {
		case PETROL: return 200;
		case DIESEL:return 180;
		case ELECTRIC: return 250;
		default: return 0;
		}
	}
	
}
