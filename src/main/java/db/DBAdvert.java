package db;

import models.Advert;
import models.Shop;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import sun.tools.java.ClassType;

import java.util.ArrayList;
import java.util.List;

public class DBAdvert {

    private static Session session;
    private static Transaction transaction;

    //TODO: probably redundant, save for later
//    public static void addAdvertToShop(Advert advert, Shop shop) {
//        shop.addToAdverts(advert);
//        DBHelper.update(shop);
//    }

    public static List<Advert> orderByPostedTime() {
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

}
