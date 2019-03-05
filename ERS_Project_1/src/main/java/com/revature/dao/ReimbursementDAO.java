package com.revature.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.Reimbursement;

public class ReimbursementDAO {

	private static Logger log = Logger.getLogger(ReimbursementDAO.class);

//	public Role
	


	
//	Get all Reimb 
//
//	 
//
//	Get Reimb by status 
//
//	 
//
//	Get Reimb by employee id and status 
//
//	 
//
//	Get Reimb by employee id and date 
//
//	 
//
//	Add a new Reimb 
//
//	 
//
//	Approve/Deny a Reimb 
	
	private List<Reimbursement> mapResultSet(ResultSet rs) throws SQLException {
	List<Reimbursement> reimbursements = new ArrayList<>();
	while(rs.next()) {
		Reimbursement reimbursement = new Reimbursement();
		reimbursement.setReimbId(rs.getInt("reimb_id"));
		reimbursement.setAccount(rs.getInt("reimb_account"));
		reimbursement.setSubmitted(rs.getInt("reimb_submitted"));
		reimbursement.setResolved(rs.getInt("reimb_resolved"));
		reimbursement.setDesc(rs.getString("reimb_description"));
		reimbursement.setAuthor(rs.getInt("reimb_author"));
		reimbursement.setResolver(rs.getInt("reimb_resolver"));
		reimbursement.setStatusId(rs.getInt("reimb_status_id"));
		reimbursement.setTypeId(rs.getInt("reimb_type_id"));
		reimbursements.add(reimbursement);
	}
return reimbursements;
}

}