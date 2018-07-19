package models;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class ShopTest {

    Shop shop;
    List<Advert> advertsTest;
    Advert advert;

    @Before
    public void setup() {
        this.shop = new Shop("Plumtree");
        this.advertsTest = new ArrayList<Advert>();
        this.advert = new Advert("Bike", "Very fast bike", 100.00, "/image/bike");
    }

    @Test
    public void hasId() {
        assertEquals(0, shop.getId());
    }

    @Test
    public void canSetId() {
        shop.setId(5);
        assertEquals(5, shop.getId());
    }

    @Test
    public void hasName() {
        assertEquals("Plumtree", shop.getName());
    }

    @Test
    public void canSetName() {
        shop.setName("Gumbush");
        assertEquals("Gumbush", shop.getName());
    }

    @Test
    public void hasWallet() {
        assertEquals(0.0, shop.getWallet(), 0.001);
    }

    @Test
    public void canSetWallet() {
        shop.setWallet(10.00);
        assertEquals(10.00, shop.getWallet(), 0.001);
    }

    @Test
    public void hasAdverts() {
        assertEquals(0, shop.getAdverts().size());
    }

    @Test
    public void canSetAdverts() {
        shop.setAdverts(advertsTest);
        assertEquals(advertsTest, shop.getAdverts());
    }

    @Test
    public void canAddToAdvertsList() {
        shop.addToAdverts(advert);
        assertEquals(1, shop.getAdverts().size());
    }

    @Test
    public void canRemoveFromAdvertsList() {
        shop.addToAdverts(advert);
        shop.removeFromAdverts(advert);
        assertEquals(0, shop.getAdverts().size());
    }

    @Test
    public void canAddToWallet() {
        shop.addToWallet(9.00);
        assertEquals(9.00, shop.getWallet(), 0.001);
    }

}
