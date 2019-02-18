package com.qa.feedback_forms_accounts.persistence.domain;

public class SentAccount {


	private Long  accountID;
	private int CohortID;
	private boolean admin;
	private String userName;
	private String email;
	private String password;
	private boolean flagged;
	
	public SentAccount() {
		
	}
	
	public SentAccount(Account account) {
		this.CohortID = account.getCohortID();
		this.admin = account.isAdmin();
		this.userName = account.getUserName();
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
