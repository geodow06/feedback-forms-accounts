package com.qa.feedback_forms_accounts.persistence.domain;

public class SentAccount {

	private Long accountID;
	private Long cohortID;
	private boolean admin;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private boolean flagged;
	
	public SentAccount() {
		
	}
	
	public SentAccount(Account account) {
		this.cohortID = account.getCohortID();
		this.admin = account.isAdmin();
		this.firstName = account.getFirstName();
		this.lastName = account.getLastName();
		this.email = account.getEmail();
		this.password = account.getPassword();
		this.flagged = account.isFlagged();
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
