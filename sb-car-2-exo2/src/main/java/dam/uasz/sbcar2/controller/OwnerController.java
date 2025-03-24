package dam.uasz.sbcar2.controller;

import dam.uasz.sbcar2.domain.Owner;
import dam.uasz.sbcar2.domain.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/owners")
public class OwnerController {

    @Autowired
    private OwnerRepository ownerRepository;

    @GetMapping
    public List<Owner> getAllOwners() {
        return (List<Owner>) ownerRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Owner> getOwnerById(@PathVariable Long id) {
        Optional<Owner> owner = ownerRepository.findById(id);
        return owner.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Owner createOwner(@RequestBody Owner owner) {
        return ownerRepository.save(owner);
    }

    @DeleteMapping("/{id}")
    public void deleteOwner(@PathVariable Long id) {
        ownerRepository.deleteById(id);
    }

    @GetMapping("/lastname/{lastname}")
    public List<Owner> getOwnersByLastname(@PathVariable String lastname) {
        return ownerRepository.findByLastname(lastname);
    }

    @GetMapping("/multiple-cars")
    public List<Owner> getOwnersWithMultipleCars() {
        return ownerRepository.findOwnersWithMultipleCars();
    }
}