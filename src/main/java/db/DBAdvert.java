package db;

import models.Advert;
import models.Shop;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DBAdvert {

    private static Session session;
    private static Transaction transaction;

    //TODO: probably redundant, save for later
//    public static void addAdvertToShop(Advert advert, Shop shop) {
//        shop.addToAdverts(advert);
//        DBHelper.update(shop);
//    }

}
