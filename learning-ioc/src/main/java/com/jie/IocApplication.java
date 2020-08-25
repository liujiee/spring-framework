package com.jie;

import com.jie.config.AppConfig;
import com.jie.factory.Car;
import com.jie.factory.CarFactoryBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IocApplication {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext configApplicationContext =
				new AnnotationConfigApplicationContext(AppConfig.class);

//		UserService userService = (UserService) configApplicationContext.getBean("userService");
//
//		userService.query();


		// test FactoryBean
		Car car = (Car) configApplicationContext.getBean("car");
		System.out.println(car);

		CarFactoryBean carFactoryBean = (CarFactoryBean) configApplicationContext.getBean("&car");
		System.out.println(carFactoryBean);

	}
}
