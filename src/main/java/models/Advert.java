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
}
