package com.jie.service;

import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Override
	public void add() {
		System.out.println("add");
	}
}
