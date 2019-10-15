package com.kkalletla.flowershop.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "shop")
public class Shop {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, length = 11, unique = true)
    private long id;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "address", nullable = false, length = 150)
    private String address;

    @Column(name = "open_time", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date openTime;

    @Column(name = "close_time", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date closeTime;

    @OneToMany(mappedBy = "shop", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    List<Manager> managers;

    @OneToMany(mappedBy = "shop", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    List<Flower> flowers;

    public Shop() {

    }

    public Shop(String name, String address, Date openTime, Date closeTime) {
        this.name = name;
        this.address = address;
        this.openTime = openTime;
        this.closeTime = closeTime;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    public List<Manager> getManagers() {
        return managers;
    }

    public void setManagers(List<Manager> managers) {
        this.managers = managers;
    }

    public List<Flower> getFlowers() {
        return flowers;
    }

    public void setFlowers(List<Flower> flowers) {
        this.flowers = flowers;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", openTime=" + openTime +
                ", closeTime=" + closeTime +
                '}';
    }

    public void addManager(Manager manager){
        if(managers == null)
            managers = new ArrayList<>();
        manager.setShop(this);
        managers.add(manager);
    }

    public void addFlower(Flower flower){
        if(flowers == null)
            flowers = new ArrayList<>();
        flower.setShop(this);
        flowers.add(flower);
    }
}
