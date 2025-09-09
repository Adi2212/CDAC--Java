package com.cdac.core;

import com.cdac.exception.StackOverflowException;
import com.cdac.exception.StackUnderflowException;

public interface Stack {
    int STACK_SIZE = 3; // constant size for FixedStack

    void push(Customer c) throws StackOverflowException;
    Customer pop() throws StackUnderflowException;
}
