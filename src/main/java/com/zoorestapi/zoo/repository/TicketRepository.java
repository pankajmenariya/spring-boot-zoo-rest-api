package com.zoorestapi.zoo.repository;

import java.util.Optional;

import javax.validation.ConstraintViolationException;

import com.zoorestapi.zoo.documents.Ticket;
import com.zoorestapi.zoo.exception.TicketCollectionException;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface TicketRepository extends MongoRepository<Ticket, Integer> {
    public Ticket findById(int ticketid);

    @Query("{'ticket': ?0}")
    Optional<Ticket> findByDate(String date) throws ConstraintViolationException, TicketCollectionException;
}
