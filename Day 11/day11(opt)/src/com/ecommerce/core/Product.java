package com.ecommerce.core;

public class Product {
//name, category (enum), price, stock.
	private static int idCounter = 100;
	private int pId;
	private String name;
	private double price;
	private int stock;
	private Category prCategory;

	

	public Product(String name, double price, int stock, Category prCategory) {
		super();
		this.pId = idCounter++;
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.prCategory = prCategory;
	}





	public Product(String name, Category prCategory) {
		super();
		this.name = name;
		this.prCategory = prCategory;
	}


	


	@Override
	public String toString() {
		return "Product [pId=" + pId + ", name=" + name + ", price=" + price + ", stock=" + stock + ", prCategory="
				+ prCategory + "]";
	}





	public int getpId() {
		return pId;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getName() {
		return name;
	}

	public Category getPrCategory() {
		return prCategory;
	}

	// Validate → No duplicate combination of product name & category
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
        if (!(obj instanceof Product)) return false;
        Product other = (Product) obj;
        return this.name.equalsIgnoreCase(other.name)
                && this.prCategory.equals(other.prCategory);
	}

	public void reduceStock(int qty) {
		this.stock -= qty;
	}

	public void increaseStock(int qty) {
		this.stock += qty;
	}

}
