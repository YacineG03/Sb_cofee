package dam.uasz;

import dam.uasz.sbcar2.domain.Car;
import dam.uasz.sbcar2.domain.CarRepository;
import dam.uasz.sbcar2.domain.Owner;
import dam.uasz.sbcar2.domain.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SbCar2Application implements CommandLineRunner {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    public static void main(String[] args) {
        SpringApplication.run(SbCar2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Créer des propriétaires
        Owner owner1 = new Owner("John", "Johnson");
        Owner owner2 = new Owner("Mary", "Robinson");
        ownerRepository.save(owner1);
        ownerRepository.save(owner2);

        // Créer des voitures associées aux propriétaires
        carRepository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2021, 59000, owner1));
        carRepository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2019, 29000, owner2));
        carRepository.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 2020, 39000, owner2));
    }
}