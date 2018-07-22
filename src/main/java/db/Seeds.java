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
        advert1.addCategory(CategoryType.TRANSPORT);
        DBHelper.save(advert1);
        Advert advert2 = new Advert("Dress", "Very nice dress", 50.00, "/images/dress1.jpg");
        advert2.setShop(shop);
        advert2.addCategory(CategoryType.FASHION);
        DBHelper.save(advert2);
        Advert advert3 = new Advert("Phone", "Very good phone", 200.00, "/images/phone1.jpg");
        advert3.setShop(shop);
        advert3.addCategory(CategoryType.TECHNOLOGY);
        DBHelper.save(advert3);
        Advert advert4 = new Advert("Hose", "Very long hose", 25.00, "/images/hose1.jpg");
        advert4.setShop(shop);
        advert4.addCategory(CategoryType.GARDEN);
        DBHelper.save(advert4);




        // --- WORKING TESTS BELOW --- //

        // update
//        advert1.setTitle("Banana");
//        DBHelper.update(advert1);

        // delete
//        DBHelper.delete(advert1);

        // findAll
//        List<Advert> foundAdverts = DBHelper.findAll(Advert.class);

        // findById
//        Advert foundAdvert = DBHelper.findById(Advert.class, advert2.getId());

        // addAdvertToShop
//        DBAdvert.addAdvertToShop(advert2, shop);

        // orderByPostedTimeDescending
//        List<Advert> orderedAdvertsByTimeDescending = DBAdvert.orderByPostedTimeDescending();

        // orderByPostedTimeAscending
//        List<Advert> orderedAdvertsByTieAscending = DBAdvert.orderByPostedTimeAscending();

        // findByCategory
//        List<Advert> foundAdvertsInCategory = DBAdvert.findByCategory(CategoryType.TECHNOLOGY);

//        runs through the categorytype enum and creates a list filled with all of it's values
//        List<CategoryType> categories = Arrays.asList(CategoryType.values());


//        List<CategoryType> categories = advert1.getCategories();
//        boolean testBoolean = advert1.hasCategory(CategoryType.TRANSPORT);

//        Advert foundAdvert = DBHelper.findById(Advert.class, advert2.getId());

//        List<Advert> orderedAdvertsByPriceExpensiveFirst = DBAdvert.orderByPrice(true);
//        List<Advert> orderedAdvertsByPriceCheapFirst = DBAdvert.orderByPrice(false);

//        Advert advertFoundByTitle = DBAdvert.findByTitle("Bike");
//        Advert advertFoundByTitleWhichDoesntExist = DBAdvert.findByTitle("Error");

        List<Advert> foundAdvertsByPrice = DBAdvert.findByPrice(100.00);
        List<Advert> foundAdvertsByPriceNoneExists = DBAdvert.findByPrice(2.00);

    }


}
