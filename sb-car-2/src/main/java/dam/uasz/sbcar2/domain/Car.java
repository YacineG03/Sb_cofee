package dam.uasz.sbcar2.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.FetchType;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String brand, model, color, registerNumber;
    private int years, price;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)  
    private Owner owner;

    public Car() {
    }

    public Car(String brand, String model, String color, String registerNumber, int years, int price, Owner owner) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.registerNumber = registerNumber;
        this.years = years;
        this.price = price;
        this.owner = owner;
    }

    // Getters
    public long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public int getYears() {
        return years;
    }

    public int getPrice() {
        return price;
    }

    public String getModel() {
        return model;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public Owner getOwner() {
        return owner;
    }

    // Setters
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}