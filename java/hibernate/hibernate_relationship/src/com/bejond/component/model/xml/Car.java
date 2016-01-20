package com.bejond.component.model.xml;

/**
 * Created by bejond on 16-1-20.
 */
public class Car {
	private int carId;
	private String carName;
	private CarLicenese carLicenese;

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public CarLicenese getCarLicenese() {
		return carLicenese;
	}

	public void setCarLicenese(CarLicenese carLicenese) {
		this.carLicenese = carLicenese;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}
}
