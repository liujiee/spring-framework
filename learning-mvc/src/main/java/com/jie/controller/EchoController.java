package com.jie.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/echo")
public class EchoController {

	@GetMapping
	public String echo(String echo) {
		return echo;
	}

	@GetMapping("/hello")
	public String echo() {
		return "echo";
	}
}
