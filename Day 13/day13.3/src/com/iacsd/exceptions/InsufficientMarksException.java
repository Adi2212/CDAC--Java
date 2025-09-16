package com.iacsd.exceptions;

@SuppressWarnings("serial")
public class InsufficientMarksException extends StudentException {
    public InsufficientMarksException(String msg) {
        super(msg);
    }
}
