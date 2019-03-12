package com.revature.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RequestViewHelper {
	
	private static Logger log = Logger.getLogger(RequestViewHelper.class);
	
	private RequestViewHelper() {
		super();
	}
	
	public static String process(HttpServletRequest request) {
		
		
		log.info("Inside Request View Helper Current Request URI is " + request.getRequestURI());
		
		switch(request.getRequestURI().toLowerCase()) {
		
		
		case "/ers_project_1/employee.view":
			
//			String principal = (String) request.getAttribute("Auth");
//			
//			ObjectMapper mapper = new ObjectMapper();
//			mapper.readva
//			
//			log.info("Principal as a string is "+ principal);
//			
//			if(principal == null) {
//				log.warn("No principal attribute found on request object");
//				return null;
//			}
//			
//			if(principal.getRole().equalsIgnoreCase("user")) {
				log.info("principal role is user");
				return "partials/employee.html";
			//}
		case "/ers_project_1/admin.view":
			
//			if(principal.getRole().equalsIgnoreCase("admin")) {
				log.info("principal role is admin");
				return "partials/admin.html";
			//}
			
		default: 
			log.info("Invalid view requested");
			return null;
		
		}
	}

}
