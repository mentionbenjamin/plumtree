package controllers;
import static spark.Spark.get;


import db.DBAdvert;
import models.Advert;
import models.CategoryType;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.*;

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
            Set<Advert> uniqueAdverts = new HashSet<>(adverts);


            model.put("adverts", uniqueAdverts);
            model.put("template", "templates/adverts/categories/fashion.vtl");

            return new ModelAndView(model, "templates/layout.vtl");

        }, velocityTemplateEngine);



        // Filter by category Garden
        get("/garden", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Advert> adverts = DBAdvert.findByCategory(CategoryType.GARDEN);
            Set<Advert> uniqueAdverts = new HashSet<>(adverts);


            model.put("adverts", uniqueAdverts);
            model.put("template", "templates/adverts/categories/garden.vtl");

            return new ModelAndView(model, "templates/layout.vtl");

        }, velocityTemplateEngine);



        // Filter by category Technology
        get("/technology", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Advert> adverts = DBAdvert.findByCategory(CategoryType.TECHNOLOGY);
            Set<Advert> uniqueAdverts = new HashSet<>(adverts);


            model.put("adverts", uniqueAdverts);
            model.put("template", "templates/adverts/categories/technology.vtl");

            return new ModelAndView(model, "templates/layout.vtl");

        }, velocityTemplateEngine);



        // Filter by category Transport
        get("/transport", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Advert> adverts = DBAdvert.findByCategory(CategoryType.TRANSPORT);
            Set<Advert> uniqueAdverts = new HashSet<>(adverts);


            model.put("adverts", uniqueAdverts);
            model.put("template", "templates/adverts/categories/transport.vtl");

            return new ModelAndView(model, "templates/layout.vtl");

        }, velocityTemplateEngine);



        // Filter by category Sold
        get("/sold", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Advert> adverts = DBAdvert.findByCategory(CategoryType.SOLD);
            Set<Advert> uniqueAdverts = new HashSet<>(adverts);


            model.put("adverts", uniqueAdverts);
            model.put("template", "templates/adverts/categories/sold.vtl");

            return new ModelAndView(model, "templates/layout.vtl");

        }, velocityTemplateEngine);



        // Filter by category House
        get("/house", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Advert> adverts = DBAdvert.findByCategory(CategoryType.HOUSE);
            Set<Advert> uniqueAdverts = new HashSet<>(adverts);


            model.put("adverts", uniqueAdverts);
            model.put("template", "templates/adverts/categories/house.vtl");

            return new ModelAndView(model, "templates/layout.vtl");

        }, velocityTemplateEngine);



        // Filter by category Misc
        get("/misc", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Advert> adverts = DBAdvert.findByCategory(CategoryType.MISC);
            Set<Advert> uniqueAdverts = new HashSet<>(adverts);


            model.put("adverts", uniqueAdverts);
            model.put("template", "templates/adverts/categories/misc.vtl");

            return new ModelAndView(model, "templates/layout.vtl");

        }, velocityTemplateEngine);


    }
}
