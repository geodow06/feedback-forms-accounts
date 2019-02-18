package com.qa.feedback_forms_accounts.util.exceptions;

public class AccountNotFoundException extends RuntimeException{

    public AccountNotFoundException(Long exception){
        super("Id supplied does not exist. Id: " + exception);
    }

}
