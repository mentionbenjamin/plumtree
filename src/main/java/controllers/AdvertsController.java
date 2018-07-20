package controllers;

import db.DBHelper;
import models.Advert;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

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

        get("/adverts", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

            List<Advert> adverts = DBHelper.findAll(Advert.class);
            model.put("template", "templates/adverts/index.vtl");
            model.put("adverts", adverts);

            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);













    }
}

