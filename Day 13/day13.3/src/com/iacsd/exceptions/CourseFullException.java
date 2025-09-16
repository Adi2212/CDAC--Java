package com.iacsd.exceptions;

@SuppressWarnings("serial")
public class CourseFullException extends StudentException {
    public CourseFullException(String msg) {
        super(msg);
    }
}
