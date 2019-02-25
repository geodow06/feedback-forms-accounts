package com.qa.feedback_forms_accounts.service;

import static org.junit.Assert.assertEquals;
import java.util.Optional;
import org.springframework.http.HttpStatus;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.qa.feedback_forms_accounts.persistence.domain.Account;
import com.qa.feedback_forms_accounts.persistence.repository.AccountRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class AccountServiceTest {
	
	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@InjectMocks
	private AccountServiceImpl service;
	
	@Mock
	private AccountRepository repo;
	
	private static final Account MOCK_ACCOUNT_1 = new Account((long) 5, false, "Taylor","White", "TaylorWhite@qa.com","PASS1",false);
	private static final Account MOCK_ACCOUNT_2 = new Account((long) 6, true, "Joseph","Brown", "JosephBrown@qa.com","PASS2",false);
	
	private static final Optional<Account> MOCK_ACCOUNT_OPTIONAL = Optional.of(MOCK_ACCOUNT_1);
	private static final Optional<Account> MOCK_NULL_OPTIONAL = Optional.empty();
	private static final ResponseEntity<Object> MOCK_OK_RESPONSE = new ResponseEntity<Object>(HttpStatus.OK);
	private static final ResponseEntity<Object> MOCK_NOT_FOUND_RESPONSE = new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
	
	@Test
	public void addAccountTest() {
		Mockito.when(repo.save(MOCK_ACCOUNT_1)).thenReturn(MOCK_ACCOUNT_1);
		assertEquals(MOCK_ACCOUNT_1, service.addAccount(MOCK_ACCOUNT_1));
		Mockito.verify(repo).save(MOCK_ACCOUNT_1);
	}
	

}
