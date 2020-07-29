package com.jie.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Delegator implements InvocationHandler {

	// preloaded Method objects for the methods in java.lang.Object
	private static Method hashCodeMethod;
	private static Method equalsMethod;
	private static Method toStringMethod;

	static {
		try {
			hashCodeMethod = Object.class.getMethod("hashCode", null);
			equalsMethod = Object.class.getMethod("equals", new Class[] { Object.class });
			toStringMethod = Object.class.getMethod("toString", null);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}

	private Class[] interfaces;
	private Object[] delegates;

	public Delegator(Class[] interfaces, Object[] delegates) {
		this.interfaces = interfaces;
		this.delegates = delegates;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		Class declaringClass = method.getDeclaringClass();

		if (declaringClass == Object.class) {
			if (method.equals(hashCodeMethod)) {
				return proxyHashCode(proxy);
			} else if (method.equals(equalsMethod)) {
				return proxyEquals(proxy, args[0]);
			} else if (method.equals(toStringMethod)) {
				return proxyToString(proxy);
			} else {
				throw new InternalError("Unexpected Object method dispatched " + method);
			}
		} else {
			for (int i = 0; i < interfaces.length; i++) {
				return method.invoke(delegates[i], args);
			}

			return invokeNotDelegated(proxy, method, args);
		}

	}

	private Object invokeNotDelegated(Object proxy, Method method, Object[] args) {
		throw new InternalError("unexpected method dispatched: " + method);
	}

	private Object proxyToString(Object proxy) {
		return proxy.getClass().getName() + '@' + Integer.toHexString(proxy.hashCode());
	}

	private Object proxyEquals(Object proxy, Object arg) {
		return proxy == arg ? Boolean.TRUE : Boolean.FALSE;
	}

	private Object proxyHashCode(Object proxy) {
		return new Integer(System.identityHashCode(proxy));
	}
}
