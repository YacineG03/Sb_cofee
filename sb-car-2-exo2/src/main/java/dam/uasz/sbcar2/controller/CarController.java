package dam.uasz.sbcar2.controller;

import dam.uasz.sbcar2.domain.Car;
import dam.uasz.sbcar2.domain.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @GetMapping
    public List<Car> getAllCars() {
        return (List<Car>) carRepository.findAll();
    }

    @GetMapping("/api/cars/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {
        Optional<Car> car = carRepository.findById(id);
        return car.map(ResponseEntity::ok)
                  .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Car createCar(@RequestBody Car car) {
        return carRepository.save(car);
    }

    @DeleteMapping("/api/cars/{id}")
    public void deleteCar(@PathVariable Long id) {
        carRepository.deleteById(id);
    }

    @GetMapping("/api/cars/brand/{brand}")
    public List<Car> getCarsByBrand(@PathVariable String brand) {
        return carRepository.findByBrand(brand);
    }

    @GetMapping("/api/cars/years/{years}")
    public List<Car> getCarsByYears(@PathVariable int years) {
        return carRepository.findByYears(years);
    }

    @GetMapping("/api/cars/owner/{ownerId}")
    public List<Car> getCarsByOwnerId(@PathVariable Long ownerId) {
        return carRepository.findByOwnerId(ownerId);
    }
}