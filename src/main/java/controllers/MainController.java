package controllers;

import db.Seeds;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.SparkBase.staticFileLocation;

public class MainController {

    public static void main(String[] args) {

        VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();

        staticFileLocation("/public"); //must be above any extra controllers and seed data
        AdvertsController advertsController = new AdvertsController();
        Seeds.seedData();



        // Home
        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

            model.put("template", "templates/index.vtl");

            return new ModelAndView(model,"templates/layout.vtl");
        }, velocityTemplateEngine);












    }
}
