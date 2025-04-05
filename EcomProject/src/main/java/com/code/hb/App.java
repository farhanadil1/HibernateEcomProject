package com.code.hb;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.code.entity.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;



public class App {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure() // hibernate.cfg.xml
                .addAnnotatedClass(Category.class)
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Orders.class)
                .addAnnotatedClass(OrderDetails.class)
                .buildSessionFactory();

        Session session = factory.openSession();
        session.beginTransaction();

        // Sample insert
        Category category = new Category();
        category.setName("Electronics");
        category.setDescription("Gadgets and devices");
        System.out.println("Saving Category: " + category.getName() + ", " + category.getDescription());
        session.persist(category);

        Product product = new Product(category, "Smartphone", new BigDecimal("799.99"), 10);
        System.out.println("Saving Product: " + product.getName() + ", Price: " + product.getPrice() + ", Stock: " + product.getStockQuantity());
        session.persist(product);
        
        User user = new User();
        user.setUsername("bob");
        user.setPassword("pass123");
        user.setEmailId("bobl2@email.com");
        user.setRole(Role.CUSTOMER);
        System.out.println("Saving User: " + user.getUsername() + ", " + user.getEmailId() + ", Role: " + user.getRole());
        session.persist(user);

        Orders order = new Orders(new Date(0), 1500.0, user);
        System.out.println("Saving Order: Date = " + order.getOrderDate() + ", Total = " + order.getTotalAmount());
        session.persist(order);

        OrderDetails orderDetails = new OrderDetails(1, new BigDecimal("999.99") ,order, product);
        System.out.println("Saving OrderDetails: Product = " + product.getName() + ", Quantity = " + orderDetails.getQuantity() + ", Unit Price = " + orderDetails.getUnitPrice());
        session.persist(orderDetails);

        session.getTransaction().commit();
        session.close();
        factory.close();
    }
}
