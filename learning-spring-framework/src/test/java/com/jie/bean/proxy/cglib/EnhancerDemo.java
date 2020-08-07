package com.jie.bean.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class EnhancerDemo {
	public static void main(String[] args) {
		Enhancer enhancer = new Enhancer();

		enhancer.setSuperclass(EnhancerDemo.class);
		enhancer.setCallback(new MethodInterceptor() {
			@Override
			public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

				System.out.println("Before invoke " + method);
				Object result = methodProxy.invokeSuper(o, args);
				System.out.println("After invoke " + method);
				return result;
			}
		});

		EnhancerDemo enhancerDemo = (EnhancerDemo) enhancer.create();
		enhancerDemo.test();
		System.out.println(enhancerDemo);
	}

	public void test() {
		System.out.println("EnhancerDemo test()");
	}
}
