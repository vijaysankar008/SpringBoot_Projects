package com.security.homepage.securityconfig;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
	    Boolean isAdmin= authentication.getAuthorities().stream()
	    		.anyMatch(grandedAuthority->grandedAuthority.getAuthority().equals("ROLE_ADMIN"));
	    if(Boolean.TRUE.equals(isAdmin))
	    	setDefaultTargetUrl("/app/admin");
	    else
	    	setDefaultTargetUrl("/app/user");
		
		super.onAuthenticationSuccess(request, response, authentication);
	}
}
