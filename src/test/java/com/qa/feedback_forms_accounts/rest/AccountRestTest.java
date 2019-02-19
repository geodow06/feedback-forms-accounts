package com.qa.feedback_forms_accounts.rest;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Test;

import com.qa.feedback_forms_accounts.persistence.domain.Account;



public class AccountRestTest {
	
	
	
	
	String base_path ="http://localhost:8080/accounts";
	String getAccounts="/getAccounts";
	String postAccount= "/createAccount"; 
	String getAccount = "/getAccountById/";
	String updateAccount = "/updateAccount/";
	String deleteAccount= "/deleteAccount/";
	
	

	
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
    public void verifyGetAccount() {
		Account account = new Account(99,false,"test","test@qa.com","pwd",false);
		given()
        .contentType("application/json")
        .body(account)
        .when().post(base_path + postAccount ).then()
        .statusCode(200);
		
		given().when().get(base_path + getAccount + "1").then()
        .body("accountID",equalTo(1),
        		"admin",equalTo(false),
        		"userName",equalTo("test"),
        		"email",equalTo("test@qa.com"),
        		"password",equalTo("pwd"),
        		"flagged",equalTo(false),
        		"cohortID",equalTo(99)
        		);
	}
	
	@Test
    public void verifyUpdateAccount() {
		Account account = new Account(20,true,"updated_UserName","updated@qa.com","updated_pwd",true);
		given()
        .contentType("application/json")
        .body(account)
        .when().put(base_path + updateAccount +"1" ).then()
        .statusCode(200);
		
		given().when().get(base_path + getAccount + "1").then()
        .body("accountID",equalTo(1),
        		"admin",equalTo(true),
        		"userName",equalTo("updated_UserName"),
        		"email",equalTo("updated@qa.com"),
        		"password",equalTo("updated_pwd"),
        		"flagged",equalTo(true),
        		"cohortID",equalTo(20)
        		);
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
	
	@Test
    public void verifyDeleteAccount() {
        given().pathParam("accountID", 1)
        .when().delete(base_path + deleteAccount +"{accountID}")
        .then().statusCode(200);

    }
	
	
	

}
