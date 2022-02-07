package com.zoorestapi.zoo.repository;

import com.zoorestapi.zoo.documents.Animal;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AnimalRepository extends MongoRepository<Animal, Integer> {

    public Animal findById(int animalId);

    public Animal findByName(String animalName);
}
