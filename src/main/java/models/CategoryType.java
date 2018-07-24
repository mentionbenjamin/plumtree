package models;

public enum CategoryType {

    TECHNOLOGY("Technology"),
    FASHION("Fashion"),
    GARDEN("Garden"),
    TRANSPORT("Transport"),
    HOUSE("House"),
    MISC("Misc"),
    SOLD("Sold");

    private String category;

    CategoryType(String category) {
        this.category = category;
    }
    public String getCategory() {
        return category;
    }
}
