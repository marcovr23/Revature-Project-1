package com.revature.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.revature.dao.ReimbursementDAO;
import com.revature.models.Principal;
import com.revature.models.Reimbursement;
import com.revature.models.User;

public class ReimbursementService {
	
	private static Logger log = Logger.getLogger(ReimbursementService.class);
	
		private ReimbursementDAO reimbDao = new ReimbursementDAO();
		private Principal principal = new Principal();
		
		public List<Reimbursement> getAllReimbursements() {
			List<Reimbursement> reimbursements = reimbDao.getAll();
			
			return reimbursements;
		}
			
		public Reimbursement addReimbursement(Reimbursement newReimb) {
	
//			// Verify that there are no empty fields
//			if (newReimb.getAmount() 
//					|| description.equals("") 
//					|| type.equals("") 
//					|| author.equals("")
//					|| date.equals("")) {
//				log.info("New user object is missing required fields");
//				return null;
//			}
			
			return reimbDao.add(newReimb);
		}
		
		public List<Reimbursement> getReimbursementsById(int id) {
			List<Reimbursement> reimbs = reimbDao.getById(id);
			//if (id < 1) return null;		What is this doing?
			return reimbs;
		
		}
		
		public List<Reimbursement> getReimbursementByStatus(int status){
			List<Reimbursement> reimbs = reimbDao.getByStatus(status);
			return reimbs;
		}
}
	/*
	Get all Reimb 

	 

	Get Reimb by status 

	 

	Get Reimb by employee id and status 

	 

	Add a new Reimb

	 

	Approve/Deny a Reimb 
*/