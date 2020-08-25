package com.jie.circle;

import com.jie.circle.config.AppConfig;
import com.jie.circle.entity.TestA;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 分类：
 * 1. 构造器循环注入[无中间状态]： 无法解决，只能抛出 BeanCurrentCreationException
 * 2. setter 循环依赖， 只能解决单例 bean 的循环依赖，通过提前暴露一个单例工厂的方法提供了一个中间状态
 * 3. prototype 范围的依赖处理， Spring 中不存在 prototype 作用域的 bean，自然无法提供一个中间状态供其他 bean 访问
 *
 *
 * 对于 singleton 作用域的 bean， 可以通过 setAllowCircularReferences(false) 來禁用循环引用
 */

public class CircleTest {

	public static void main(String[] args) {
/*		AnnotationConfigApplicationContext configApplicationContext =
				new AnnotationConfigApplicationContext(AppConfig.class);

		*//**
		 * 错过了设置 setAllowCircularReferences(false) 时机，
		 * 当执行的这行代码的时候，spring 已经完成了 singleton bean 的初始化
		 *//*
		 configApplicationContext.setAllowCircularReferences(false); // 错过了s时机*/

		AnnotationConfigApplicationContext configApplicationContext =
				new AnnotationConfigApplicationContext();
		//configApplicationContext.setAllowCircularReferences(false);
		configApplicationContext.register(AppConfig.class);
		configApplicationContext.refresh();
		System.out.println(configApplicationContext.getBean(TestA.class));
	}
}
