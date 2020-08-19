package com.jie;

import com.jie.config.AppConfig;
import com.jie.entity.TestBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		context.getBean(TestBean.class).test();
	}
}
