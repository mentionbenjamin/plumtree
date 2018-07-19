package models;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class AdvertTest {

    Advert advert;
    Shop shop;

    @Before
    public void setup() {
        this.advert = new Advert("Bike", "Very fast bike", 100.00, "/image/bike", CategoryType.TRANSPORT);
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
    public void hasPrice() {
        assertEquals(100.00, advert.getPrice(), 0.001);
    }

    @Test
    public void hasImagePath() {
        assertEquals("/image/bike", advert.getImagePath());
    }

    @Test
    public void hasCategory() {
        assertEquals(CategoryType.TRANSPORT, advert.getCategory());
    }

    @Test
    public void hasShop() {
        assertEquals(null, advert.getShop());
    }



}
