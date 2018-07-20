package models;

public enum CategoryType {

    TECHNOLOGY("technology"),
    FASHION("fashion"),
    GARDEN("garden"),
    TRANSPORT("transport"),
    SOLD("sold");

    private String category;

    CategoryType(String category) {
        this.category = category;
    }
    public String getCategory() {
        return category;
    }
}
