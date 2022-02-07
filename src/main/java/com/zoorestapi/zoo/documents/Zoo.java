package com.zoorestapi.zoo.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class Zoo {
    @Id
    private int id;
    private String name;
    private String location;
    private String time;

    public Zoo() {
    }

    public Zoo(String name, String location, String time) {
        this.name = name;
        this.location = location;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Zoo [id=" + id + ", location=" + location + ", name=" + name + ", time=" + time + "]";
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
