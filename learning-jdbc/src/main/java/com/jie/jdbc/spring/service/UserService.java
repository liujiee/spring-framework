package com.jie.jdbc.spring.service;

import com.jie.jdbc.entity.User;

import java.util.List;

public interface UserService {

	void save(User user);

	public List<User> getUsers();
}
