package com.jie.dao;

import org.springframework.stereotype.Repository;

@Repository
public class DaoImpl implements Dao {
	@Override
	public void query() {
		System.out.println("query ...");
	}
}
