package com.qa.feedback_forms_accounts.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.feedback_forms_accounts.persistence.domain.Account;
import com.qa.feedback_forms_accounts.service.AccountService;

@CrossOrigin
@RequestMapping("${path.base}")
@RestController
public class AccountRest {
	
    @Autowired
    private AccountService service;
	
    @GetMapping("${path.getAccounts}")
    public List<Account> getAccounts() {
        return service.getAccounts();
    }
    
    @GetMapping("/test")
    public String test() {
        return "end points work";
    }



}
