package db;

import models.Advert;
import models.Shop;

public class Seeds {

    public static void seedData() {

        Shop shop = new Shop("Plumtree");
        DBHelper.save(shop);

        Advert advert1 = new Advert("Bike", "Very fast bike", 100.00, "/image/bike");
        DBHelper.save(advert1);
        Advert advert2 = new Advert("Dress", "Very nice dress", 50.00, "/image/dress");
        DBHelper.save(advert2);

    }


}
