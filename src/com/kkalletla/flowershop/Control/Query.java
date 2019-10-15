package com.kkalletla.flowershop.Control;

import com.kkalletla.flowershop.Utility.HibernateUtility;
import com.kkalletla.flowershop.entity.Flower;
import com.kkalletla.flowershop.entity.Manager;
import com.kkalletla.flowershop.entity.Shop;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public class Query {

    public void queryAll(Session session){

        try{

            /*Query Shops from the table*/
            List<Shop> shops = session.createQuery("from Shop").getResultList();

            /*As a shop is mapped to managers and flowers, they are also retrieved.*/
            for(Shop s: shops) {
                System.out.println(s);
                System.out.println("\t\tManagers");
                for(Manager manager: s.getManagers())
                    System.out.println("\t\t"+manager);
                System.out.println("\t\tFlowers");
                for(Flower flower: s.getFlowers())
                    System.out.println("\t\t"+flower);
                System.out.println("*************************************************************");
            }
        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            /*session.close();
            HibernateUtility.closeSessionFactory();*/
        }
    }

    public void queryOneRecord(Session session, long shopId){

        try{

            /*Query Shops from the table*/
            Shop shop = session.get(Shop.class,shopId);

            /*As a shop is mapped to managers and flowers, they are also retrieved.*/

            System.out.println(shop);
            System.out.println("\t\tManagers");
            for(Manager manager: shop.getManagers())
                System.out.println("\t\t"+manager);
            System.out.println("\t\tFlowers");
            for(Flower flower: shop.getFlowers())
                System.out.println("\t\t"+flower);

        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            /*session.close();
            HibernateUtility.closeSessionFactory();*/
        }
    }

    public void queryAShop(Session session, long shopId){

        try{

            Shop shop = session.get(Shop.class,shopId);

            if(shop != null) {
                System.out.println(shop);
                System.out.println("\t\tManagers");
                for (Manager manager : shop.getManagers())
                    System.out.println(manager);
                System.out.println("\t\tFlowers");
                for (Flower flower : shop.getFlowers())
                    System.out.println(flower);
                System.out.println("*************************************************************");
            }
            else{
                System.out.println("No Shop found with given id: "+shopId);
            }

        }catch (HibernateException e){
            System.out.println("No Shop found with given id: "+shopId);
            e.printStackTrace();
        }finally {
            /*session.close();
            HibernateUtility.closeSessionFactory();*/
        }
    }

    public void queryAManager(Session session, long managerId){

        try{

            Manager manager = session.get(Manager.class,managerId);

            if(manager != null) {
                System.out.println(manager);
                System.out.println(manager.getShop());
            }
            else{
                System.out.println("No Manager found with given id: "+managerId);
            }

        }catch (HibernateException e){
            System.out.println("No Manager found with given id: "+managerId);
            e.printStackTrace();
        }finally {
            /*session.close();
            HibernateUtility.closeSessionFactory();*/
        }
    }

    public void queryAFlower(Session session, String flowerName){

        try{

            List<Flower> flowers = session.createQuery("from Flower where name = '"+flowerName+"'").getResultList();

            if(flowers != null) {
                for(Flower flower: flowers){
                    System.out.println(flower);
                    System.out.println(flower.getShop());
                    System.out.println("*************************************************************");
                }
            }
            else{
                System.out.println("No Manager found with given id: "+flowerName);
            }

        }catch (HibernateException e){
            System.out.println("No Manager found with given id: "+flowerName);
            e.printStackTrace();
        }finally {
            /*session.close();
            HibernateUtility.closeSessionFactory();*/
        }
    }
}
