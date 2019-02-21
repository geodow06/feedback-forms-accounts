package com.qa.feedback_forms_accounts.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Account {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long accountID;
	private Long cohortID;
	private boolean admin;
	@Column(nullable=false)
	@Size(min=1)
	private String firstName;
	@Column(nullable=false)
	@Size(min=1)
	private String lastName;
	@Column(nullable=false, unique=true)
	private String email;
	@Column(nullable=false)
	@Size(min=6, max =18)
	private String password;
	private boolean flagged;
	
	public Account() {
		
	}
	
	public Account(Long cohortID, boolean admin, String firstName, String lastName, String email, String password, boolean flagged) {
		this.cohortID = cohortID;
		this.admin = admin;
		this.firstName = firstName;
		this.lastName = lastName;
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

	public Long getCohortID() {
		return cohortID;
	}

	public void setCohortID(Long cohortID) {
		this.cohortID = cohortID;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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
