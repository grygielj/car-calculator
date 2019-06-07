package com.spring.carculator.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="consumption")
public class Consumption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "rangeof")
    private float rangeof;

    @Column(name = "liters")
    private float liters;

    @Column(name = "costs")
    private float costs;

    @Column(name = "bill")
    private float bill;

    @Column(name = "price")
    private float price;

    @Column(name = "consumption")
    private float consumption;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name= "car_id")
    private Car car;


    public Consumption(float rangeof, float liters, float costs, float bill, float price, float consumption) {
        this.rangeof = rangeof;
        this.liters = liters;
        this.costs = costs;
        this.bill = bill;
        this.price = price;
        this.consumption = consumption;
    }
    public Consumption(){

    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getRangeof() {
        return rangeof;
    }

    public void setRangeof(float rangeof) {
        this.rangeof = rangeof;
    }

    public float getLiters() {
        return liters;
    }

    public void setLiters(float liters) {
        this.liters = liters;
    }

    public float getConsumption() {
        return consumption;
    }

    public void setConsumption(float consumption) {
        this.consumption = consumption;
    }

    public float getCosts() {
        return costs;
    }

    public void setCosts(float costs) {
        this.costs = costs;
    }


    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getBill() {
        return bill;
    }

    public void setBill(float bill) {
        this.bill = bill;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}


