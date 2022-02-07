package com.zoorestapi.zoo.controller;

import java.util.List;

import javax.validation.ConstraintViolationException;

import com.zoorestapi.zoo.documents.Ticket;
import com.zoorestapi.zoo.exception.TicketCollectionException;
import com.zoorestapi.zoo.services.TicketService;

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
@RequestMapping("/tickets")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @GetMapping()
    public ResponseEntity<?> getTickets() {
        List<Ticket> tickets = ticketService.getTickets();
        if (tickets.size() > 0) {
            return new ResponseEntity<List<Ticket>>(tickets, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Tickets not available...come back letter", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{ticketId}")
    public Ticket getTicket(@PathVariable int ticketId) {
        return ticketService.getTicket(ticketId);
    }

    @PostMapping()
    public ResponseEntity<?> setTickets(@RequestBody Ticket ticket) {
        try {
            ticketService.setTickets(ticket);
            return new ResponseEntity<>("Ticket details with ticket id " + ticket.getId() + ", succesfully saved...",
                    HttpStatus.OK);
        } catch (ConstraintViolationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        } catch (TicketCollectionException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/{ticketId}")
    public ResponseEntity<?> updateTicket(@PathVariable int ticketId, @RequestBody Ticket ticket) {
        String updated = ticketService.updateTicket(ticketId, ticket);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{ticketId}")
    public String deleteTicket(@PathVariable int ticketId) {
        return ticketService.deleteTicket(ticketId);
    }

    @DeleteMapping()
    public String deleteAllTickets() {
        return ticketService.deleteAllTickets();
    }
}
