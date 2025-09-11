package com.bank.exception;

@SuppressWarnings("serial")
public class DuplicateAccountException extends Exception {
    public DuplicateAccountException(String message) {
        super(message);
    }
}
