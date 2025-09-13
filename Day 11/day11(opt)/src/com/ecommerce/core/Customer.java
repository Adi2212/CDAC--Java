package com.ecommerce.core;

import java.util.ArrayList;
import java.util.List;

public class Customer {

	// name, email, password.
	private String name;
	private String email;
	private String password;
	private List<Order> orders;

	public Customer(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.orders = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public boolean equals(Object ob) {
		return this.email.equals(((Customer) ob).email);
	}

	public void addOrder(Order order) {
		this.orders.add(order);
	}

	public List<Order> getOrders() {
		return orders;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", email=" + email + ", password=" + password + ", orders=" + orders + "]";
	}

}
