package com.jie.advisor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectJTest {

	/**
	 * 写法不用死记， 从 spring framework 官方文档中找到合适的直接用即可
	 * https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html#aop-pointcuts-examples
	 */
	@Pointcut("execution(* test(..))")
	public void test() {
	}


	@Before("test()")
	public void beforeTest() {
		System.out.println("beforeTest");
	}

	@After("test()")
	public void afterTest() {
		System.out.println("afterTest");
	}

	@Around("test()")
	public Object aroundTest(ProceedingJoinPoint p) {
		System.out.println("beforeTest1");
		Object o = null;

		try {
			o = p.proceed();
		} catch (Throwable throwable) {
			throwable.printStackTrace();
		}

		System.out.println("afterTest1");

		return o;
	}

}
