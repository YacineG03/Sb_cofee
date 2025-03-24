package dam.uasz.sbcar2.domain;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstname;
    private String lastname;

    // @OneToMany par @ManyToMany
    @ManyToMany(mappedBy = "owners")
    private Set<Car> cars = new HashSet<>();

    public Owner() {
    }

    public Owner(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    // Getters
    public long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Set<Car> getCars() {
        return cars;
    }

    // Setters
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }

    // Méthode utilitaire pour ajouter une voiture
    public void addCar(Car car) {
        this.cars.add(car);
        car.getOwners().add(this);
    }
}