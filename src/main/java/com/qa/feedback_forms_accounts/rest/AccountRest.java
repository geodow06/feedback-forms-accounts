package com.qa.feedback_forms_accounts.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
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
    
    @Value("${trainer.email}")
    private String trainerEmail;
    
    @Value("${trainee.email}")
    private String traineeEmail;
     
    @PostMapping("${path.createAccount}")
    public Account createAccount(@RequestBody Account account) {    	
		if(account.getEmail().endsWith(trainerEmail) || account.getEmail().endsWith(traineeEmail)) {
			account.setAdmin(account.getEmail().endsWith(trainerEmail) ? true : false);			
	    	SentAccount accountToSend = new SentAccount(account);
			sendToQueue(accountToSend);
		}
    	return service.addAccount(account);
    }
    
    private void sendToQueue(SentAccount sentAccount){
        jmsTemplate.convertAndSend("AccountQueue", sentAccount);
    }
    
}
