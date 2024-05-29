package com.accounts.app.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import com.accounts.app.domain.AccountsDto;
import com.accounts.app.exceptions.AccountsException;
import com.accounts.app.services.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class AccountsController {

	@Autowired
	private AccountsService accountsService;

	@PostMapping
	public ResponseEntity<?> createUser(@Valid @RequestBody AccountsDto accountsDto) {

		AccountsDto userDetails = accountsService.createAccounts(accountsDto);
		return new ResponseEntity<>(userDetails, HttpStatus.CREATED);

	}

	@GetMapping("/{userId}")
	public ResponseEntity<?> getUser(@PathVariable(required = true) Long userId) {

		AccountsDto userDetails = accountsService.getAccountsDetails(userId);

		return new ResponseEntity<>(userDetails, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<?> updateUser(@Valid @RequestBody AccountsDto accountsDto) {

		if (null == accountsDto.getId() || accountsDto.getId() <= 0) {
			throw new AccountsException("Invalid Id");
		}

		AccountsDto userDetails = accountsService.updateAccounts(accountsDto);

		return new ResponseEntity<>(userDetails, HttpStatus.OK);
	}

	@DeleteMapping("/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable(required = true) Long userId) {

		try {
			if (userId <= 0) {
				throw new AccountsException("Invalid Id");
			}
			accountsService.deleteAccounts(userId);
		} catch (Exception e) {
			throw new AccountsException("Error while Deleting Record");
		}
		
		Map<String,Object> map=new HashMap<>();
		map.put("message", "Record Deleted ID :: "+userId);

		return new ResponseEntity<Map>(map,HttpStatus.OK);
	}
}
