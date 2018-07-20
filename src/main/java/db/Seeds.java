package db;

import models.Advert;
import models.CategoryType;
import models.Shop;

import java.util.Arrays;
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
        Advert advert1 = new Advert("Bike", "Very fast bike", 100.00, "/images/bike1.jpg");
        advert1.setShop(shop);
        DBHelper.save(advert1);
        Advert advert2 = new Advert("Dress", "Very nice dress", 50.00, "/images/dress1.jpg");
        advert2.setShop(shop);
        DBHelper.save(advert2);
        Advert advert3 = new Advert("Phone", "Very good phone", 200.00, "/images/phone1.jpg");
        advert3.setShop(shop);
        advert3.addCategory(CategoryType.TECHNOLOGY);
        DBHelper.save(advert3);



        // update
        advert1.setTitle("Banana");
        DBHelper.update(advert1);

        // delete
//        DBHelper.delete(advert1);

        // findAll
        List<Advert> foundAdverts = DBHelper.findAll(Advert.class);

        // findById
        Advert foundAdvert = DBHelper.findById(Advert.class, advert2.getId());

        // addAdvertToShop
//        DBAdvert.addAdvertToShop(advert2, shop);

        // orderByPostedTime
        List<Advert> orderedAdverts = DBAdvert.orderByPostedTime();

        // findByCategory
        List<Advert> foundAdvertsInCategory = DBAdvert.findByCategory(CategoryType.TECHNOLOGY);

//        runs through the categorytype enum and creates a list filled with all of it's values
//        List<CategoryType> categories = Arrays.asList(CategoryType.values());


    }


}
