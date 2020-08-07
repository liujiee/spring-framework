package com.jie.bean.proxy.jdk;

import org.junit.jupiter.api.Test;

/**
 * 静态代理会产生类爆炸
 */
public class ProxyTest {

	@Test
	public void testProxy() {
		UserService userService = new UserServiceImpl();

		MyInvocationHandler invocationHandler = new MyInvocationHandler(userService);

		UserService proxy = (UserService) invocationHandler.getProxy();

		proxy.add();
	}
}
