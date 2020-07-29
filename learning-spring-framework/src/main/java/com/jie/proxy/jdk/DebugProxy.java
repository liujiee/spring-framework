package com.jie.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DebugProxy implements InvocationHandler {

	private Object obj;

	public DebugProxy(Object obj) {
		this.obj = obj;
	}

	public static Object newInstance(Object obj) {
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(),
				obj.getClass().getInterfaces(),
				new DebugProxy(obj));
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("before method " + method.getName());
		Object result;
		try {
			result = method.invoke(obj, args);
		} finally {
			System.out.println("after method " + method.getName());
		}
		return result;
	}
}
