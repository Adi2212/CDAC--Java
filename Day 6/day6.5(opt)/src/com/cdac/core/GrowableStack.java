package com.cdac.core;

import java.util.Arrays;

public class GrowableStack implements Stack {
    private Customer[] stack;
    private int top;

    public GrowableStack() {
        stack = new Customer[STACK_SIZE];
        top = -1;
    }

    @Override
    public void push(Customer c) {
        if (top == stack.length - 1) {
            // Grow size
            stack = Arrays.copyOf(stack, stack.length * 2);
            System.out.println("Stack size increased to " + stack.length);
        }
        stack[++top] = c;
        System.out.println("Customer pushed to GrowableStack");
    }

    @Override
    public Customer pop() {
        if (top == -1) {
            System.out.println("Stack Underflow!");
            return null;
        }
        return stack[top--];
    }
}
