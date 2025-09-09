package com.cdac.core; 

import com.cdac.exception.StackOverflowException;
import com.cdac.exception.StackUnderflowException;

public class FixedStack implements Stack {
    private Customer[] stack;
    private int top;

    public FixedStack() {
        stack = new Customer[STACK_SIZE]; // fixed size = 3
        top = -1;
    }

    @Override
    public void push(Customer c) {
        if (top == stack.length - 1) {
            throw new StackOverflowException("FixedStack is full! Cannot push more customers.");
        }
        stack[++top] = c;
        System.out.println("Customer pushed to FixedStack");
    }

    @Override
    public Customer pop() {
        if (top == -1) {
            throw new StackUnderflowException("FixedStack is empty! Cannot pop.");
        }
        return stack[top--];
    }
}
