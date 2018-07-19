package db;

import models.Advert;
import models.Shop;

import java.util.List;

public class Seeds {

    public static void seedData() {

        // DELETE ALL
        DBHelper.deleteAll(Shop.class);
        DBHelper.deleteAll(Advert.class);

        // SHOP SEED DATA
        Shop shop = new Shop("Plumtree");
        DBHelper.save(shop);

        // ADVERT SEED DATA
        Advert advert1 = new Advert("Bike", "Very fast bike", 100.00, "/image/bike");
        advert1.setShop(shop);
        DBHelper.save(advert1);
        Advert advert2 = new Advert("Dress", "Very nice dress", 50.00, "/image/dress");
        advert2.setShop(shop);
        DBHelper.save(advert2);

        // UPDATE
        advert1.setTitle("Banana");
        DBHelper.update(advert1);

        // DELETE
        DBHelper.delete(advert1);

        // FIND ALL
        List<Advert> foundAdverts = DBHelper.findAll(Advert.class);

        // FIND BY ID
        Advert foundAdvert = DBHelper.findById(Advert.class, advert2.getId());






    }


}
