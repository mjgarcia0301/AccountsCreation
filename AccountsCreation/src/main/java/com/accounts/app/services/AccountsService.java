package com.accounts.app.services;

import com.accounts.app.domain.AccountsDto;

public interface AccountsService {

	public AccountsDto createAccounts(AccountsDto accountsDto);
	
	public AccountsDto getAccountsDetails(Long userId);
	
	public AccountsDto updateAccounts(AccountsDto accountsDto);
	
	public void deleteAccounts(Long userId);
}
