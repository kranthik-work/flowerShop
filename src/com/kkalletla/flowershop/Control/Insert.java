package com.kkalletla.flowershop.Control;

import com.kkalletla.flowershop.entity.Flower;
import com.kkalletla.flowershop.entity.Manager;
import com.kkalletla.flowershop.entity.Shop;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Insert {

    Scanner scanner = new Scanner(System.in);

    public void insertAll(Session session){

        try{

            Shop shop = getShop();
            Manager manager = getManager();
            Flower flower = getFlower();

            shop.addManager(manager);
            shop.addFlower(flower);

            session.save(shop);
            session.save(manager);
            session.save(flower);

        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            /*session.close();
            HibernateUtility.closeSessionFactory();*/
        }
    }

    public void insertShop(Session session){

        try{
            Shop shop = getShop();

            session.save(shop);

        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
                /*session.close();
                HibernateUtility.closeSessionFactory();*/
        }
    }

    public void insertManager(Session session){

        try{

            Manager manager = getManager();

            System.out.println("Id of the store: ");
            long shopId = scanner.nextLong();
            Shop shop = session.get(Shop.class, shopId);

            if(shop != null){
                shop.addManager(manager);
                session.save(shop);
                session.save(manager);
            }
            else{
                System.out.println("Shop not found. Not inserting manager.");
            }

        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
                /*session.close();
                HibernateUtility.closeSessionFactory();*/
        }
    }

    public void insertFlower(Session session){

        try{

            Flower flower = getFlower();

            System.out.println("Id of the store: ");
            long shopId = scanner.nextLong();
            Shop shop = session.get(Shop.class, shopId);

            if(shop != null){
                shop.addFlower(flower);
                session.save(shop);
                session.save(flower);
            }
            else{
                System.out.println("Shop not found. Not inserting Flower.");
            }

        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
                /*session.close();
                HibernateUtility.closeSessionFactory();*/
        }
    }

    private Shop getShop(){

        /***************************************Code to get Store Details*******************************************************/
        System.out.println("Name of the store: ");
        String storeName = scanner.nextLine();

        System.out.println("Address of the store: ");
        String storeAddress = scanner.nextLine();

        System.out.println("Opening hour of the store: ");
        int openHour = scanner.nextInt();

        System.out.println("Closing Hour of the store: ");
        int closeHour = scanner.nextInt();


        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, openHour);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND,0);
        Date open = calendar.getTime();


        calendar.set(Calendar.HOUR_OF_DAY,closeHour);
        calendar.set(Calendar.SECOND,0);
        Date close = calendar.getTime();
        Shop shop = new Shop(storeName,storeAddress, open, close );

        return shop;
    }

    private Manager getManager(){

        /***************************************Code to get Manager Details*******************************************************/

        scanner.nextLine();
        System.out.println("First Name of the Manager: ");
        String managerFName = scanner.nextLine();

        System.out.println("Last Name of the Manager: ");
        String managerLName = scanner.nextLine();

        System.out.println("Address of the Manager: ");
        String managerAddress = scanner.nextLine();
        Manager manager = new Manager(managerFName, managerLName, managerAddress);
        return manager;
    }
    private Flower getFlower(){

        /***************************************Code to get Flower Details*******************************************************/

        System.out.println("Flower Name: ");
        String flowerName = scanner.nextLine();

        System.out.println("Rate: ");
        int rate = scanner.nextInt();

        System.out.println("Quantity: ");
        int quantity = scanner.nextInt();
        Flower flower = new Flower(flowerName,rate,quantity);
        return flower;
    }
}
