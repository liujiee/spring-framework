package com.jie;

import com.jie.config.AppConfig;
import com.jie.dao.TestImportDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		context.getBean(TestImportDao.class).query();
	}
}
