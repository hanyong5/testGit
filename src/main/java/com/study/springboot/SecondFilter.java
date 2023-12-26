package com.study.springboot;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SecondFilter implements Filter {@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		log.info("두번째필터가 생성되었습니다.");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		log.info("****두번째 필터시작 *****");
		chain.doFilter(request, response);
		log.info("****두번째 필터시작 *****");
		
	}

	@Override
	public void destroy() {
		log.info("두번째필터가 사라집니다..");
	}
	
	
}
