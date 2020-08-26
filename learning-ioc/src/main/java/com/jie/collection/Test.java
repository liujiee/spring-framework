package com.jie.collection;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println(context.getBean("listA"));
		System.out.println(context.getBean("mapA"));
	}

	/**
	 *  output
	 *
	 *
	 * ListA{listA=[A{name='a1'}, A{name='a2'}, A{name='a3'}]}
	 * MapA{aMap={a1=A{name='a1'}, a2=A{name='a2'}, a3=A{name='a3'}}}
	 *
	 */
}
