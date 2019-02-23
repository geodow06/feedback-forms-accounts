package com.qa.feedback_forms_accounts.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.feedback_forms_accounts.persistence.domain.Account;
import com.qa.feedback_forms_accounts.persistence.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository repo;
	
	@Override
	public Account addAccount(Account account) {
		if(account.getEmail().endsWith("@qa.com") || account.getEmail().endsWith("@academytrainee.com")) {
			return repo.save(account);
		}
		return null;
	}
	
}
