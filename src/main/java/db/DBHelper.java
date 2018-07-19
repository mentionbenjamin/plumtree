package db;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBHelper {

    private static Session session;
    private static Transaction transaction;


    // SAVE
    public static void save(Object object) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(object);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    //UPDATE
    public static void update(Object object) {
        session = HibernateUtil.getSessionFactory().openSession();

        try {
            transaction = session.beginTransaction();
            session.update(object);
            transaction.commit();
        }
        catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        }
        finally {
            session.close();
        }
    }


    //DELETE
    public static void delete(Object object) {
        session = HibernateUtil.getSessionFactory().openSession();

        try {
            transaction = session.beginTransaction();
            session.delete(object);
            transaction.commit();
        }
        catch (HibernateException e){
            transaction.rollback();
            e.printStackTrace();
        }
        finally {
            session.close();
        }
    }


    //DELETE ALL
    public static <Type> void deleteAll(Class classType) {
        session = HibernateUtil.getSessionFactory().openSession();

        try {
            transaction = session.beginTransaction();
            Criteria cr = session.createCriteria(classType);
            List<Type> results = cr.list();
            for (Type result : results) {
                session.delete(result);
            }
            transaction.commit();
        }
        catch (HibernateException e){
            transaction.rollback();
            e.printStackTrace();
        }
        finally {
            session.close();
        }
    }


    // FIND ALL
    public static <Type> List<Type> findAll(Class classType) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Type> results = null;
        try {
            Criteria cr = session.createCriteria(classType);
            results = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }


    // FIND BY ID
    public static <Type> Type findById(Class classType, int id) {
        session = HibernateUtil.getSessionFactory().openSession();
        Type result = null;
        try {
            Criteria cr = session.createCriteria(classType);
            cr.add(Restrictions.eq("id", id));
            result = (Type) cr.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

}
