package com.revature.models;

public class Reimbursement {

	private int reimbId;
	private int account;
	private int submitted;
	private int resolved; 
	private String desc;
	private int author;
	private int resolver;
	private int statusId;
	private int typeId;
	public int getReimbId() {
		return reimbId;
	}
	public void setReimbId(int reimbId) {
		this.reimbId = reimbId;
	}
	public int getAccount() {
		return account;
	}
	public void setAccount(int account) {
		this.account = account;
	}
	public int getSubmitted() {
		return submitted;
	}
	public void setSubmitted(int submitted) {
		this.submitted = submitted;
	}
	public int getResolved() {
		return resolved;
	}
	public void setResolved(int resolved) {
		this.resolved = resolved;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getAuthor() {
		return author;
	}
	public void setAuthor(int author) {
		this.author = author;
	}
	public int getResolver() {
		return resolver;
	}
	public void setResolver(int resolver) {
		this.resolver = resolver;
	}
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + account;
		result = prime * result + author;
		result = prime * result + ((desc == null) ? 0 : desc.hashCode());
		result = prime * result + reimbId;
		result = prime * result + resolved;
		result = prime * result + resolver;
		result = prime * result + statusId;
		result = prime * result + submitted;
		result = prime * result + typeId;
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
		Reimbursement other = (Reimbursement) obj;
		if (account != other.account)
			return false;
		if (author != other.author)
			return false;
		if (desc == null) {
			if (other.desc != null)
				return false;
		} else if (!desc.equals(other.desc))
			return false;
		if (reimbId != other.reimbId)
			return false;
		if (resolved != other.resolved)
			return false;
		if (resolver != other.resolver)
			return false;
		if (statusId != other.statusId)
			return false;
		if (submitted != other.submitted)
			return false;
		if (typeId != other.typeId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Reimbursement [reimbId=" + reimbId + ", account=" + account + ", submitted=" + submitted + ", resolved="
				+ resolved + ", desc=" + desc + ", author=" + author + ", resolver=" + resolver + ", statusId="
				+ statusId + ", typeId=" + typeId + "]";
	}
	public Reimbursement(int reimbId, int account, int submitted, int resolved, String desc, int author, int resolver,
			int statusId, int typeId) {
		super();
		this.reimbId = reimbId;
		this.account = account;
		this.submitted = submitted;
		this.resolved = resolved;
		this.desc = desc;
		this.author = author;
		this.resolver = resolver;
		this.statusId = statusId;
		this.typeId = typeId;
	}
	public Reimbursement() {
		super();
	}
	
	
}
