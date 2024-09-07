package com.nest.webservices.rest_web_services.pets;

import com.nest.webservices.rest_web_services.exceptions.PetFriendNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PetService {

    List<Pet> pets = new ArrayList<>();
    int count = 1;


    public Pet create(Pet pet) {
        Pet created = Pet.builder().id(count++).name(pet.getName()).birthDate(pet.getBirthDate()).build();
        pets.add(created);
        return created;
    }

    public Pet update(Pet pet) {
        return pet;
    }

    public Pet getById(int id) {
        return pets.stream()
                .filter(pet -> pet.getId() == id)
                .findFirst()
                .orElseThrow(() -> new PetFriendNotFoundException(String.format("Pet doesn't exist with id %s", id)));
    }

    public void deleteById(int id) {
        pets.removeIf(pet -> pet.getId() == id);
    }

    public List<Pet> getAll() {
        return pets;
    }
}
