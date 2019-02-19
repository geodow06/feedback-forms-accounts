package com.qa.feedback_forms_accounts.rest;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

import org.junit.Test;

import com.qa.feedback_forms_accounts.persistence.domain.Account;

public class AccountRestTest {
	
	String base_path ="http://localhost:8080/accounts";
	String getAccounts="/getAccounts";
	String postAccount= "/createAccount"; 
	
	@Test
    public void verifyStatus200() {
        given().when().get(base_path + getAccounts).then().statusCode(200);
    }
	
	@Test
    public void verifyGetAll() {
		given().when().get(base_path + getAccounts).then()
        .body(containsString(""));    
	}
	
	@Test
    public void verifyCreateAccount() {
		Account account = new Account(1,false,"fortune","f@qa.com","pwd",false);
		given()
        .contentType("application/json")
        .body(account)
        .when().post(base_path + postAccount ).then()
        .statusCode(200);
	}
	
	
	

}
