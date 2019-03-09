package com.revature.models;

public class Principal {
	
	private String id;
	private String role;
	private String username;
	
	public Principal() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Principal(String id, String role, String username) {
		super();
		this.id = id;
		this.role = role;
		this.username = username;
	}

	@Override
	public String toString() {
		return "Principal [id=" + id + ", role=" + role + ", username=" + username + "]";
	}
}