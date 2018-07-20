package models;

public enum CategoryType {

    TECHNOLOGY("Technology"),
    FASHION("Fashion"),
    GARDEN("Garden"),
    TRANSPORT("Transport"),
    SOLD("Sold");

    private String category;

    CategoryType(String category) {
        this.category = category;
    }
    public String getCategory() {
        return category;
    }
}
