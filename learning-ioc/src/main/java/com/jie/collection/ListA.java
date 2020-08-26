package com.jie.collection;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

public class ListA {

	@Autowired
	private List<A> aList;

	@Override
	public String toString() {
		return "ListA{" +
				"listA=" + Arrays.toString(aList.toArray()) +
				'}';
	}
}
