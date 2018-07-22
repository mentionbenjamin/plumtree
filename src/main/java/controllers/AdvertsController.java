package controllers;

import db.DBAdvert;
import db.DBHelper;
import db.DBShop;
import models.Advert;
import models.CategoryType;
import models.Shop;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            model.put("template", "templates/adverts/index.vtl");
            model.put("adverts", adverts);

            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);



        // Sort Adverts By Timestamp
        get("/adverts/sorted-by-time-desc", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

            List<Advert> sortedAdvertsByTime = DBAdvert.orderByPostedTimeDescending();
            model.put("template", "templates/adverts/displays/time_desc.vtl");
            model.put("sortedAdvertsByTime", sortedAdvertsByTime);

            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);




        // Create Advert
        get("/adverts/new", (req, res) -> {
            HashMap<String, Object> model = new HashMap<>();

            List<CategoryType> categories = Arrays.asList(CategoryType.values()); // populate dropdown categories
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
            // getting back the inputted data and assigning to the respective variable names.
            // then with the variable names assisn to a new advert

            // TODO: find a way to get shop from db & add it to advert
            Shop shop = DBShop.findByShopName("Plumtree");
            advert.setShop(shop);

            String categoryValue = req.queryParams("category");
            advert.addCategory(CategoryType.valueOf(categoryValue.toUpperCase()));
            // now get the category inputted and add the value of that category to the advert

            DBHelper.save(advert);
            // finally save the advert

            res.redirect("/adverts");
            return null;
        }, velocityTemplateEngine);



        // Edit Advert
        get("/adverts/:id/edit", (req, res) -> {
            HashMap<String, Object> model = new HashMap<>();

            int advertId = Integer.parseInt(req.params(":id"));
            Advert advert = DBHelper.findById(Advert.class, advertId);
            model.put("advert", advert);

            List<CategoryType> categories = Arrays.asList(CategoryType.values()); // populate dropdown categories
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

//            String categoryValue = req.queryParams("category");
//            advert.getCategories().clear();
//            advert.addCategory(CategoryType.valueOf(categoryValue.toUpperCase()));

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
            DBHelper.delete(advert);

            res.redirect("/adverts");
            return null;
        }, velocityTemplateEngine);




    }
}

