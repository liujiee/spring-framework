package com.jie.jdbc.transaction.service;

import com.jie.jdbc.entity.User;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED)
public interface UserService {


	public void save(User user) throws Exception;


	public User get(String name) throws Exception;

}
