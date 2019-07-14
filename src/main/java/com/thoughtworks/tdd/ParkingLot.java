package com.thoughtworks.tdd;

public class ParkingLot {

    private int capacity = 10;
    private int emptyPosition = 0;

    public Ticket park(Car car) {
        if (this.emptyPosition < this.capacity) {
            Ticket ticket = new Ticket();
            ticket.setCar(car);
            this.emptyPosition++;
            return ticket;
        } else {
            return null;
        }
    }

    public Car fetch(Ticket ticket) {
        Car car = ticket.getCar();
        ticket.setCar(null);
        this.emptyPosition--;
        return car;
    }
}
