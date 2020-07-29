package com.jie.proxy.jdk;

public class FooImpl implements Foo {

	@Override
	public Object bar(Object object) {
		//....
		System.out.println("exec bar() in FooImpl");
		return null;
	}
}
