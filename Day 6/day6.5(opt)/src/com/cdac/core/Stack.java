package com.cdac.core;

public interface Stack {
    int STACK_SIZE = 3; // constant size for FixedStack

    void push(Customer c);
    Customer pop();
}
