package dam.uasz.sbcar2.domain;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface CarRepository extends CrudRepository<Car, Long> {
    // Requête dérivée : Trouver toutes les voitures par marque
    List<Car> findByBrand(String brand);

    // Requête dérivée : Trouver toutes les voitures par année
    List<Car> findByYears(int years);

    // Requête adaptée pour Many-to-Many : Trouver toutes les voitures associées à un propriétaire donné
    @org.springframework.data.jpa.repository.Query("SELECT c FROM Car c JOIN c.owners o WHERE o.id = :ownerId")
    List<Car> findByOwnerId(Long ownerId);
}