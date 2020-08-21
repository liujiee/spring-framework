package com.jie;

import com.jie.config.AppConfig;
import com.jie.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		//context.getBean(TestBean.class).test();

		UserService userService = (UserService) context.getBean("userService");
		userService.add();
	}
}
