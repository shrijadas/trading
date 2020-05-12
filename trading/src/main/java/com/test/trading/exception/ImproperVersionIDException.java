package com.test.trading.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ImproperVersionIDException extends Exception{

	private static final long serialVersionUID = 1L;

	public ImproperVersionIDException(String message){
    	super(message);
    }
}
