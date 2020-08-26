package com.jie.aware;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	public Hello hello() {
		return new Hello();
	}

	@Bean
	public ABeanFactoryAware aBeanFactoryAware() {
		return new ABeanFactoryAware();
	}
}
