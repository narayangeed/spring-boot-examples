package com.ng.servlet.filter.requestlog.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

@Component
public class HttpRequestFilter implements Filter {

	private static final Logger LOG = LoggerFactory.getLogger(HttpRequestFilter.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		LOG.info("MDC Filter start processing ..");

		HttpServletRequest httpServReq = (HttpServletRequest) request;
		MDC.put("ID", httpServReq.getHeader("ID"));

		LOG.info("CharacterEncoding : {}", httpServReq.getCharacterEncoding());
		LOG.info("ContentType : {}", httpServReq.getContentType());
		LOG.info("ContextPath : {}", httpServReq.getContextPath());
		LOG.info("ServletPath : {}", httpServReq.getServletPath());
		LOG.info("ServletContext : {}", httpServReq.getServletContext());
		LOG.info("HttpServletMapping : {}", httpServReq.getHttpServletMapping());
		LOG.info("ID : {}", httpServReq.getHeader("ID"));

		LOG.info("MDC Filter processing END ..");

		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
