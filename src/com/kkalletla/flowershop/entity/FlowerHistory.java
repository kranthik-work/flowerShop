package com.kkalletla.flowershop.entity;

import javax.persistence.*;


@Entity
@Table(name = "flower_History")
public class FlowerHistory {

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

    @Column(name = "week_id", nullable = false, length = 11)
    private long weekId;

    public FlowerHistory() {

    }

    public FlowerHistory(String name, long rate, long quantity, long weekId) {
        this.name = name;
        this.rate = rate;
        this.quantity = quantity;
        this.weekId = weekId;
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

    public long getWeekId() {
        return weekId;
    }

    public void setWeekId(long weekId) {
        this.weekId = weekId;
    }

    @Override
    public String toString() {
        return "FlowerHistory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rate=" + rate +
                ", quantity=" + quantity +
                ", weekId=" + weekId +
                '}';
    }
}
