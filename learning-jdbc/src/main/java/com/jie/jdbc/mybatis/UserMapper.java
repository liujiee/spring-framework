package com.jie.jdbc.mybatis;

import com.jie.jdbc.entity.User;

public interface UserMapper {

	User select(Integer id);

	void insert(User user);
}
