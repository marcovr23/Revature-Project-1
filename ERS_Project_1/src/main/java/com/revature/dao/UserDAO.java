package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.User;
import com.revature.util.ConnectionFactory;

import oracle.jdbc.internal.OracleTypes;

public class UserDAO {
	private static Logger log = Logger.getLogger(UserDAO.class);
	
	public List<User> getAll() {

		List<User> users = new ArrayList<>();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			CallableStatement cstmt = conn.prepareCall("{CALL get_all_users(?)}");
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			cstmt.execute();

			ResultSet rs = (ResultSet) cstmt.getObject(1);
			users = this.mapResultSet(rs);

		} catch (SQLException e) {
			log.error(e.getMessage());
		}

		return users;
	}
	
//	Get User by Username and Password 
	
	 
	
//	Get User by ID 
	
	 
	
//	Add a new User
	
	private List<User> mapResultSet(ResultSet rs) throws SQLException {
	List<User> users = new ArrayList<>();
	while(rs.next()) {
		User user = new User();
		user.setId(rs.getInt("ers_users_id"));
		user.setUsername(rs.getString("ers_username"));
		user.setPassword(rs.getString("ers_password"));
		user.setFirstname(rs.getString("user_first_name"));
		user.setLastname(rs.getString("user_last_name"));
		user.setEmail(rs.getString("user_email"));
		user.setRoleId(rs.getString("user_role_id"));
		
		users.add(user);
	}
	return users;
	}
	
}
