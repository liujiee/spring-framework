package com.jie.circle.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestB {

	@Autowired
	private TestC testC;

	public TestC getTestC() {
		return testC;
	}

	public void setTestC(TestC testC) {
		this.testC = testC;
	}

	public void b() {
		testC.c();
	}
}
