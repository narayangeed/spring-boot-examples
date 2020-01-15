package com.ng.http.request.logger.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/logger")
public class LoggerController {
	
	@GetMapping
	public String hii() {
		return "Hellow from application";
	}
	
	@GetMapping("/hellow")
	public String hellow() {
		return "Hellow from application";
	}

}
