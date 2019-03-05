package com.metacube.training.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class Admin {
	
	@Id
	@Column(name = "id")
	@GeneratedValue
	int id;
	
	@Column(name = "user_name")
	String userName;
	
	@Column(name = "user_password")
	String userPassword;
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getUsername() {
		String user_name=userName;
		return user_name;
	}
	
	public void setUsername(String userName) {
		this.userName = userName;
	}
	
	
	public String getPassword() {
		return userPassword;
	}
	
	public void setPassword(String password) {
		this.userPassword = password;
	}
	
	

}
