package com.ng.http.request.logger.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class RequestAppConfig implements WebMvcConfigurer {
	private static final Logger LOG = LoggerFactory.getLogger(RequestAppConfig.class);

	@Autowired
	private CommonRequestInterceptor commonRequestInterceptor;
	
	@Autowired
	private HellowRequestInterceptor hellowRequestInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		LOG.info("-----------------------Registering interceptor-------------------------");
		//registry.addInterceptor(customRequestInterceptor).addPathPatterns("/**/log-incoming-request/**/");
		//registry.addInterceptor(commonRequestInterceptor);
		registry.addInterceptor(commonRequestInterceptor).addPathPatterns("/**/logger/**/");
		registry.addInterceptor(hellowRequestInterceptor).addPathPatterns("/**/hellow");
		
		registry.addInterceptor(commonRequestInterceptor).addPathPatterns("/**/rest/**/");
		
		LOG.info("-----------------------Interceptor registered-------------------------");
	}
}