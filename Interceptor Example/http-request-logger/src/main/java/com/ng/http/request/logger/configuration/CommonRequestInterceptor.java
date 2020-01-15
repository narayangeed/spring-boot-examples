package com.ng.http.request.logger.configuration;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class CommonRequestInterceptor extends HandlerInterceptorAdapter {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		
		logger.info("get called : {}",this.getClass().getName());
		logger.info("preHandle executed..");
		
		long startTime = Instant.now().toEpochMilli();
		logger.info("Request URL::" + request.getRequestURL().toString() + ":: Start Time=" + Instant.now());
		request.setAttribute("startTime", startTime);
		
		System.out.println("Query String : "+request.getQueryString());
		
		System.out.println("ContextPath : "+request.getContextPath());
		System.out.println("Header H1 : "+request.getHeader("H1"));
		System.out.println("Remote port : "+request.getRemotePort());
		
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		
		logger.info("afterCompletion executed..");

		long startTime = (Long) request.getAttribute("startTime");		
		

		logger.info("Request URL::" + request.getRequestURL().toString() + ":: Time Taken="
				+ (Instant.now().toEpochMilli() - startTime));
	}
}