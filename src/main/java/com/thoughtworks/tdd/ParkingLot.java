package com.thoughtworks.tdd;

public class ParkingLot {

    private int capacity = 10;
    private int emptyPosition = 10;

    public Ticket park(Car car) {
        if (this.emptyPosition != 0) {
            Ticket ticket = new Ticket();
            ticket.setCar(car);
            this.emptyPosition--;
            return ticket;
        } else {
            return null;
        }
    }

    public Car fetch(Ticket ticket) {
        if (ticket == null) return null;
        Car car = ticket.getCar();
        ticket.setCar(null);
        this.emptyPosition++;
        return car;
    }

    public String queryWrongMsg(Ticket ticket) {
        if (ticket == null)
            return "Please provide your parking ticket.";
        if (ticket.getCar() == null){
            return "Unrecognized parking ticket.";
        }
        return null;
    }
}
