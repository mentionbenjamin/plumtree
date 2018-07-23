package models;

import com.sun.tools.corba.se.idl.constExpr.Times;
import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class AdvertTest {

    Advert advert;
    Shop shop;

    @Before
    public void setup() {
        this.advert = new Advert("Bike", "Very fast bike", 100.00, "/image/bike");
        this.shop = new Shop();
    }

    @Test
    public void hasId() {
        assertEquals(0, advert.getId());
    }

    @Test
    public void canSetId() {
        advert.setId(5);
        assertEquals(5, advert.getId());
    }

    @Test
    public void hasTitle() {
        assertEquals("Bike", advert.getTitle());
    }

    @Test
    public void canSetTitle() {
        advert.setTitle("Cinelli");
        assertEquals("Cinelli", advert.getTitle());
    }

    @Test
    public void hasDescription() {
        assertEquals("Very fast bike", advert.getDescription());
    }

    @Test
    public void canSetDescription() {
        advert.setDescription("More bike info");
        assertEquals("More bike info", advert.getDescription());
    }

    @Test
    public void hasPrice() {
        assertEquals(100.00, advert.getPrice(), 0.001);
    }

    @Test
    public void canSetPrice() {
        advert.setPrice(150.00);
        assertEquals(150.00, advert.getPrice());
    }

    @Test
    public void hasImagePath() {
        assertEquals("/image/bike", advert.getImagePath());
    }

    @Test
    public void canSetImagePath() {
        advert.setImagePath("/bananas");
        assertEquals("/bananas", advert.getImagePath());
    }

    @Test
    public void hasCategories() {
        assertEquals(0, advert.getCategories().size());
    }

    @Test
    public void canSetCategories() {
        ArrayList<CategoryType> testCategories = new ArrayList<CategoryType>();
        testCategories.add(CategoryType.TECHNOLOGY);
        advert.setCategories(testCategories);
        assertEquals(1, advert.getCategories().size());
    }

    @Test
    public void canAddCategoryToCategories(){
        advert.addCategory(CategoryType.FASHION);
        assertEquals(1, advert.getCategories().size());
    }

    @Test
    public void canRemoveCategoryFromCategories(){
        advert.addCategory(CategoryType.FASHION);
        advert.removeCategory(CategoryType.FASHION);
        assertEquals(0, advert.getCategories().size());
    }

    @Test
    public void hasShop() {
        assertEquals(null, advert.getShop());
    }

    @Test
    public void canSetShop() {
        advert.setShop(shop);
        assertEquals(shop, advert.getShop());
    }

    @Test
    public void hasTimestamp() {
        //had to regenerate the advert here to save time
        advert = new Advert("Bike", "Very fast bike", 100.00, "/image/bike");
        assertEquals(Timestamp.from(Instant.now()), advert.getTimestamp());
    }

    @Test
    public void timestampCanBeFormatted() {
        advert = new Advert("Bike", "Very fast bike", 100.00, "/image/bike");
        Timestamp timeNow = advert.getTimestamp();

        String formattedTime = new SimpleDateFormat("dd.MM.yyyy").format(timeNow);

        //this test will be wrong tomorrow!
        assertEquals("21.07.2018", formattedTime);
    }

    @Test
    public void timestampCanBeFormattedWithinModel() {
        advert = new Advert("Bike", "Very fast bike", 100.00, "/image/bike");
        assertEquals("21 Jul, 2018", advert.getFormattedTimestamp());
    }

    @Test
    public void hasASpecificCategoryWithinCategoriesList() {
        List<CategoryType> categories = advert.getCategories();
        categories.add(CategoryType.GARDEN);
        assertEquals(true, categories.contains(CategoryType.GARDEN));
    }

    @Test
    public void doesNotHaveASpecificCategoryWithinCategoriesList() {
        assertEquals(false, advert.getCategories().contains(CategoryType.GARDEN));
    }

    @Test
    public void canCheckWhatCategoriesContains() {
        advert.addCategory(CategoryType.FASHION);
        assertEquals(true, advert.hasCategory(CategoryType.FASHION));
        assertEquals(false, advert.hasCategory(CategoryType.TECHNOLOGY));
    }

    @Test
    public void canSellAdvert() {
        advert.sell();
        assertEquals(true, advert.hasCategory(CategoryType.SOLD));
    }

    @Test
    public void hasDeletedBoolean() {
        assertEquals(false, advert.getDeleted());
    }

}
