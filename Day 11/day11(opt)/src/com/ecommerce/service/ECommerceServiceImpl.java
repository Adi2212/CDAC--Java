package com.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import com.ecommerce.core.Category;
import com.ecommerce.core.Customer;
import com.ecommerce.core.Order;
import com.ecommerce.core.OrderItem;
import com.ecommerce.core.Product;
import com.ecommerce.exception.DuplicateProductException;
import com.ecommerce.exception.ECommerceException;
import com.ecommerce.exception.InvalidCredentialsException;
import com.ecommerce.exception.OutOfStockException;

public class ECommerceServiceImpl implements ECommerceService {
    private List<Product> products = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();
    private Customer loggedInCustomer;

    // Add Product
    @Override
    public void addProduct(String name, double price, int stock, String category) throws DuplicateProductException {
        ECommerceValidations.checkDuplicateProduct(name, category, products);
        Product product = new Product(name, price, stock, Category.valueOf(category.toUpperCase()));
        products.add(product);
    }

    // Display Products
    @Override
    public void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
        } else {
            products.forEach(System.out::println);
        }
    }

    // Register Customer
    @Override
    public void registerCustomer(String name, String email, String password) throws ECommerceException {
        ECommerceValidations.checkDuplicateCustomer(email, customers);
        customers.add(new Customer(name, email, password));
    }

    // Customer Login
    @Override
    public void login(String email, String password) throws InvalidCredentialsException, ECommerceException {
        Customer c = customers.stream()
                .filter(cust -> cust.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .orElseThrow(() -> new ECommerceException("Customer not found."));
        
        ECommerceValidations.checkCredentials(c, password);
        loggedInCustomer = c;
    }

    // Place Order
    @Override
    public void placeOrder(int productId, int qty) throws OutOfStockException, ECommerceException {
        if (loggedInCustomer == null) {
            throw new ECommerceException("Please login first.");
        }

        // find product by id
        Product product = products.stream()
                .filter(p -> p.getpId() == productId)
                .findFirst()
                .orElseThrow(() -> new ECommerceException("Product not found."));

        ECommerceValidations.checkStock(product, qty);

        product.reduceStock(qty);
        Order order = new Order(loggedInCustomer);
        order.addItem(new OrderItem(product, qty));
        loggedInCustomer.addOrder(order);
        System.out.println("Order placed: " + order);
    }

    // View Orders
    @Override
    public void viewOrders() throws ECommerceException {
        if (loggedInCustomer == null) {
            throw new ECommerceException("Please login first.");
        }
        if (loggedInCustomer.getOrders().isEmpty()) {
            System.out.println("No orders found.");
        } else {
            loggedInCustomer.getOrders().forEach(System.out::println);
        }
    }

    // Cancel Order
    @Override
    public void cancelOrder(int orderId) throws ECommerceException {
        if (loggedInCustomer == null) {
            throw new ECommerceException("Please login first.");
        }
        Order orderToCancel = null;
        for (Order o : loggedInCustomer.getOrders()) {
            if (o.getOrderId() == orderId) {
                orderToCancel = o;
                break;
            }
        }
        if (orderToCancel == null) {
            throw new ECommerceException("Order not found.");
        }

        for (OrderItem item : orderToCancel.getItems()) {
            item.getProduct().increaseStock(item.getQuantity());
        }

        loggedInCustomer.getOrders().remove(orderToCancel);
        System.out.println("Order cancelled: " + orderId);
    }
}
