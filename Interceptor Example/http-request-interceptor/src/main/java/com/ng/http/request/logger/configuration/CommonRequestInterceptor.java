package com.ng.http.request.logger.configuration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class CommonRequestInterceptor implements HandlerInterceptor {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		
		logger.info("get called : {}",this.getClass().getName());		
		logger.info("Query String : {}",request.getQueryString());		
		logger.info("ContextPath : {}",request.getContextPath());
		logger.info("Header H1 : {}",request.getHeader("H1"));
		logger.info("Remote port : {}",request.getRemotePort());
		logger.info("preHandle executed..");	
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		logger.info(" PostHandle executed..");	
		
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		
		logger.info("afterCompletion executed..");	
	}
}