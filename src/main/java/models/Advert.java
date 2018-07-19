package models;

import java.util.ArrayList;
import java.util.List;

public class Advert {

    private String title;
    private String description;
    private double price;
    private String imagePath;
    private List<CategoryType> categories;
    Shop shop;

    public Advert(String title, String description, double price, String imagePath) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.imagePath = imagePath;
        this.categories = new ArrayList<CategoryType>();
    }


    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }


    public String getDescription() {
        return this.description;
    }
    public void setDescription(String description) {
        this.description = description;
    }


    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }


    public String getImagePath() {
        return imagePath;
    }
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }


    public List<CategoryType> getCategories() {
        return categories;
    }
    public void setCategories(List<CategoryType> categories) {
        this.categories = categories;
    }


    public Shop getShop() {
        return shop;
    }
    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public void addCategory(CategoryType category) {
        this.categories.add(category);
    }

    public void removeCategory(CategoryType category) {
        this.categories.remove(category);
    }
}


