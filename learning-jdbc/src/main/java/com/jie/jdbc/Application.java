package com.jie.jdbc;

import com.jie.jdbc.config.AppConfig;
import com.jie.jdbc.entity.User;
import com.jie.jdbc.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

	public static void main(String[] args) throws Exception {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		context.getBean(UserService.class).save(new User("lisi", 13, "female"));
	}
}
