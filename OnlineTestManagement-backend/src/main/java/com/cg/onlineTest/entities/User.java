package com.cg.onlineTest.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USER_Table")
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "User_Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userId;
	
	@Column(name = "User_name")
	private String userName;
	
	@Column(name = "IS_Admin")
	private boolean isAdmin;
	
	@Column(name = "Password")
	private String userPassword;
	
	@Column(name = "Email_Id")
	private String emailId;
	
	
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "User_Test",
	 joinColumns = {@JoinColumn (name = "User_id")},
	 inverseJoinColumns = { @JoinColumn (name = "Test_id")}
			)
	private Set<Test> AllTest = new HashSet<>();
	
	
	public User() {
		
	}
	

	public Set<Test> getAllTest() {
		return AllTest;
	}

	public void setAllTest(Test allTest) {
		this.AllTest.add(allTest);
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	
	public void addTest(Test test) {
	  test.setRegisteredUser(this);   
	  this.getAllTest().add(test);
	}
	
	public void removeTest(Test test) {
		test.setRegisteredUser(null);; 
		this.getAllTest().remove(test);
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", isAdmin=" + isAdmin + ", userPassword="
				+ userPassword + ", emailId=" + emailId + ", AllTest=" + AllTest + "]";
	}

	

}
