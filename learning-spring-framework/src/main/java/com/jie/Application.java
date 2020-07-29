package com.jie;

import com.jie.config.AppConfig;
import com.jie.imports.registrar.RegistrarService;
import com.jie.imports.selector.TestImportDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		AppConfig appConfig = context.getBean(AppConfig.class);
		context.getBean(TestImportDao.class).query();
		context.getBean(RegistrarService.class).test();
	}
}
