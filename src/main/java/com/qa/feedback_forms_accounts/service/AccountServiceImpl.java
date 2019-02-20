package com.qa.feedback_forms_accounts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.feedback_forms_accounts.persistence.domain.Account;
import com.qa.feedback_forms_accounts.persistence.repository.AccountRepository;
import com.qa.feedback_forms_accounts.util.exceptions.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository repo;

	@Override
	public List<Account> getAccounts() {
		return repo.findAll();
	}
	
	@Override
	public Account addAccount(Account account) {
		if(account.getEmail().endsWith("@qa.com") || account.getEmail().endsWith("@academytrainee.com")) {
			return repo.save(account);
		}
		return null;
	}


	@Override
	public Account getAccount(Long id) {
		Optional<Account> account = repo.findById(id);
		return account.orElseThrow(() -> new AccountNotFoundException(id));
	}

	@Override
	public Account deleteAccount(Long id) {
		Optional<Account> account = repo.findById(id);
		if (accountExists (id)) {
			repo.deleteById(id);
		}
		return account.orElseThrow(() -> new AccountNotFoundException(id));
	}

	@Override
	public Account updateAccount(Account account, Long id) {
		if (accountExists(id)) {
			account.setAccountID(id);
			repo.save(account);
		}
		Optional<Account> accountInDB = repo.findById(id);
		return accountInDB.orElseThrow(() -> new AccountNotFoundException(id));
	}

	private boolean accountExists(Long id) {
		Optional<Account> accountOptional = repo.findById(id);
		return accountOptional.isPresent();
	}
}
