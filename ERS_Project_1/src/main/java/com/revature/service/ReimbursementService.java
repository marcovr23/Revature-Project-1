package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.dao.ReimbursementDAO;
import com.revature.models.Principal;
import com.revature.models.Reimbursement;

public class ReimbursementService {
	

	private static Logger log = Logger.getLogger(ReimbursementService.class);
	
		private ReimbursementDAO reimbDao = new ReimbursementDAO();
		private Principal principal = new Principal();
		
		public List<Reimbursement> getAllReimbursements() {
			List<Reimbursement> reimbursements = reimbDao.getAll();
			
			return reimbursements;
		}
			
		public Reimbursement addReimbursement(String amount, String submitted, String desc, String author, String type) {
	
			// Verify that there are no empty fields
			if (amount.equals("") 
					|| submitted.equals("") 
					|| desc.equals("")
					|| author.equals("")
					|| type.equals("")) {
				log.info("New user object is missing required fields");
				return null;
			}
			
			int amnt = Integer.parseInt(amount);
			
			Reimbursement newReimbursement = new Reimbursement(amnt, submitted, desc, author, type);
	
			return reimbDao.add(newReimbursement);
		}
		
		public Reimbursement getReimbursementById(int id) {
			Reimbursement reimb = reimbDao.getById(id);
			if (id < 1) return null;
			return reimb;
		
		}
		
		public List<Reimbursement> getReimbByIdAndStatus(String id, String status){			
			return reimbDao.getByStatusAndId(status, id);
		}
		
		public List<Reimbursement> getReimbByStatus(String status){
			return reimbDao.getByStatus(status);
		}
		
		public Reimbursement update()
}
	/*
	Get all Reimb 

	 

	Get Reimb by status 

	 

	Get Reimb by employee id and status 

	 

	Add a new Reimb

	 

	Approve/Deny a Reimb 
*/