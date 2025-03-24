package dam.uasz.sbcar2.domain;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
    // Requête dérivée : Trouver un propriétaire par nom de famille
    List<Owner> findByLastname(String lastname);

    // Requête avec @Query : Trouver tous les propriétaires ayant plus d'une voiture
    @org.springframework.data.jpa.repository.Query("SELECT o FROM Owner o WHERE SIZE(o.cars) > 1")
    List<Owner> findOwnersWithMultipleCars();
}