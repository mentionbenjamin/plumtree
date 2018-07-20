package db;

import models.Shop;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class DBShop {

    private static Session session;

    public static Shop findByShopName(String name){
        session = HibernateUtil.getSessionFactory().openSession();
        Shop result = null;

        try {
            Criteria cr = session.createCriteria(Shop.class);
            cr.add(Restrictions.eq("name", name));
            result = (Shop) cr.uniqueResult();
        }
        catch (HibernateException e){
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return result;
    }

}
