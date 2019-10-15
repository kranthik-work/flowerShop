package com.kkalletla.flowershop.Control;

import com.kkalletla.flowershop.entity.Flower;
import com.kkalletla.flowershop.entity.Manager;
import com.kkalletla.flowershop.entity.Shop;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public class Delete {

    public void deleteAShop(Session session, long shopId){

        try{

            /*Query for the shop, retrieve managers and flowers and set the shopid to null for each.
            * Then delete.*/
            Shop shop = session.get(Shop.class, shopId);

            if(shop != null) {
                List<Manager> managers = shop.getManagers();
                List<Flower> flowers = shop.getFlowers();

                for (Manager manager : managers)
                    manager.setShop(null);
                for (Flower flower : flowers)
                    flower.setShop(null);

                session.delete(shop);
            }
            else
                System.out.println("No shop with given ID: "+shopId);
        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            /*session.close();
            HibernateUtility.closeSessionFactory();*/
        }
    }

    public void deleteAManager(Session session, long managerId){

        try{

            /*Retrieve a manager, then query the shop and delete the manager from the list.
            * Then delete manager from the session and commit*/

            Manager manager = session.get(Manager.class, managerId);

            if(manager != null) {
                session.delete(manager);
            }
            else
                System.out.println("No manager with ID: "+ managerId);

        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            /*session.close();
            HibernateUtility.closeSessionFactory();*/
        }
    }

    public void deleteAFlower(Session session, String flowerName){

        try{

            /*Retrieve a Flower, then query the shop and delete the Flower from the list.
            * Then delete Flower from the session and commit*/

            List<Flower> flowers = session.createQuery("from Flower where name = '"+flowerName+"'").getResultList();

            for(Flower flower: flowers)
                session.delete(flower);
        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            /*session.close();
            HibernateUtility.closeSessionFactory();*/
        }
    }
}
