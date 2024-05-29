package com.accounts.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class AccountsResponseEntityException extends ResponseEntityExceptionHandler{

	@ExceptionHandler
	public final ResponseEntity<?> handleCrudOperationException(AccountsException ex, WebRequest webRequest){
		return new ResponseEntity<Object>(ex,HttpStatus.BAD_REQUEST);
	}
}
