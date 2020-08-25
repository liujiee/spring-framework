package com.jie.config;


import com.jie.factory.CarFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.jie")
public class AppConfig {


	@Bean
	public CarFactoryBean car() {
		CarFactoryBean carFactoryBean = new CarFactoryBean();
		carFactoryBean.setCarInfo("超级跑车,400,20000000");
		return carFactoryBean;
	}
}
