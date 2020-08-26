package com.jie.aware;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext configApplicationContext =
				new AnnotationConfigApplicationContext(AppConfig.class);

		ABeanFactoryAware aBeanFactoryAware =
				(ABeanFactoryAware) configApplicationContext.getBean("aBeanFactoryAware");

		aBeanFactoryAware.testAware();
	}
}
