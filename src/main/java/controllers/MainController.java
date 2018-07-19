package controllers;

import db.Seeds;
import spark.template.velocity.VelocityTemplateEngine;

public class MainController {

    public static void main(String[] args) {

        Seeds.seedData();



    }
}
