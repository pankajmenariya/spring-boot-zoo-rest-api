package com.zoorestapi.zoo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import com.zoorestapi.zoo.documents.Ticket;
import com.zoorestapi.zoo.exception.TicketCollectionException;
import com.zoorestapi.zoo.repository.TicketRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    public List<Ticket> getTickets() {
        List<Ticket> list = ticketRepository.findAll();
        return list;
    }

    public Ticket getTicket(int ticketId) {
        return ticketRepository.findById(ticketId);
    }

    public void setTickets(Ticket ticket) throws ConstraintViolationException, TicketCollectionException {
        Optional<Ticket> ticketOptional = ticketRepository.findByDate(ticket.getDate());
        if (ticketOptional.isPresent()) {
            throw new TicketCollectionException(TicketCollectionException.ticketAlreadyExists());
        } else {
            ticket.setCreatedAt(new Date(System.currentTimeMillis()));
            ticket.setUpdatedAt(new Date());
            ticketRepository.insert(ticket);
        }
    }

    public String updateTicket(int ticketId, Ticket ticket) {
        Ticket oldTicket = ticketRepository.findById(ticketId);
        oldTicket.setPrice(ticket.getPrice());
        oldTicket.setDate(ticket.getDate());
        oldTicket.setUpdatedAt(new Date());
        ticketRepository.save(oldTicket);
        return "Ticket details with ticket id " + ticketId + ", succesfully updated...";
    }

    public String deleteTicket(int ticketId) {
        ticketRepository.deleteById(ticketId);
        return "Ticket details with ticket id " + ticketId + ", succesfully deleted...";
    }

    public String deleteAllTickets() {
        ticketRepository.deleteAll();
        return "All Ticket details succesfully deleted...";
    }

}
