package com.jie.service;

import com.jie.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

	private UserDao userDao;

	@Autowired
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void query() {
		userDao.queryUser();
		System.out.println("UserService query after userDao query");
	}
}
