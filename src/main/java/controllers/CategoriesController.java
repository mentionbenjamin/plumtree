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





    }
}
