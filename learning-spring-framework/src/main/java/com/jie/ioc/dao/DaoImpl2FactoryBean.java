package com.jie.ioc.dao;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class DaoImpl2FactoryBean implements FactoryBean<DaoImpl2> {


	public void test() {
		System.out.println("DaoImpl2FactoryBean test ...");
	}

	@Override
	public DaoImpl2 getObject() throws Exception {
		return new DaoImpl2();
	}

	@Override
	public Class<?> getObjectType() {
		return DaoImpl2.class;
	}
}
