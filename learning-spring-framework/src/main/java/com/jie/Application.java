package com.jie;

import com.jie.config.AppConfig;
import com.jie.dao.Dao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		context.getBean(Dao.class).query();
	}
}
