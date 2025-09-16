package com.iacsd.exceptions;

@SuppressWarnings("serial")
public class InvalidEmailException extends StudentException {
    public InvalidEmailException(String msg) {
        super(msg);
    }
}
