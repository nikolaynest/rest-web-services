package com.nest.webservices.rest_web_services.pets;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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
    public ResponseEntity<EntityModel<Pet>> getPet(@PathVariable("id") int id) {
        Pet pet = petService.getById(id);
        EntityModel<Pet> entityModel = EntityModel.of(pet);

        WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAll());
        entityModel.add(link.withRel("all-pets"));

        return ResponseEntity.ok(entityModel);
    }

    @PostMapping(path = "/pets")
    public ResponseEntity<URI> createPet(@RequestBody @Valid Pet pet) {
        Pet savedPet = petService.create(pet);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedPet.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping
    public ResponseEntity<Pet> updatePet(@RequestBody @Valid Pet pet) {
        return ResponseEntity.ok(petService.update(pet));
    }

    @DeleteMapping(path = "/pets/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        petService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
