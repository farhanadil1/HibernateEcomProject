package com.code.hb;

import com.code.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class App {
    public static void main(String[] args) {
    	  SessionFactory sf = new Configuration().configure().
                  addAnnotatedClass(Category.class).
                  addAnnotatedClass(OrderDetails.class).
                  addAnnotatedClass(Orders.class).
                  addAnnotatedClass(Product.class).
                  addAnnotatedClass(User.class).
                  buildSessionFactory();

          new Insert(sf);
    }
}
