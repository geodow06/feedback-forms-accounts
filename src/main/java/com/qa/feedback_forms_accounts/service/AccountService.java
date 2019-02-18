package com.qa.feedback_forms_accounts.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.qa.feedback_forms_accounts.persistence.domain.Account;

public interface AccountService {

    List<Account> getAccounts();

    Account getAccount(Long id);

    Account addAccount(Account account);

    ResponseEntity<Object> deleteAccount(Long id);

    ResponseEntity<Object> updateAccount(Account account, Long id);
}
