package com.bank.exception;

@SuppressWarnings("serial")
public class LowBalanceException extends Exception {
	public LowBalanceException(String message) {
		super(message);
	}

}
