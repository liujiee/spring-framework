package com.jie.jdbc.spring2mybatis;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestSpring2Mybatis {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println(configApplicationContext.getBean(UserMapper.class).select(1));
	}
}
