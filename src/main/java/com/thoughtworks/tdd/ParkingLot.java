package com.thoughtworks.tdd;

public class ParkingLot {

    public Ticket park(Car car) {
        Ticket ticket = new Ticket();
        ticket.setCar(car);
        return ticket;
    }

    public Car fetch(Ticket ticket) {
        Car car = ticket.getCar();
        ticket.setCar(null);
        return car;
    }
}
