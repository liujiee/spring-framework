package com.jie.proxy.jdk;

import java.lang.reflect.Proxy;

public class Test {

	public static void main(String[] args) {
		//Foo foo = (Foo) DebugProxy.newInstance(new FooImpl());
		//foo.bar(null);

		Class[] proxyInterfaces = new Class[]{Foo.class};
		Foo foo = (Foo) Proxy.newProxyInstance(Foo.class.getClassLoader(),
				proxyInterfaces, new Delegator(proxyInterfaces, new Object[]{new FooImpl()}));

		foo.bar(null);


	}
}
