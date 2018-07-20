package controllers;

import db.DBHelper;
import models.Advert;
import models.CategoryType;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;

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



        // Create Advert
        get("/adverts/new", (req, res) -> {
            HashMap<String, Object> model = new HashMap<>();

            List<CategoryType> categories = Arrays.asList(CategoryType.values());
            model.put("categories", categories);
            model.put("template", "templates/adverts/create.vtl");

            return new ModelAndView(model, "templates/layout.vtl");
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

        // create new advert
        //





    }
}

