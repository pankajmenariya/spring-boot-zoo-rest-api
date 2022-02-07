package com.zoorestapi.zoo.exception;

public class TicketCollectionException extends Exception {

    public TicketCollectionException(String message) {
        super(message);
    }

    public String notFoundException(int id) {
        return "ticket with id " + id + " not found";
    }

    public static String ticketAlreadyExists() {
        return "tikcet with given date already exist";
    }
}
