package com.ecommerce.service;

import java.util.List;
import java.util.Map;

import com.ecommerce.core.Category;
import com.ecommerce.core.Customer;
import com.ecommerce.core.Product;
import com.ecommerce.exception.DuplicateProductException;
import com.ecommerce.exception.ECommerceException;
import com.ecommerce.exception.InvalidCredentialsException;
import com.ecommerce.exception.OutOfStockException;

public class ECommerceValidations {

	// Prevent duplicate products (name + category combo must be unique)
	public static void checkDuplicateProduct(String name, String category, List<Product> products)
			throws DuplicateProductException {
		Product temp = new Product(name, Category.valueOf(category.toUpperCase())); 
	    
	    if (products.contains(temp)) {
	        throw new DuplicateProductException("Product already exists: " + name + " in " + category);
	    }
	}

	// Prevent duplicate customers (email must be unique)
	public static void checkDuplicateCustomer(String email, List<Customer> customers) throws ECommerceException {
		if (customers.contains(email)) {
			throw new ECommerceException("Email already registered: " + email);
		}
	}

	// Check login credentials
	public static void checkCredentials(Customer c, String password) throws InvalidCredentialsException {
		if (c == null || !c.getPassword().equals(password)) {
			throw new InvalidCredentialsException("Invalid email or password.");
		}
	}

	// Stock validation
	public static void checkStock(Product product, int qty) throws OutOfStockException {
		if (product.getStock() < qty) {
			throw new OutOfStockException("Not enough stock for " + product.getName());
		}
	}
}
