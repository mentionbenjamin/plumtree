package db;

import models.Advert;
import models.Shop;

import java.util.List;

public class Seeds {

    public static void seedData() {

        // deleteAll
        DBHelper.deleteAll(Advert.class);
        DBHelper.deleteAll(Shop.class);

        // shop
        Shop shop = new Shop("Plumtree");
        DBHelper.save(shop);

        // adverts
        Advert advert1 = new Advert("Bike", "Very fast bike", 100.00, "/image/bike");
        advert1.setShop(shop);
        DBHelper.save(advert1);
        Advert advert2 = new Advert("Dress", "Very nice dress", 50.00, "/image/dress");
        advert2.setShop(shop);
        DBHelper.save(advert2);



        // update
        advert1.setTitle("Banana");
        DBHelper.update(advert1);

        // delete
        DBHelper.delete(advert1);

        // findAll
        List<Advert> foundAdverts = DBHelper.findAll(Advert.class);

        // findById
        Advert foundAdvert = DBHelper.findById(Advert.class, advert2.getId());

        // addAdvertToShop
//        DBAdvert.addAdvertToShop(advert2, shop);




    }


}
