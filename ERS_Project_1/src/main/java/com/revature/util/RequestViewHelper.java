package com.revature.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.revature.models.Principal;

public class RequestViewHelper {
	
	private static Logger log = Logger.getLogger(RequestViewHelper.class);
	
	private RequestViewHelper() {
		super();
	}
	
	public static String process(HttpServletRequest request) {
		
		switch(request.getRequestURI()) {
		
		case "/ers_project_1/login.view":
			log.info("Fetching login.html");
			return "partials/login.html";
		
		case "/ers_project_1/register.view":
			log.info("Fetching register.html");
			return "partials/register.html";
		
		case "/ers_project_1/dashboard.view":
			
			Principal principal = (Principal) request.getAttribute("principal");
			
			if(principal == null) {
				log.warn("No principal attribute found on request object");
				return null;
			}
			
			log.info("Fetching dashboard.html");
			return "partials/dashboard.html";
		
		default: 
			log.info("Invalid view requested");
			return null;
		
		}
	}

}
