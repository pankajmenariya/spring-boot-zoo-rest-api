package com.zoorestapi.zoo.controller;

import java.util.List;
import java.util.Optional;

import com.mongodb.DuplicateKeyException;
import com.zoorestapi.zoo.documents.Animal;
import com.zoorestapi.zoo.services.AnimalService;

import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    // get the animals
    @GetMapping()
    public ResponseEntity<List<Animal>> getAnimals() {
        List<Animal> list = animalService.getAnimals();
        try {
            if (list.size() <= 0) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok().body(list);
    }

    // get single animal using id
    @GetMapping("/id/{animalId}")
    public ResponseEntity<Animal> getAnimalById(@PathVariable int animalId) {
        Animal animal = animalService.getAnimalById(animalId);
        try {
            if (animal == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (TypeMismatchException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok().body(animal);
    }

    // get single animal using name
    @GetMapping("/name/{animalName}")
    public ResponseEntity<Animal> getAnimalByName(@PathVariable String animalName) {
        Animal animal = animalService.getAnimalByName(animalName);
        if (animal == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(animal));
    }

    // add new animal
    @PostMapping()
    public ResponseEntity<Animal> addAnimal(@RequestBody Animal animal) {
        try {
            if (animal == null) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } catch (DuplicateKeyException e) {
            e.printStackTrace();
        }
        animal = animalService.addAnimal(animal);
        return ResponseEntity.ok().body(animal);
    }

    // delete an animal
    @DeleteMapping("/id/{animalId}")
    public ResponseEntity<Animal> deleteAnimal(@PathVariable int animalId) {
        Animal animal = animalService.getAnimalById(animalId);
        if (animal == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.ok().body(animal);
    }

    // updating the animal data
    @PutMapping("/id/{animalId}")
    public Animal updateAnimal(@RequestBody Animal animal, @PathVariable int animalId) {
        return animalService.updateAnimal(animal, animalId);
    }
}
