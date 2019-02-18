package com.qa.feedback_forms_accounts.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.qa.feedback_forms_accounts.persistence.domain.Account;

public interface AccountRepository extends  JpaRepository<Account, Long> {

}
