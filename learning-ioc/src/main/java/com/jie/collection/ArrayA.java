package com.jie.collection;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

public class ArrayA {
	@Autowired
	private A[] arrayA;

	@Override
	public String toString() {
		return "ArrayA{" +
				"arrayA=" + Arrays.toString(arrayA) +
				'}';
	}
}
