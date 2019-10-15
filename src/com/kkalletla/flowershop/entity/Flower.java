package com.kkalletla.flowershop.entity;

import javax.persistence.*;


@Entity
@Table(name = "flower")
public class Flower {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, length = 11, unique = true)
    private long id;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "rate", nullable = false, length = 11)
    private long rate;

    @Column(name = "quantity", nullable = false, length = 11)
    private long quantity;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "shop_id")
    private Shop shop;

    public Flower() {

    }

    public Flower(String name, long rate, long quantity) {
        this.name = name;
        this.rate = rate;
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getRate() {
        return rate;
    }

    public void setRate(long rate) {
        this.rate = rate;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rate=" + rate +
                ", quantity=" + quantity +
                '}';
    }
}
