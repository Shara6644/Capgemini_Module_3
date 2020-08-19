package com.cg.pms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="login_tbl")
public class Login {
	@Id
	@Column(name="user_name",length=15)
	private String userName;
	@Column(name="user_pass",length=15)
	private String userPass;
	@Column(name="user_role",length=15)
	private String user_role;
	public Login(String userName, String userPass, String user_role) {
		super();
		this.userName = userName;
		this.userPass = userPass;
		this.user_role = user_role;
	}
	public Login() {
		super();
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public String getUser_role() {
		return user_role;
	}
	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}

	
}
