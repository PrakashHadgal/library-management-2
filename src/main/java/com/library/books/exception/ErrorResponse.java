package com.library.books.exception;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ErrorResponse {
	public ErrorResponse(String guid2, String iNTERNAL_ERROR, String string, int value, String name, String requestURI,
			String method2, LocalDateTime now) {
		this.guid = "";
		this.errorCode = "";
		this.message = "";
		this.statusCode = null;
		this.statusName = "";
		this.path = "";
		this.method = "";
		this.timestamp = null;
		// TODO Auto-generated constructor stub
	}

	private final String guid;
	private final String errorCode;
	private final String message;
	private final Integer statusCode;
	private final String statusName;
	private final String path;
	private final String method;
	private final LocalDateTime timestamp;
}