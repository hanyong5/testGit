package com.study.springboot;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MyController {

	@PostMapping("/token")
	public String postToken() {
		return "<h1>hello</h1>";
	}
}
