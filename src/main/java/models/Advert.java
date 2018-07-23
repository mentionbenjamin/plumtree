package models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "adverts")
public class Advert {

    private int id;
    private String title;
    private String description;
    private double price;
    private String imagePath;
    private List<CategoryType> categories;
    private Shop shop;
    private Timestamp timestamp;
    private String formattedTimestamp;
    private boolean deleted;

    public Advert() {}

    public Advert(String title, String description, double price, String imagePath) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.imagePath = imagePath;
        this.categories = new ArrayList<>();
        this.timestamp = Timestamp.from(Instant.now());
        this.deleted = false;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }


    @Column(name = "title")
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }


    @Column(name = "description")
    public String getDescription() {
        return this.description;
    }
    public void setDescription(String description) {
        this.description = description;
    }


    @Column(name = "price")
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }


    @Column(name = "image_path")
    public String getImagePath() {
        return imagePath;
    }
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }


    @Column(name = "categories")
    @Enumerated(value = EnumType.STRING) //apparently very inefficient with a larger db, should just store as ordinals/numbers
    @ElementCollection(targetClass = CategoryType.class, fetch = FetchType.EAGER)
    public List<CategoryType> getCategories() {
        return categories;
    }
    public void setCategories(List<CategoryType> categories) {
        this.categories = categories;
    }


    // TODO: change nullable back to fault -- so advert can be posted without a shop
    @ManyToOne
    @JoinColumn(name = "shop_id", nullable = true)
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


    @Column(name = "posted_time")
    public Timestamp getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Timestamp timeStamp) {
        this.timestamp = timeStamp;
    }


    @Column(name = "formatted_posted_time")
    public String getFormattedTimestamp() {
        String toCheckWhichDay = new SimpleDateFormat("dd").format(this.timestamp);
        if (toCheckWhichDay.endsWith("1")) {
            return this.formattedTimestamp = new SimpleDateFormat("dd'" + "st" + "' MMM, yyyy").format(this.timestamp);
        }
        else if (toCheckWhichDay.endsWith("2")) {
            return this.formattedTimestamp = new SimpleDateFormat("dd'" + "nd" + "' MMM, yyyy").format(this.timestamp);
        }
        else if (toCheckWhichDay.endsWith("3")) {
            return this.formattedTimestamp = new SimpleDateFormat("dd'" + "rd" + "' MMM, yyyy").format(this.timestamp);
        }
        else {
            return this.formattedTimestamp = new SimpleDateFormat("dd'" + "th" + "' MMM, yyyy").format(this.timestamp);

        }
    }
    public void setFormattedTimestamp(String formattedTimestamp) {
        this.formattedTimestamp = formattedTimestamp;
    }


    public boolean getDeleted() {
        return deleted;
    }
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public boolean hasCategory(CategoryType category) {
        return this.categories.contains(category);
    }


    public void sell() {
        this.categories.clear();
        this.categories.add(CategoryType.SOLD);
    }


    public void addCategoriesThatWereStrings(List<String> categoryValues) {
        for (String categoryValue : categoryValues) {
            this.categories.add(CategoryType.valueOf(categoryValue.toUpperCase()));
        }
    }
}




