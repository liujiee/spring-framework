package com.jie.ioc.dao;

import org.springframework.stereotype.Repository;

@Repository
public class DaoImpl implements Dao {
	@Override
	public void query() {
		System.out.println("query ...");
	}
}
