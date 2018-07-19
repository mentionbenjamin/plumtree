package models;

import java.util.ArrayList;
import java.util.List;

public class Shop {

    private int id;
    private String name;
    private double wallet;
    private List<Advert> adverts;

    public Shop() {}

    public Shop(String name) {
        this.name = name;
        this.adverts = new ArrayList<Advert>();
        this.wallet = 0.0;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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


    public void addToAdverts(Advert advert) {
        this.adverts.add(advert);
    }
    public void removeFromAdverts(Advert advert) {
        this.adverts.remove(advert);
    }


    public void addToWallet(double money) {
        this.wallet += money;
    }

}
