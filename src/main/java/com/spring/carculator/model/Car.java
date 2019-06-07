package com.spring.carculator.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="marque")
    private String marque;

    @Column(name = "model")
    private String model;

    @Column(name = "petrol")
    private String petrol;

    @Column(name = "horsepower")
    private float horsepower;

    @Column(name = "consumption")
    private float consumption;

    @Column(name= "cost")
    private float cost;

    @OneToMany(mappedBy="car",cascade = CascadeType.ALL )
    private List<Consumption> consumptions;



    public void add(Consumption consumption){
        if(consumption == null){
            consumptions = new ArrayList<>();
        }
        consumptions.add(consumption);
    }


    public long getIdListConsumptions(){
        return getId();
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPetrol() {
        return petrol;
    }

    public void setPetrol(String petrol) {
        this.petrol = petrol;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public float getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(float horsepower) {
        this.horsepower = horsepower;
    }

    public float getConsumption() {
        return consumption;
    }

    public void setConsumption(float consumption) {
        this.consumption = consumption;
    }

    public List<Consumption> getConsumptions() {
        return consumptions;
    }

    public void setConsumptions(List<Consumption> consumptions) {
        this.consumptions = consumptions;
    }
}
