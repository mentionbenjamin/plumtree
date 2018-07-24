package controllers;

import db.DBAdvert;
import db.DBHelper;
import db.DBShop;
import models.Advert;
import models.CategoryType;
import models.Shop;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.*;

import static spark.Spark.get;
import static spark.Spark.post;

public class AdvertsController {

    public AdvertsController() {
        this.setUpEndPoints();
    }

    private void setUpEndPoints() {

        VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();



        // Adverts
        get("/adverts", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

            List<Advert> adverts = DBHelper.findAll(Advert.class);
            Set<Advert> uniqueAdverts = new HashSet<>(adverts);

            model.put("template", "templates/adverts/index.vtl");
            model.put("adverts", uniqueAdverts);

            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);



        // Sort Adverts By Timestamp Descending
        get("/adverts/sorted-by-time-desc", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

            List<Advert> sortedAdvertsByTimeDesc = DBAdvert.orderByTime(true);

            model.put("template", "templates/adverts/displays/time_desc.vtl");
            model.put("sortedAdvertsByTime", sortedAdvertsByTimeDesc);

            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);



        // Sort Adverts By Timestamp Ascending
        get("/adverts/sorted-by-time-asc", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

            List<Advert> sortedAdvertsByTimeAsc = DBAdvert.orderByTime(false);

            model.put("template", "templates/adverts/displays/time_asc.vtl");
            model.put("sortedAdvertsByTime", sortedAdvertsByTimeAsc);

            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);



        // Sort Adverts By Price Descending
        get("/adverts/sorted-by-price-desc", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

            List<Advert> sortedAdvertsByPriceDescending = DBAdvert.orderByPrice(true);

            model.put("template", "templates/adverts/displays/price_desc.vtl");
            model.put("sortedAdvertsByPrice", sortedAdvertsByPriceDescending);

            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);



        // Sort Adverts By Price Ascending
        get("/adverts/sorted-by-price-asc", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

            List<Advert> sortedAdvertsByPriceAscending = DBAdvert.orderByPrice(false);

            model.put("template", "templates/adverts/displays/price_asc.vtl");
            model.put("sortedAdvertsByPrice", sortedAdvertsByPriceAscending);

            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);



        // Search
        // TODO: Maybe vestigial?
        get("/adverts/search", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

            model.put("template", "templates/adverts/searches/search.vtl");

            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);



        post("/adverts/search/title", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

            String submittedTitle = req.queryParams("search-results");
            List<Advert> foundAdverts = DBAdvert.findByTitle(submittedTitle);
            if (foundAdverts.size() == 0) {
                model.put("template", "templates/adverts/searches/no_result.vtl");
            }
            else {
                model.put("template", "templates/adverts/searches/results.vtl");
                model.put("foundAdverts", foundAdverts);
            }

            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);



        // TODO: Maybe vestigial?
        post("/adverts/search/price", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

            double submittedPrice = Double.parseDouble(req.queryParams("search-results"));
            List<Advert> foundAdverts = DBAdvert.findByPrice(submittedPrice);
            if (foundAdverts.size() == 0) {
                model.put("template", "templates/adverts/searches/no_result");
            }
            else {
                model.put("template", "templates/adverts/searches/results.vtl");
                model.put("foundAdverts", foundAdverts);
            }

            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);



        // Create Advert
        get("/adverts/new", (req, res) -> {
            HashMap<String, Object> model = new HashMap<>();

            List<CategoryType> categories = Arrays.asList(CategoryType.values());// populate dropdown categories
            model.put("categories", categories);
            model.put("template", "templates/adverts/create.vtl");

            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);



        // Create new advert
        post("/adverts", (req, res) -> {
            String title = req.queryParams("title");
            String description = req.queryParams("description");
            double price = Double.parseDouble(req.queryParams("price"));
            String imagePath = req.queryParams("image-path");
            Advert advert = new Advert(title, description, price, imagePath);

            // TODO: find a way to get shop from db & add it to advert

            Shop shop = DBShop.findByShopName("Plumtree");
            advert.setShop(shop);


            List<CategoryType> categories = Arrays.asList(CategoryType.values());
            //TODO: find out why this 'empty' arraylist has "on" inside it!!!!!!!!!
            List<String> categoryValues = new ArrayList<>();


            for (CategoryType category : categories) {
                String categoryName = category.getCategory();
                String categoryValue = req.queryParams(categoryName);
                if (categoryValue != null) {
                    categoryValues.add(categoryValue);
                }
            }

            advert.addCategoriesThatWereStrings(categoryValues);

            DBHelper.save(advert);

            res.redirect("/adverts");
            return null;
        }, velocityTemplateEngine);



        // Edit Advert
        get("/adverts/:id/edit", (req, res) -> {
            HashMap<String, Object> model = new HashMap<>();

            int advertId = Integer.parseInt(req.params(":id"));
            Advert advert = DBHelper.findById(Advert.class, advertId);
            model.put("advert", advert);

            List<CategoryType> categories = Arrays.asList(CategoryType.values());// populate dropdown categories
            model.put("categories", categories);
            model.put("template", "templates/adverts/edit.vtl");

            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);



        // Edit Advert Post
        post("/adverts/:id", (req, res) -> {

            String title = req.queryParams("title");
            String description = req.queryParams("description");
            double price = Double.parseDouble(req.queryParams("price"));
            String imagePath = req.queryParams("image-path");

            int advertId = Integer.parseInt(req.params(":id"));
            Advert advert = DBHelper.findById(Advert.class, advertId);

            advert.setTitle(title);
            advert.setDescription(description);
            advert.setPrice(price);
            advert.setImagePath(imagePath);

            List<CategoryType> categories = Arrays.asList(CategoryType.values());
            List<String> categoryValues = new ArrayList<>();

            for (CategoryType category : categories) {
                String categoryName = category.getCategory();
                String categoryValue = req.queryParams(categoryName);
                if (categoryValue != null) {
                    categoryValues.add(categoryValue);
                }
            }

            advert.getCategories().clear();
            advert.addCategoriesThatWereStrings(categoryValues);

            DBHelper.update(advert);

            res.redirect("/adverts");
            return null;
        }, velocityTemplateEngine);



        // View Advert
        get("/adverts/:id", (req, res) -> {
            HashMap<String, Object> model = new HashMap<>();

            int advertId = Integer.parseInt(req.params(":id"));
            Advert advert = DBHelper.findById(Advert.class, advertId);

            model.put("template", "templates/adverts/show.vtl");
            model.put("advert", advert);

            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);



        // Delete
        post("/adverts/:id/delete", (req, res) -> {
            int advertId = Integer.parseInt(req.params(":id"));
            Advert advert = DBHelper.findById(Advert.class, advertId);
            advert.delete();
            DBHelper.update(advert);

            res.redirect("/adverts");
            return null;
        }, velocityTemplateEngine);



        // Sell item
        post("/adverts/:id/sell", (req, res) -> {
            int advertId = Integer.parseInt(req.params(":id"));
            Advert advert = DBHelper.findById(Advert.class, advertId);
            advert.sell();
            DBHelper.update(advert);

            res.redirect("/adverts");
            return null;
        }, velocityTemplateEngine);

    }
}

