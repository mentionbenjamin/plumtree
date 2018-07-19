package models;

import java.util.ArrayList;
import java.util.List;

public class Shop {

    private double wallet;
    private List<Advert> adverts;

//    public Shop() {}

    public Shop() {
        this.adverts = new ArrayList<Advert>();
        this.wallet = 0.0;
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    public List<Advert> getAdverts() {
        return adverts;
    }

    public void setAdverts(List<Advert> adverts) {
        this.adverts = adverts;
    }

    public void addToWallet(double money) {
        this.wallet += money;
    }

    public void addToAdverts(Advert advert) {
        this.adverts.add(advert);
    }
}
