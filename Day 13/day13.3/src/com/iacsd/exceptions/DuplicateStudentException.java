package com.iacsd.exceptions;

@SuppressWarnings("serial")
public class DuplicateStudentException extends StudentException {
    public DuplicateStudentException(String msg) {
        super(msg);
    }
}
