package com.zoorestapi.zoo.services;

import java.util.List;

import com.zoorestapi.zoo.documents.Animal;
import com.zoorestapi.zoo.repository.AnimalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    // get all animals
    public List<Animal> getAnimals() {
        return animalRepository.findAll();
    }

    // get single animal by id
    public Animal getAnimalById(int animalId) {
        return animalRepository.findById(animalId);
    }

    // get single animal by name
    public Animal getAnimalByName(String animalName) {
        return animalRepository.findByName(animalName);
    }

    public Animal findByName(String animalName) {
        List<Animal> list = animalRepository.findAll();
        Animal result = null;
        for (Animal animal : list) {
            if (animal.getName().equals(animalName)) {
                result = animal;
                break;
            }
        }
        return result;
    }

    // adding new animal
    public Animal addAnimal(Animal animal) {
        animalRepository.save(animal);
        return animal;
    }

    // deleting an animal
    public Animal deleteAnimal(int animalId) {
        Animal animal = animalRepository.findById(animalId);
        animalRepository.delete(animal);
        return animal;
    }

    // updating the animal data
    public Animal updateAnimal(Animal animal, int animalId) {
        Animal oldAnimal = animalRepository.findById(animalId);

        oldAnimal.setName(animal.getName());
        oldAnimal.setType(animal.getType());
        oldAnimal.setDescription(animal.getDescription());

        animalRepository.save(oldAnimal);
        return oldAnimal;
    }
}
