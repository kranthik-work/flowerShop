package com.kkalletla.flowershop;

import com.kkalletla.flowershop.Control.Delete;
import com.kkalletla.flowershop.Control.Insert;
import com.kkalletla.flowershop.Control.Query;
import com.kkalletla.flowershop.Utility.HibernateUtility;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.Scanner;

public class FlowerShopApplication {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long shopId;
        long managerId;
        String flowerName;
        Session session = null;
        try{
            session = HibernateUtility.getSessionFactory().openSession();

            session.beginTransaction();

            while(true){
                System.out.println("****************************************************************************");
                System.out.println("1. Query All Tables");
                System.out.println("2. Insert all records at once");
                System.out.println("3. Add New Shop");
                System.out.println("4. Add New Manager");
                System.out.println("5. Add new Flower item");
                System.out.println("6. Delete Shop");
                System.out.println("7. Delete Manager");
                System.out.println("8. Delete Flower item");
                System.out.println("9. Query Shop");
                System.out.println("10. Query Manager");
                System.out.println("11. Query Flower item");
                System.out.println("12. Query one record");
                System.out.println("*****************************************************************************");

                int input = scanner.nextInt();

                //session.beginTransaction();
                switch (input){
                    case 1:
                        new Query().queryAll(session);
                        break;

                    case 2:
                        new Insert().insertAll(session);
                        break;
                    case 3:
                        new Insert().insertShop(session);
                        break;

                    case 4:
                        new Insert().insertManager(session);
                        break;

                    case 5:
                        new Insert().insertFlower(session);
                        break;

                    case 6:
                        System.out.println("Enter Shop ID: ");
                        shopId = scanner.nextLong();
                        new Delete().deleteAShop(session,shopId);
                        break;

                    case 7:
                        System.out.println("Enter Manager ID: ");
                        managerId = scanner.nextLong();
                        new Delete().deleteAManager(session,managerId);
                        break;

                    case 8:
                        System.out.println("Enter Flower Name: ");
                        scanner.nextLine();
                        flowerName = scanner.nextLine();
                        new Delete().deleteAFlower(session,flowerName);
                        break;

                    case 9:
                        System.out.println("Enter Shop ID: ");
                        shopId = scanner.nextLong();
                        new Query().queryAShop(session,shopId);
                        break;

                    case 10:
                        System.out.println("Enter Manager ID: ");
                        managerId = scanner.nextLong();
                        new Query().queryAManager(session,managerId);
                        break;

                    case 11:
                        System.out.println("Enter Flower Name: ");
                        scanner.nextLine();
                        flowerName = scanner.nextLine();
                        new Query().queryAFlower(session,flowerName);
                        break;

                    case 12:
                        System.out.println("Enter shop ID: ");
                        shopId = scanner.nextLong();
                        new Query().queryOneRecord(session, shopId);
                        break;

                }
                session.getTransaction().commit();
                session.close();
                session = HibernateUtility.getSessionFactory().openSession();
                session.beginTransaction();
            }

        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
            HibernateUtility.closeSessionFactory();
        }

    }
}
