package com.qa.feedback_forms_accounts.rest;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.qa.feedback_forms_accounts.persistence.domain.Account;

public class AccountRestTest {
	
	private String base_path ="http://localhost:8080/accounts";
	private String getAccounts="/getAccounts";
	private String postAccount= "/createAccount"; 
	private String getAccount = "/getAccountById/";
	private String updateAccount = "/updateAccount/";
	private String deleteAccount= "/deleteAccount/";
	
	
	@Test
    public void verifyStatus200() {
        given().when().get(base_path + getAccounts).then().statusCode(200);
    }
	
	@Test
    public void verifyGetAll() {
		given().when().get(base_path + getAccounts).then().statusCode(200); 
	}
	
	@Test
    public void verifyGetAccount() {
		given()
        .when().get(base_path + getAccount + "1111111111" ).then()
        .body("message",equalTo("Id supplied does not exist. Id: 1111111111"));
	}
	
	@Test
    public void verifyCreateAccount() {
		Account account = new Account((long) 1,false,"fortune","f@qa.com","pwd",false);
		given()
        .contentType("application/json")
        .body(account)
        .when().post(base_path + postAccount ).then()
        .statusCode(200);
	}
	
	
	@Test
    public void verifyUpdateAccount() {
		Account account = new Account((long) 20,true,"updated_UserName","updated@qa.com","updated_pwd",true);
		given()
        .contentType("application/json")
        .body(account)
        .when().put(base_path + updateAccount +"1111111111" ).then()
        .body("message",equalTo("Id supplied does not exist. Id: 1111111111"));
	}


	
	@Test
    public void verifyDeleteAccount() {
		given()
        .when().delete(base_path + deleteAccount + "1111111111" ).then()
        .body("message",equalTo("Id supplied does not exist. Id: 1111111111"));

    }

}
