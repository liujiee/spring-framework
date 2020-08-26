package com.jie.collection;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class MapA {
	@Autowired
	private Map<String, A> aMap;

	@Override
	public String toString() {
		return "MapA{" +
				"aMap=" + aMap +
				'}';
	}
}
