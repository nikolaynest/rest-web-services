package com.nest.webservices.rest_web_services.pets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class PetController {

    private final PetService petService;

    @Autowired
    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping(path = "/pets")
    public ResponseEntity<List<Pet>> getAll() {
        List<Pet> pets = petService.getAll();
        if (pets.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(pets);
    }

    @GetMapping(path = "/pets/{id}")
    public ResponseEntity<Pet> getPet(@PathVariable("id") int id) {
        return ResponseEntity.ok(petService.getById(id));
    }

    @PostMapping(path = "/pets")
    public ResponseEntity<URI> createPet(@RequestBody Pet pet) {
        Pet savedPet = petService.create(pet);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedPet.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping
    public ResponseEntity<Pet> updatePet(@RequestBody Pet pet) {
        return ResponseEntity.ok(petService.update(pet));
    }

    @DeleteMapping(path = "/pets/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        petService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
