package com.jie.bean.aop;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AOPTest {

	@Test
	public void testAOP() {
		AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		configApplicationContext.getBean(TestBean.class).test();
	}
}
