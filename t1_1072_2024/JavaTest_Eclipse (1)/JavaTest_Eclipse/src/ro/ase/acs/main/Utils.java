package ro.ase.acs.main;

import java.util.List;
import java.util.stream.Stream;

import com.university.traffic.models.Car;
import com.university.traffic.models.FuelType;

public class Utils {
	public int value;
	public int cube;
	
	public Runnable lambdaExpression=()->{
		cube=value*value*value;
	};
public static Stream<Car>getNewElectricCars(List<Car>cars){
	return cars.stream().distinct().filter(c->c.getFuelType()==FuelType.ELECTRIC).filter(d->d.getYear()>=2023);
	
}
}
