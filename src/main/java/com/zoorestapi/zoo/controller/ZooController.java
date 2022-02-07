package com.zoorestapi.zoo.controller;

import java.util.List;

import com.zoorestapi.zoo.documents.Zoo;
import com.zoorestapi.zoo.services.ZooService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/zoo")
public class ZooController {
    @Autowired
    private ZooService zooService;

    @GetMapping()
    public List<Zoo> getListOfZoo() {
        return zooService.getListOfZoo();
    }

    @GetMapping("/{zooId}")
    public Zoo getZoo(@PathVariable int zooId) {
        return zooService.getZoo(zooId);
    }

    @PostMapping()
    public String setZoo(@RequestBody Zoo zoo) {
        return zooService.setZoo(zoo);
    }

    @PutMapping("/{zooId}")
    public String updateZoo(@PathVariable int zooId, @RequestBody Zoo zoo) {
        return zooService.updateZoo(zooId, zoo);
    }

    @DeleteMapping("/{zooId}")
    public String deleteZoo(@PathVariable int zooId) {
        return zooService.deleteZoo(zooId);
    }
}
