package com.bigsavings.util;

public enum Status {
	SUCCESS(0),
	FAILURE(1);
	
	private Integer code;
	
	Status(Integer code) {
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}
	
}
