package com.ecommerce.core;

import java.util.ArrayList;
import java.util.List;


public class Order {
    private static int idCounter = 100;
    private int orderId;
    private Customer customer;
    private List<OrderItem> items;

    public Order(Customer customer) {
        this.orderId = idCounter++;
        this.customer = customer;
        this.items = new ArrayList<>();
    }

    public int getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void addItem(OrderItem item) {
        this.items.add(item);
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId + ", Customer: " + customer.getName() + ", Items: " + items;
    }
}

