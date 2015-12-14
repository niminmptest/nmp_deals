package com.bigsavings.deals.exception;

public enum ErrorCode {

	BIGSAVINGS_ERROR_CODE(5001),
	UNEXPECTED_ERROR_CODE(4001);
	
	private int errorCode;
	
	private ErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public int getErrorCode() {
		return errorCode;
	}
}
