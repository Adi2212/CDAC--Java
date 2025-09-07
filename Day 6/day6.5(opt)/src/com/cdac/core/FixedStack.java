package com.cdac.core;

public class FixedStack implements Stack {
    private Customer[] stack;
    private int top;

    public FixedStack() {
        stack = new Customer[STACK_SIZE];
        top = -1;
    }

    @Override
    public void push(Customer c) {
        if (top == STACK_SIZE - 1) {
            System.out.println("Stack Overflow!");
        } else {
            stack[++top] = c;
            System.out.println("Customer pushed to FixedStack");
        }
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
