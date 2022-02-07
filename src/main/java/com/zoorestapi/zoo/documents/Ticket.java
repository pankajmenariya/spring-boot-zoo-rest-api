package com.zoorestapi.zoo.documents;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document

public class Ticket {
    @Id
    private int id;

    @NotNull(message = "Price can not be null")
    private String price;

    @NotNull(message = "date can not be null")
    private String date;

    private Date createdAt;
    private Date updatedAt;

    public Ticket(String price, String date, Date createdAt, Date updatedAt) {
        this.price = price;
        this.date = date;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Ticket() {
    }

    @Override
    public String toString() {
        return "Ticket [createdAt=" + createdAt + ", date=" + date + ", id=" + id + ", price=" + price + ", updatedAt="
                + updatedAt + "]";
    }

    public int getId() {
        return id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
