package com.revature.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.revature.dao.UserDAO;
import com.revature.models.User;

public class UserService {
	
	private static Logger log = Logger.getLogger(UserService.class);
		private UserDAO userDao = new UserDAO();
		
		public List<User> getAllUsers() {
			return userDao.getAll();
		}
		
		public User getUserByCredentials(String username, String password) {
			
			User user = null;
			
			if(!username.equals("") && !password.equals("")) {
				user = userDao.getByCredentials(username, password);
				return user;
		}
		log.info("Empty username and/or password");
		return null;
	}	
}
	/*
	 * 
	 			Example of how to encrypt and decrypt strings
	 			
	 String pass = "Hallo";
	
	String encrypt = AES.encrypt(pass);
	String decrypt = AES.decrypt(encrypt);
	
	System.out.println("original string " + pass + "\n encrpted " + encrypt + "\n decrypted " + decrypt);
	 */
		
	
	


/*
	- add
	- getall
	- getbycreds
	- getbyid
*/