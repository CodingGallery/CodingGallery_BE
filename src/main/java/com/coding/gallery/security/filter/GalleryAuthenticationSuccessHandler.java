package com.coding.gallery.security.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.coding.gallery.security.dto.GalleryAuthMemberDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GalleryAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
	
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		log.info("===================================================================");
		log.info("Called GalleryAuthenticationSuccessHandler.onAuthenticationSuccess");
		
		//TODO : 로그인 성공시 실패 카운트 초기화 로직 추가
		
		request.getSession().setAttribute("message", "Success");
		
		
		log.info(request.toString());
		
		//GalleryAuthMemberDTO galleryAuthMemberDTO = (GalleryAuthMemberDTO)authentication.getPrincipal();
		
		//log.info(galleryAuthMemberDTO.toString());
		log.info("=======> " + request.getSession().getAttribute("message"));
		log.info(request.getSession().getAttributeNames().toString());
		
	
		//request.getSession().setAttribute("GalleryMember", authentication.getCredentials());
		//response.sendRedirect("/login");
		//log.info(request.getSession().toString());
		//log.info(authentication.toString());
		//request.getSession().setAttribute("GalleryMember", authentication);
		//String url = "/loginProc";
		//response.sendRedirect(url);
		
		
		log.info("===================================================================");
		
		
	}


}
