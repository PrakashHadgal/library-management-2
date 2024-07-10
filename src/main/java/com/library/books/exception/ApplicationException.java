package com.library.books.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class ApplicationException extends RuntimeException {
	
	public ApplicationException(String bAD_REQUEST_CODE, String format, HttpStatus badRequest, String errorCode) {
		this.errorCode = errorCode;
		this.message = "";
		// TODO Auto-generated constructor stub
		this.httpStatus = null;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -750457482609020740L;
	private final String errorCode;
	private final String message;
	private final HttpStatus httpStatus;
}