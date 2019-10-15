package com.kkalletla.flowershop.Control;

import com.kkalletla.flowershop.Utility.HibernateUtility;
import com.kkalletla.flowershop.entity.Flower;
import com.kkalletla.flowershop.entity.Manager;
import com.kkalletla.flowershop.entity.Shop;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.Calendar;
import java.util.Date;

public class TestInsert {

    public static void main(String[] args) {

        Session session = null;
        try{
            session = HibernateUtility.getSessionFactory().openSession();

            /*Create calender object and set hours and minutes.
            * Using calender create date with that time.*/
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY, 9);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND,0);
            Date open = calendar.getTime();


            calendar.set(Calendar.HOUR_OF_DAY,9);
            calendar.set(Calendar.SECOND,0);
            Date close = calendar.getTime();

            System.out.println(open);
            System.out.println(close);

            Shop shop = new Shop("CSU", "California", open, close );
            Manager manager = new Manager("Kranthi", "Kalletla", "IOWA");
            Flower flower = new Flower("Rose", 10, 100);

            shop.addManager(manager);
            shop.addFlower(flower);

            session.beginTransaction();
            session.save(shop);
            session.save(manager);
            session.save(flower);

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
