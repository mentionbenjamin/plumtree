package models;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

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
    public void hasShop() {
        assertEquals(null, advert.getShop());
    }

    @Test
    public void canSetShop() {
        advert.setShop(shop);
        assertEquals(shop, advert.getShop());
    }


}
