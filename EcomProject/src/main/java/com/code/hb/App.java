package com.code.hb;

import com.code.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class App {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Category.class)
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Orders.class)
                .addAnnotatedClass(OrderDetails.class)
                .buildSessionFactory();

        Session session = factory.openSession();
        session.beginTransaction();

        // Create Category
        Category category = new Category();
        category.setName("Accessories");
        category.setDescription("Cases and Headphones");
        session.persist(category);

        // Create Product
        Product product = new Product();
        product.setName("Smartphone");
        product.setPrice(new BigDecimal("799.99"));
        product.setStockQuantity(15);
        product.setCategory(category);
        session.persist(product);

        // Create User
        User user = new User();
        user.setUsername("bob");
        user.setPassword("pass123");
        user.setEmailId("bob7@email.com");
        user.setRole(Role.CUSTOMER);
        session.persist(user);

        // Create Order
        Orders order = new Orders();
        order.setOrderDate(new Date());
        order.setTotalAmount(1599.98);
        order.setUser(user);
        session.persist(order);

        // Create OrderDetails
        OrderDetails details1 = new OrderDetails();
        details1.setOrders(order);
        details1.setProduct(product);
        details1.setQuantity(2);
        details1.setUnitPrice(new BigDecimal("799.99"));
        session.persist(details1);

        session.getTransaction().commit();

        // Fetch Orders with associated User and Product
        session = factory.openSession();
        session.beginTransaction();

        List<Orders> ordersList = session.createQuery("FROM Orders", Orders.class).list();
        for (Orders o : ordersList) {
            System.out.println("Order ID: " + o.getId() +
                               ", User: " + o.getUser().getUsername() +
                               ", Total: " + o.getTotalAmount());
            for (OrderDetails od : o.getOrderDetails()) {
                System.out.println("    Product: " + od.getProduct().getName() +
                                   ", Quantity: " + od.getQuantity());
            }
        }

        session.getTransaction().commit();
        session.close();
        factory.close();
    }
}
