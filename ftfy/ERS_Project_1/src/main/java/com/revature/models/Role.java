package com.revature.models;

public class Role {
	
	private int roleId;
	private String roleName;
	
	public Role() {
		super();
	}
	
	public Role(int roleId) {
		this.roleId = roleId;
		
		switch(roleId) {
		case 1:
			this.roleName = "USER"; break;
		case 2:
			this.roleName = "ADMIN"; break;
		default:
			this.roleName = "LOCKED";
		}
	}
	
	public Role(String roleName) {
		super();
		this.roleName = roleName;
		
		switch(roleName) {
		case "USER":
			this.roleId = 1; break;
		case "ADMIN":
			this.roleId = 2; break;
		case "LOCKED":
			this.roleId = 3; break;
		default:
			this.roleId = 3;
		}
	}
	
	public Role(int roleId, String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + roleId;
		result = prime * result + ((roleName == null) ? 0 : roleName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		if (roleId != other.roleId)
			return false;
		if (roleName == null) {
			if (other.roleName != null)
				return false;
		} else if (!roleName.equals(other.roleName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Roles [roleId=" + roleId + ", roleName=" + roleName + "]";
	}

}