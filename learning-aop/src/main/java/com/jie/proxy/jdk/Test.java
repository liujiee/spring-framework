package com.jie.proxy.jdk;

public class Test {

	public static void main(String[] args) {
		UserService userService = new UserServiceImpl();
		MyInvocationHandler myInvocationHandler = new MyInvocationHandler(userService);

		UserService proxy = (UserService) myInvocationHandler.getProxy();

		proxy.add();
	}
}
