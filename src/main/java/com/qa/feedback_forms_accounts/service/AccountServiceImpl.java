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
public class AccountServiceImpl implements AccountService{

	@Autowired
    private AccountRepository repo;

    @Override
    public List<Account> getAccounts() {
        return repo.findAll();
    }

    @Override
    public Account getAccount(Long id) {
        Optional<Account> account = repo.findById(id);
        return account.orElseThrow(() -> new AccountNotFoundException(id));
    }

    @Override
    public Account addAccount(Account account) {
        return repo.save(account);
    }

    @Override
    public ResponseEntity<Object> deleteAccount(Long id) {
        if(accountExists(id)){
            repo.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<Object> updateAccount(Account account, Long id) {
        if(accountExists(id)){
            account.setAccountID(id);
            repo.save(account);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }


    private boolean accountExists(Long id){
        Optional<Account> accountOptional = repo.findById(id);
        return accountOptional.isPresent();
    }
}
