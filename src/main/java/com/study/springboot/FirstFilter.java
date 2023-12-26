package com.study.springboot;

import java.io.IOException;

import org.springframework.http.HttpMethod;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FirstFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		log.info("firstrilter가 생성되었습니다.");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		log.info("=============first 필터 시작========================");
//		filterChain.doFilter(request,response);
		
		if(req.getMethod().equals(HttpMethod.POST.name())) {
			log.info("포스트요청");
			String headerAuth = req.getHeader("authorization");
			if(headerAuth.equals("token")) {
				log.info("filter 4");
				log.info(headerAuth);
				filterChain.doFilter(req, res);
			}else {
				log.error("인증안됨");
			}
		}
		
		log.info("=============first 필터 끝========================");
		
	}

	@Override
	public void destroy() {
		log.info("firstrilter가 사라집니다..");
	}
	
}
