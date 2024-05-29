package com.accounts.app.exceptions;

public class AccountsException extends RuntimeException{
	
	private String message;
	
	public AccountsException(String message) {
		this.message=message;
	}
	

	@Override
	public String getMessage() {
		return this.message;
	}

	
}
