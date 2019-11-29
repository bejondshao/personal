package org.bejond.wholetest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPI {

	@Test
	public void testFindObject() {
		List<Car> cars = new ArrayList<>();
		cars.add(new Car("benz", 1000));
		cars.add(new Car("audi", 800));
		cars.add(new Car("tesla", 700));

		// When I need to find a value in a Collection-based class, I can leverage the stream functionality
		Car audi = cars.stream().filter(car -> "audi".equals(car.getName())).findAny().orElse(null);
		System.out.println(audi);

		// If I need to create a new List from a property in another List, I can leverage the stream functionality
		List<String> carNames = cars.stream().map(Car::getName).collect(Collectors.toList());
		for(String name : carNames) {
			System.out.println(name);
		}

		// If I want to loop through the values of a List and do some work, I can also use the stream functionality
		List<Car> newCars = new ArrayList<>();

			cars.stream().filter(car -> car.getPrice() > 750).findAny().ifPresent(newCars::add);

		for(Car car : newCars) {
			System.out.println(car);
		}
	}

}
