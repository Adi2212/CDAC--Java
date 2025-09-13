package com.ecommerce.service;

import com.ecommerce.core.Category;
import com.ecommerce.exception.DuplicateProductException;
import com.ecommerce.exception.ECommerceException;
import com.ecommerce.exception.InvalidCredentialsException;
import com.ecommerce.exception.OutOfStockException;

public interface ECommerceService {
    void addProduct(String name, double price, int stock, String category) throws DuplicateProductException;
    void displayProducts();
    void registerCustomer(String name, String email, String password) throws ECommerceException;
    void login(String email, String password) throws InvalidCredentialsException, ECommerceException;
    void placeOrder(int productId, int qty) throws OutOfStockException, ECommerceException;
    void viewOrders() throws ECommerceException;
    void cancelOrder(int orderId) throws ECommerceException;
}
