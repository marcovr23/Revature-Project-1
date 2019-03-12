package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.revature.models.Principal;
import com.revature.models.Reimbursement;
import com.revature.service.ReimbursementService;

@WebServlet("/reim/*")
public class ReimbServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(UserServlet.class);
	
	private final ReimbursementService reimbursementService = new ReimbursementService();
	
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
			
			if(requestURI.equals("/ers_project_1/users") || requestURI.equals("/ers_project_1/users/")) {
				// fix this - set to 2(?)

				if (!principal.getRole().equalsIgnoreCase("ADMIN")) {
//				if (!principal.getRole().equals("2")) {

					log.warn("Unauthorized access attempt made from origin: " + req.getLocalAddr());
					resp.setStatus(401);
					return;
				
			} 
			}
			
		} catch (MismatchedInputException mie) {
				log.error(mie.getMessage());
				resp.setStatus(400);
			} catch (Exception e) {
				log.error(e.getMessage());
				resp.setStatus(500);
			}
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		log.info("Request received by ReimbServlet.doPost()");
		Reimbursement newReimbursement = null;
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			newReimbursement = mapper.readValue(req.getInputStream(), Reimbursement.class);
		} catch (MismatchedInputException mie) {
			log.error(mie.getMessage());
			resp.setStatus(400);
			return;
		} catch (Exception e) {
			log.error(e.getMessage());
			resp.setStatus(500);
			return;
		}
		
		newReimbursement = reimbursementService.addReimbursement(newReimbursement);
		
		try {
			String reimbJson = mapper.writeValueAsString(newReimbursement);
			PrintWriter out = resp.getWriter();
			out.write(reimbJson);
		} catch (Exception e) {
			log.error(e.getMessage());
			resp.setStatus(500);
		}
	}
}

// get 
// post
// update
// add reimbursement