package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private int capacity = 10;
    private int emptyPosition = capacity;

    public int getEmptyPosition() {
        return emptyPosition;
    }

    public void setEmptyPosition(int emptyPosition) {
        this.emptyPosition = emptyPosition;
    }

    private String wrongMsg;
    private List<Car> carList = new ArrayList<>();

    public ParkingLot(int capacity, int emptyPosition, String wrongMsg, List<Car> carList) {
        this.capacity = capacity;
        this.emptyPosition = emptyPosition;
        this.wrongMsg = wrongMsg;
        this.carList = carList;
    }

    public ParkingLot() {
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }

    public String getWrongMsg() {
        return wrongMsg;
    }

    public void setWrongMsg(String wrongMsg) {
        this.wrongMsg = wrongMsg;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Ticket park(Car car, ParkingLot parkingLot) {
        if (this.emptyPosition != 0) {
            carList.add(car);
            Ticket ticket = new Ticket();
            ticket.setCar(car);
            this.emptyPosition--;
            ticket.setParkingLot(parkingLot);
            return ticket;
        } else {
            wrongMsg = "Not enough position.";
            return null;
        }
    }

    public Car fetch(Ticket ticket) {
        if (ticket == null) return null;
        Car car = ticket.getCar();
        if (car != null) {
            ticket.setCar(null);
            ticket.getParkingLot().getCarList().remove(car);
            this.emptyPosition++;
        }
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
