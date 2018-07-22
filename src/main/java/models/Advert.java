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

    public Advert() {}

    public Advert(String title, String description, double price, String imagePath) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.imagePath = imagePath;
        this.categories = new ArrayList<>();
        // TODO: decide whether to get rid of this, probably redundant now
        this.timestamp = Timestamp.from(Instant.now());
        // TODO: add in 'th', 'rd' etc after day, will require some work in a new method
        this.formattedTimestamp = new SimpleDateFormat("dd MMM, yyyy").format(this.timestamp);
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
    @ElementCollection(targetClass = CategoryType.class)
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
        return this.formattedTimestamp;
    }
    public void setFormattedTimestamp(String formattedTimestamp) {
        this.formattedTimestamp = formattedTimestamp;
    }


    public boolean hasCategory(CategoryType category) {
        return this.categories.contains(category);
    }

    public void sell() {
        this.categories.add(CategoryType.SOLD);
    }
}




