package com.zoorestapi.zoo.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Animal {

    @Id
    private int id;
    private String name;
    private String type;
    private String description;

    public Animal(int id, String name, String type, String description) {
        super();
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
    }

    public Animal(String name, String type, String description) {
        super();
        this.name = name;
        this.type = type;
        this.description = description;
    }

    public Animal() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Animal [description=" + description + ", id=" + id + ", name=" + name + ", type=" + type + "]";
    }

}
