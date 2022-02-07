package com.zoorestapi.zoo.services;

import java.util.List;

import com.zoorestapi.zoo.documents.Zoo;
import com.zoorestapi.zoo.repository.ZooRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZooService {
    @Autowired
    private ZooRepository zooRepository;

    public List<Zoo> getListOfZoo() {
        return zooRepository.findAll();
    }

    public Zoo getZoo(int zooId) {
        return zooRepository.findById(zooId);
    }

    public String setZoo(Zoo zoo) {
        zooRepository.insert(zoo);
        return "Zoo details with zoo id " + zoo.getId() + ", succesfully saved...";
    }

    public String updateZoo(int zooId, Zoo zoo) {
        zooRepository.save(zoo);
        return "Zoo details with zoo id " + zooId + ", succesfully updated...";
    }

    public String deleteZoo(int zooId) {
        zooRepository.deleteById(zooId);
        return "Zoo details with zoo id " + zooId + ", succesfully deleted...";
    }

}
