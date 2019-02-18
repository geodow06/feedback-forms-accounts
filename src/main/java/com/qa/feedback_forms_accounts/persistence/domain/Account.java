package com.qa.feedback_forms_accounts.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long  accountID;
	private int CohortID;
	private boolean admin;
	private String userName;
	private String email;
	private String password;
	private boolean flagged;
	
	public Account() {
		
	}
	
	public Account(int CohortID,boolean admin,String userName, String email, String password,  boolean flagged) {
		this.CohortID = CohortID;
		this.admin = admin;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.flagged = flagged;
	}

	public Long getAccountID() {
		return accountID;
	}

	public void setAccountID(Long accountID) {
		this.accountID = accountID;
	}

	public int getCohortID() {
		return CohortID;
	}

	public void setCohortID(int cohortID) {
		CohortID = cohortID;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isFlagged() {
		return flagged;
	}

	public void setFlagged(boolean flagged) {
		this.flagged = flagged;
	}
	
}
