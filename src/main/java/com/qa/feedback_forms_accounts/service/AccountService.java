package com.qa.feedback_forms_accounts.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.qa.feedback_forms_accounts.persistence.domain.Account;

public interface AccountService {

    List<Account> getAccounts();

    Account getAccount(Long id);

    Account addAccount(Account account);

    Account deleteAccount(Long id);

    Account updateAccount(Account account, Long id);
}
