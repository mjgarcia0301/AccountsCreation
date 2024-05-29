package com.accounts.app.repositories;

import com.accounts.app.domain.AccountsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends JpaRepository<AccountsDto, Long> {

	
}
