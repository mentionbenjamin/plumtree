package db;

import models.Advert;
import models.CategoryType;
import models.Shop;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import sun.tools.java.ClassType;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class DBAdvert {

    private static Session session;
    private static Transaction transaction;

    //TODO: probably redundant, save for later
//    public static void addAdvertToShop(Advert advert, Shop shop) {
//        shop.addToAdverts(advert);
//        DBHelper.update(shop);
//    }



    // ORDER BY POSTED TIME DESCENDING
    public static List<Advert> orderByPostedTimeDescending() {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Advert> results = null;
        try {
            Criteria cr = session.createCriteria(Advert.class);
            cr.addOrder(Order.desc("timestamp"));
            results = cr.list();
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return results;
    }



    // ORDER BY POSTED TIME ASCENDING
    public static List<Advert> orderByPostedTimeAscending() {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Advert> results = null;
        try {
            Criteria cr = session.createCriteria(Advert.class);
            cr.addOrder(Order.asc("timestamp"));
            results = cr.list();
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return results;
    }



    // ORDER BY PRICE EITHER
    public static List<Advert> orderByPrice(boolean descTrueAscFalse) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Advert> results = null;
        try {
            if (descTrueAscFalse) {
                Criteria cr = session.createCriteria(Advert.class);
                cr.addOrder(Order.desc("price"));
                results = cr.list();
            }
            else {
                Criteria cr = session.createCriteria(Advert.class);
                cr.addOrder(Order.asc("price"));
                results = cr.list();
            }
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }

        return results;
    }



    // FIND BY CATEGORY
    public static List<Advert> findByCategory(CategoryType category) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Advert> results = new ArrayList<>();
        try {
            Criteria cr = session.createCriteria(Advert.class); // in the db go to the advert table and pull all the info from it
            List<Advert> adverts = cr.list(); // with the pulled info from the db, organise and assign into a list and call it adverts
            for (Advert advert : adverts) { // for advert in adverts
                if (advert.getCategories().contains(category) == true){ // whilst looping if the advert contains the category we are searching for
                    results.add(advert); // add to the results.
                }
            }
        }
        catch (HibernateException e){
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return results; // finally, return the results of the above...
    }



    // FIND BY TITLE
    public static Advert findByTitle(String title) {
        session = HibernateUtil.getSessionFactory().openSession();
        Advert result = null;
        try {
            Criteria cr = session.createCriteria(Advert.class);
            cr.add(Restrictions.eq("title", title));
            result = (Advert) cr.uniqueResult();
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return result;
    }



}
