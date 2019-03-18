package com.v6team.amw.springbatch.model;

public class UserData {
	
	private String id;
	private String userName;
	private String role;
	private String orgId;
	private String companyId;
	private String branchId;
	private String zoneId;
	private String userSyskey;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getBranchId() {
		return branchId;
	}
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	public String getZoneId() {
		return zoneId;
	}
	public void setZoneId(String zoneId) {
		this.zoneId = zoneId;
	}
	public String getUserSyskey() {
		return userSyskey;
	}
	public void setUserSyskey(String userSyskey) {
		this.userSyskey = userSyskey;
	}
	
	public UserData() {
		super();
		clearProperties();
	}
	
	private void clearProperties() {
		this.id = "";
		this.userName = "";
		this.orgId = "0";
	}

}
