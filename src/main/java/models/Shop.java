package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "shops")
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


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


    @Column(name = "name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    @Column(name = "wallet")
    public double getWallet() {
        return wallet;
    }
    public void setWallet(double wallet) {
        this.wallet = wallet;
    }


    @OneToMany(mappedBy = "shop", fetch = FetchType.LAZY)
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
