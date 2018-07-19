package models;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ShopTest {

    Shop shop;

    @Before
    public void setup() {
        this.shop = new Shop();
    }

    @Test
    public void hasWallet() {
        assertEquals(0.0, shop.getWallet(), 0.001);
    }



}
