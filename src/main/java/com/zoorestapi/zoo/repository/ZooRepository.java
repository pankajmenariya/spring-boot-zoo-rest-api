package com.zoorestapi.zoo.repository;

import com.zoorestapi.zoo.documents.Zoo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ZooRepository extends MongoRepository<Zoo, Integer> {
    public Zoo findById(int zooId);
}
