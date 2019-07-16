package com.practice.products.exception;

public class ProductException extends Exception {
	private static final long serialVersionUID = 1L;
	private String errorMsg;

	public ProductException(String errorMsg) {
		super();
		this.errorMsg = errorMsg;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

}
