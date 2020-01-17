package com.ng.crud.db.api.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ng.http.request.logger.configuration.CommonRequestInterceptor;
import com.ng.http.request.logger.configuration.HellowRequestInterceptor;

@Configuration
public class DBAPIConfiguration {
	
	//below interceptor is used to intercept root (/) level request.
	@Bean
	public CommonRequestInterceptor commonRequestInterceptor() {		
		return new CommonRequestInterceptor();		
	}
	//below interceptor is used to intercept api level or request mapping to controller level.
	@Bean
	public HellowRequestInterceptor hellowRequestInterceptor() {
		return new HellowRequestInterceptor();
	}

}
