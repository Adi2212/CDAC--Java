package com.iacsd.exceptions;

@SuppressWarnings("serial")
public class StudentNotFoundException extends StudentException {
    public StudentNotFoundException(String msg) {
        super(msg);
    }
}
