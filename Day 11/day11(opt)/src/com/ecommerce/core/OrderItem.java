package com.ecommerce.core;

public class OrderItem {
	 private Product product;
	    private int quantity;

	    public OrderItem(Product product, int quantity) {
	        this.product = product;
	        this.quantity = quantity;
	    }

		public int getQuantity() {
			return quantity;
		}

		public Product getProduct() {
			return product;
		}

		@Override
		public String toString() {
			return "OrderItem [product=" + product + ", quantity=" + quantity + "]";
		}

		

}

