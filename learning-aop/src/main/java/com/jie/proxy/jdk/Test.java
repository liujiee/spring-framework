package com.jie.proxy.jdk;

import com.jie.service.UserService;
import com.jie.service.UserServiceImpl;

public class Test {

	public static void main(String[] args) {
		UserService userService = new UserServiceImpl();
		MyInvocationHandler myInvocationHandler = new MyInvocationHandler(userService);

		UserService proxy = (UserService) myInvocationHandler.getProxy();

		proxy.add();
	}
}
