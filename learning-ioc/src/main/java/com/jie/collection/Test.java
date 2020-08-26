package com.jie.collection;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	/**
	 * 本 package 主要测试
	 *
	 * org.springframework.beans.factory.support.
	 * 	DefaultListableBeanFactory#findAutowireCandidates
	 * 		(java.lang.String,
	 * 		java.lang.Class,
	 * 		org.springframework.beans.factory.config.DependencyDescriptor)
	 * @param args
	 */
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println(context.getBean("listA"));
		System.out.println(context.getBean("mapA"));
		System.out.println(context.getBean("arrayA"));
	}

	/**
	 *  output
	 *
	 *
	 * ListA{listA=[A{name='a1'}, A{name='a2'}, A{name='a3'}]}
	 * MapA{aMap={a1=A{name='a1'}, a2=A{name='a2'}, a3=A{name='a3'}}}
	 * ArrayA{arrayA=[A{name='a1'}, A{name='a2'}, A{name='a3'}]}
	 *
	 */
}
