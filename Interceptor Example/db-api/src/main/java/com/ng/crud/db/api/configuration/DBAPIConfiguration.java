package com.ng.crud.db.api.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ng.http.request.logger.configuration.CommonRequestInterceptor;
import com.ng.http.request.logger.configuration.HellowRequestInterceptor;

@Configuration
public class DBAPIConfiguration {
	
	@Bean
	public CommonRequestInterceptor commonRequestInterceptor() {		
		return new CommonRequestInterceptor();		
	}
	@Bean
	public HellowRequestInterceptor hellowRequestInterceptor() {
		return new HellowRequestInterceptor();
	}

}
