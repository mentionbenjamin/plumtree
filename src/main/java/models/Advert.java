package models;

public class Advert {

    private String title;
    private String description;
    private double price;
    private String imagePath;
    CategoryType category;
    Shop shop;

    public Advert(String title, String description, double price, String imagePath, CategoryType category) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.imagePath = imagePath;
        this.category = category;
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


    public CategoryType getCategory() {
        return category;
    }
    public void setCategory(CategoryType category) {
        this.category = category;
    }


    public Shop getShop() {
        return shop;
    }
    public void setShop(Shop shop) {
        this.shop = shop;
    }
}


