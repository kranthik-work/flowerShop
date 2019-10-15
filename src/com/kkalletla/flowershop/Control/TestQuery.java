package com.kkalletla.flowershop.Control;

import com.kkalletla.flowershop.Utility.HibernateUtility;
import com.kkalletla.flowershop.entity.Flower;
import com.kkalletla.flowershop.entity.Manager;
import com.kkalletla.flowershop.entity.Shop;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public class TestQuery {

    public static void main(String[] args) {

        Session session = null;
        try{
            session = HibernateUtility.getSessionFactory().openSession();

            session.beginTransaction();
            Shop shop = session.get(Shop.class,3L);
            List<Manager> managers = shop.getManagers();
            List<Flower> flowers = shop.getFlowers();

            System.out.println(shop);
            System.out.println(managers);
            System.out.println(flowers);

            session.getTransaction().commit();
        }catch (HibernateException e){
            System.out.println("Hibernate Exception in TestInsert");
            e.printStackTrace();
        }catch (Exception e){
            System.out.println("Exception in TestInsert");
            e.printStackTrace();
        }finally {
            session.close();
            HibernateUtility.closeSessionFactory();
        }
    }
}
