package com.jie.collection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	public A a1() {
		return new A("a1");
	}

	@Bean
	public A a2() {
		return new A("a2");
	}

	@Bean
	public A a3() {
		return new A("a3");
	}

	@Bean
	public ListA listA() {
		return new ListA();
	}

	@Bean
	public MapA mapA() {
		return new MapA();
	}
}
