package com.jie.ioc;

import com.jie.ioc.config.AppConfig;
import com.jie.ioc.dao.Dao;
import com.jie.ioc.dao.Dao2;
import com.jie.ioc.dao.DaoImpl2FactoryBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.register(AppConfig.class);

		context.refresh();

		Dao dao = (Dao) context.getBean("daoImpl");

		dao.query();


		Dao2 dao2 = (Dao2) context.getBean("daoImpl2FactoryBean");
		dao2.query();

		DaoImpl2FactoryBean daoImpl2FactoryBean = (DaoImpl2FactoryBean) context.getBean("&daoImpl2FactoryBean");
		daoImpl2FactoryBean.test();
	}
}
