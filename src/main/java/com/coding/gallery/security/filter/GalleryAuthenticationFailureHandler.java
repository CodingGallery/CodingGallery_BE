package com.coding.gallery.security.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GalleryAuthenticationFailureHandler implements AuthenticationFailureHandler {
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
		log.info("===================================================================");
		log.info("Called GalleryAuthenticationFailureHandler.onAuthenticationFailure");
		log.info("exception.getMessage() : " + exception.getMessage());
		
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		
		// JSON 생성
		response.setContentType("application/json;charset=utf-8");
		//JSONObject json = new JSONObject();
		String message = exception.getMessage();
		//json.put("code", "401");
		//json.put("message", message);
		
		PrintWriter out = response.getWriter();
		
		out.print(message);
		
		
		
		
	}
}
