package com.revature.services;

import java.util.List;

import org.apache.log4j.Logger;

import com.revature.dao.UserDAO;
import com.revature.models.User;

public class UserService {

	private static Logger log = Logger.getLogger(UserService.class);

	private UserDAO userDao = new UserDAO();
//	private RoleDAO roleDao = new RoleDAO();
	
	public List<User> getAllUsers() {
		return userDao.getAll();
	}	
	
	public User getByCredentials(String username, String password) {
		
		User user = null;
		
		if (!username.equals("") && !password.equals("")) {
			user = userDao.getByCredentials(username, password);
			// finish this -- there's no verification
			return user; 
		}
		
		log.info("Empty username and/or password");
		return null;
	}
	
	public User getUserById(int userId) {
		return userDao.getById(userId);
	}
	
	public User addUser(User newUser) {
		if (newUser.getUsername().equals("") || 
				newUser.getPassword().equals("") || 
				newUser.getFirstname().equals("") || 
				newUser.getLastname().equals("")) {
			log.info("User missing fields");
			return null;
		}
		return userDao.add(newUser);
	}
}

/*
	- Get all;;
	- getByCredentials;;
	- add;;
	- getById;;
 */