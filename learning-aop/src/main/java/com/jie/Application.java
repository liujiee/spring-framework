package com.jie;

import com.jie.config.AppConfig;
import com.jie.entity.TestBean;
import com.jie.entity.TestBeanInterface;
import com.jie.proxy.jdk.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		TestBeanInterface testBean = (TestBeanInterface) context.getBean("testBean");
		testBean.test();
		//context.getBean(TestBean.class).test();
	}
}
