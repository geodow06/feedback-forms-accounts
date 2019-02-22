package com.qa.feedback_forms_accounts.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.feedback_forms_accounts.persistence.domain.Account;
import com.qa.feedback_forms_accounts.persistence.domain.SentAccount;
import com.qa.feedback_forms_accounts.service.AccountService;

@CrossOrigin
@RequestMapping("${path.base}")
@RestController
public class AccountRest {
	
    @Autowired
    private AccountService service;
    
    @Autowired
    private JmsTemplate jmsTemplate;
	
    @GetMapping("${path.getAccounts}")
    public List<Account> getAccounts() {
        return service.getAccounts();
    }
     
    @PostMapping("${path.createAccount}")
    public Account createAccount(@RequestBody Account account) {
    	SentAccount accountToSend = new SentAccount(account);
    	sendToQueue(accountToSend);
        
        
    	return service.addAccount(account);
    }
    
    @GetMapping("${path.getAccountById}")
    public Account getAccount(@PathVariable Long id) {
        return service.getAccount(id);
    }

    @DeleteMapping("${path.deleteAccount}")
    public Account deleteAccount(@PathVariable Long id) {
        return service.deleteAccount(id);
    }

    @PutMapping("${path.updateAccount}")
    public Account updateAccount(@RequestBody Account account, @PathVariable Long id) {
        return service.updateAccount(account, id);
    }
    
    
    private void sendToQueue(SentAccount sentAccount){
        jmsTemplate.convertAndSend("AccountQueue", sentAccount);
    }
    
    



}
