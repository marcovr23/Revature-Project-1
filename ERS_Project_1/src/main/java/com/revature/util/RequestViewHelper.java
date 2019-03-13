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
		
		switch(request.getRequestURI()) {
		
		case "/ERS_Project_1/employee.view":
			return "partials/employee.html";

		case "/ERS_Project_1/admin.view":
				return "partials/admin.html";
				
		case "/ERS_Project_1/reimbursement.view":
			return "partials/admin.html";
			
		default: 
			log.info("Invalid view requested");
			return null;
		}
	}
}
