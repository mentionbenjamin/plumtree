package controllers;
import static spark.Spark.get;


import db.DBAdvert;
import models.Advert;
import models.CategoryType;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoriesController {

    public CategoriesController() {
        this.setUpEndPoints();
    }

    private void setUpEndPoints() {


        VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();




        // Filter by category Fashion
        get("/fashion", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Advert> adverts = DBAdvert.findByCategory(CategoryType.FASHION);

            model.put("adverts", adverts);
            model.put("template", "templates/adverts/categories/fashion.vtl");

            return new ModelAndView(model, "templates/layout.vtl");

        }, velocityTemplateEngine);



        // Filter by category Garden
        get("/garden", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Advert> adverts = DBAdvert.findByCategory(CategoryType.GARDEN);

            model.put("adverts", adverts);
            model.put("template", "templates/adverts/categories/garden.vtl");

            return new ModelAndView(model, "templates/layout.vtl");

        }, velocityTemplateEngine);



        // Filter by category Technology
        get("/technology", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Advert> adverts = DBAdvert.findByCategory(CategoryType.TECHNOLOGY);

            model.put("adverts", adverts);
            model.put("template", "templates/adverts/categories/technology.vtl");

            return new ModelAndView(model, "templates/layout.vtl");

        }, velocityTemplateEngine);



        // Filter by category Transport
        get("/transport", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Advert> adverts = DBAdvert.findByCategory(CategoryType.TRANSPORT);

            model.put("adverts", adverts);
            model.put("template", "templates/adverts/categories/transport.vtl");

            return new ModelAndView(model, "templates/layout.vtl");

        }, velocityTemplateEngine);



        // Filter by category Sold
        get("/sold", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Advert> adverts = DBAdvert.findByCategory(CategoryType.SOLD);

            model.put("adverts", adverts);
            model.put("template", "templates/adverts/categories/sold.vtl");

            return new ModelAndView(model, "templates/layout.vtl");

        }, velocityTemplateEngine);



        // Filter by category House
        get("/house", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Advert> adverts = DBAdvert.findByCategory(CategoryType.HOUSE);

            model.put("adverts", adverts);
            model.put("template", "templates/adverts/categories/house.vtl");

            return new ModelAndView(model, "templates/layout.vtl");

        }, velocityTemplateEngine);



        // Filter by category Misc
        get("/misc", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Advert> adverts = DBAdvert.findByCategory(CategoryType.MISC);

            model.put("adverts", adverts);
            model.put("template", "templates/adverts/categories/misc.vtl");

            return new ModelAndView(model, "templates/layout.vtl");

        }, velocityTemplateEngine);


    }
}
