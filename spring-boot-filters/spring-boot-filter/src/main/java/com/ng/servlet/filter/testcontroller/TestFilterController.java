package com.ng.servlet.filter.testcontroller;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestFilterController {
	
	@GetMapping
	public String ping() {
		return "Hii : "+ new Date();
	}
	

}
