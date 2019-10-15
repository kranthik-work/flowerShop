package com.kkalletla.flowershop.Utility;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {

    /*Declaring a SessionFactory to be used by the application*/
    private static SessionFactory sessionFactory;

    /*Static block to initialize SessionFactory.*/
    static {
        try{
            System.out.println("Creating SessionFactory");
            sessionFactory = new Configuration().configure()                    // Use configuration file to build session Factory.
                                                //.addAnnotatedClass(Shop.class)
                                                .buildSessionFactory();
        }catch (HibernateException e){
            // Handle the exception which might occur while creating SessionFactory
            System.out.println("Hibernate Exception while creating SessionFactory");
            e.printStackTrace();
        }
    }

    /*SessionFactory object should be singleton, so it is initialized using static block and
      the same object is returned when requested.*/
    public static SessionFactory getSessionFactory(){
        System.out.println("Returning SessionFactory");
        return sessionFactory;
    }

    /*Function used to close the SessionFactory*/
    public static void closeSessionFactory(){
        try{
            System.out.println("Closing SessionFactory");
            sessionFactory.close();
        }catch (HibernateException e){
            System.out.println("Exception while closing session factory");
        }
    }
}
