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


}
