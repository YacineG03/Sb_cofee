package dam.uasz.sbcar2.domain;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String brand, model, color, registerNumber;
    private int years, price;

    // @ManyToOne par @ManyToMany
    @ManyToMany
    @JoinTable(
        name = "car_owner", // Nom de la table d'association
        joinColumns = @JoinColumn(name = "car_id"), // Colonne pour Car
        inverseJoinColumns = @JoinColumn(name = "owner_id") // Colonne pour Owner
    )
    private Set<Owner> owners = new HashSet<>();

    public Car() {
    }

    public Car(String brand, String model, String color, String registerNumber, int years, int price) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.registerNumber = registerNumber;
        this.years = years;
        this.price = price;
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

    public Set<Owner> getOwners() {
        return owners;
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

    public void setOwners(Set<Owner> owners) {
        this.owners = owners;
    }

    // Méthode utilitaire pour ajouter un propriétaire
    public void addOwner(Owner owner) {
        this.owners.add(owner);
        owner.getCars().add(this);
    }
}