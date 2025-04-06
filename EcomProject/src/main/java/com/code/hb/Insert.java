package com.code.hb;

import com.code.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


public class Insert {
    private SessionFactory sessionfactory = null;
    public Insert(SessionFactory sessionfactory){
        this.sessionfactory=sessionfactory;
        Session session = sessionfactory.getCurrentSession();
        session.beginTransaction();

       // Category category = new Category("Books","Fiction, non-fiction etc.");
        //Category category1 = new Category("Electronics","Gadgets and accessories");
       // session.persist(category1);
        //session.persist(category);

        //Fetch existing category 
//        List<Category> categories = session.createQuery("from Category", Category.class).getResultList();
//
//        for (Category cat : categories) {
//            System.out.println(cat);
//        }
//        Category category = session.get(Category.class, 12); // "Books"
//        Category category1 = session.get(Category.class, 13); // "Electronics"
//        // Now pass the values to Product constructor
//        Product p1 = new Product(category,"Atomic Habits", new BigDecimal("350"), 30);
//        Product p2 = new Product(category,"Rich Dad Poor Dad", new BigDecimal("299"), 20);
//        Product p3 = new Product(category1,"Wireless Mouse", new BigDecimal("1500"), 15);
//        Product p4 = new Product(category1,"Bluetooth Speaker ", new BigDecimal("899"), 10);
//
//      
//
//        session.persist(p1);
//        session.persist(p2);
//        session.persist(p3);
//        session.persist(p4);


//        User user = new User("Md Adil Farhan","Adil7756","farhanadil@gmail.com", Role.ADMIN);
//        User user1 = new User("Joseph jones","jos123","ks@gmail.com", Role.CUSTOMER);
////
//        session.persist(user);
//        session.persist(user1);

        User user = session.get(User.class, 13); // Ensure this user exists

     // Step 2: Create two orders for that user
     Orders order1 = new Orders(LocalDateTime.now(), 1500.0, user);
    // Orders order2 = new Orders(LocalDateTime.now(), 899.0, user);
     session.persist(order1);
     //session.persist(order2);
     	Orders o1 = session.get(Orders.class,7);
     	Orders o2 = session.get(Orders.class,8);
     	Orders o3 = session.get(Orders.class,9);


        Product p1 = session.get(Product.class,16);
        Product p2 = session.get(Product.class,17);
        Product p3 = session.get(Product.class,18);
        Product p4 = session.get(Product.class,19);


//
//
        OrderDetails od1 = new OrderDetails(20,new BigDecimal(500),o1,p1);
        OrderDetails od2 = new OrderDetails(30,new BigDecimal(400),o2,p2);
        OrderDetails od3 = new OrderDetails(30,new BigDecimal(400),o3,p3);

//
        session.persist(od1);
        session.persist(od2);
        session.persist(od3);

        session.getTransaction().commit();
        session.close();
    }
}