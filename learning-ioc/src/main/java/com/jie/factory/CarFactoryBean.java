package com.jie.factory;

import org.springframework.beans.factory.FactoryBean;

public class CarFactoryBean implements FactoryBean<Car> {

	private String carInfo;

	@Override
	public Car getObject() throws Exception {
		Car car = new Car();
		String[] info = carInfo.split(",");
		car.setBrand(info[0]);
		car.setMaxSpeed(Integer.parseInt(info[1]));
		car.setPrice(Double.parseDouble(info[2]));
		return car;
	}

	@Override
	public Class<Car> getObjectType() {
		return Car.class;
	}

	public String getCarInfo() {
		return carInfo;
	}

	public void setCarInfo(String carInfo) {
		this.carInfo = carInfo;
	}
}
