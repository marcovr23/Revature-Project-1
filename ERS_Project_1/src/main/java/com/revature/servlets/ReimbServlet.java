package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Principal;
import com.revature.models.Reimbursement;
import com.revature.service.ReimbursementService;

@WebServlet("/reim/*")
public class ReimbServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(UserServlet.class);
	
	private final ReimbursementService reimbService = new ReimbursementService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		Principal principal = (Principal) req.getAttribute("principal");
		
		String requestURI = req.getRequestURI();
		ObjectMapper map = new ObjectMapper();
		
		try {
			PrintWriter out = resp.getWriter();
			
			if(principal == null) {
				log.warn("No principal found on request");
				resp.setStatus(401);
				return;
			}
			
			if(requestURI.equals("/ers_project_1/admin") || requestURI.equals("/ers_project_1/admin/")) {
				// fix this - set to 2(?)

				if (Integer.parseInt(principal.getRole()) != 2 ) {
					log.warn("Unauthorized access attempt made from origin: " + req.getLocalAddr());
					resp.setStatus(401);
					return;
				}
				
				List<Reimbursement> users = reimb.getAllUsers();
				
		}
		
		}
	}
	
	
}

// get 
// post
// update
// add reimbursement