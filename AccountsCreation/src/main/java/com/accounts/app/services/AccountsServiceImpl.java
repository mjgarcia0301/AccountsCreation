package com.accounts.app.services;

import java.util.Optional;

import com.accounts.app.domain.AccountsDto;
import com.accounts.app.exceptions.AccountsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accounts.app.repositories.AccountsRepository;

@Service
public class AccountsServiceImpl implements AccountsService {
	
	@Autowired
	private AccountsRepository accountsRepository;

	@Override
	public AccountsDto createAccounts(AccountsDto accountsDto) {
		AccountsDto user= accountsRepository.save(accountsDto);
		if(user.getCustomerEmail().isEmpty()){
			throw new AccountsException("Email is required field");
		}
		return user;
	}

	@Override
	public AccountsDto getAccountsDetails(Long userId) {
		Optional<AccountsDto> userDetails= accountsRepository.findById(userId);
		
		if(!userDetails.isPresent()) {
			throw new AccountsException("No Record Found");
		}
		return userDetails.get();
	}

	@Override
	public AccountsDto updateAccounts(AccountsDto accountsDto) {
		try {
		AccountsDto userObj= accountsRepository.findById(accountsDto.getId()).get();
		
		if(null==userObj) {
			throw new AccountsException("No Record Found");
		}
		//accountsDto.setCreatedOn(userObj.getCreatedOn());
		return accountsRepository.save(accountsDto);
		}
		catch(Exception e) {
			throw new AccountsException("Error While Updating Record");
		}
	}

	@Override
	public void deleteAccounts(Long userId) {
		try {
			AccountsDto userObj= accountsRepository.findById(userId).get();
			
			if(null==userObj) {
				throw new AccountsException("No Record Found");
			}
			
			accountsRepository.delete(userObj);
		}
		catch(Exception e) {
			throw new AccountsException("Unable to delete Record");
		}
	}

}
