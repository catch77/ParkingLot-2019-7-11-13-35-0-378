package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private int capacity = 10;
    private int emptyPosition = capacity;
    private double emptyRate = emptyPosition / capacity;

    public double getEmptyRate() {
        return emptyRate;
    }

    public void setEmptyRate(double emptyRate) {
        this.emptyRate = emptyRate;
    }

    public int getEmptyPosition() {
        return emptyPosition;
    }

    public void setEmptyPosition(int emptyPosition) {
        this.emptyPosition = emptyPosition;
    }

    private String wrongMsg;
    private List<String> carList = new ArrayList<>();

    public ParkingLot(int capacity, int emptyPosition, String wrongMsg, List<String> carList) {
        this.capacity = capacity;
        this.emptyPosition = emptyPosition;
        this.wrongMsg = wrongMsg;
        this.carList = carList;
    }

    public ParkingLot() {
    }

    public List<String> getCarList() {
        return carList;
    }

    public void setCarList(List<String> carList) {
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

    public Ticket park(String car, ParkingLot parkingLot) throws ParkException {
        if (this.emptyPosition != 0) {
            carList.add(car);
            Ticket ticket = new Ticket();
            ticket.setCarId(car);
            this.emptyPosition--;
            ticket.setParkingLot(parkingLot);
            return ticket;
        } else {
            wrongMsg = "Not enough position.";
            throw new ParkException(wrongMsg);
        }
    }

    public String fetch(Ticket ticket) throws ParkException {
        if (ticket == null)
            throw new ParkException("Please provide your parking ticket.");
        String car = ticket.getCarId();
        if (car != null) {
            ticket.setCarId(null);
            ticket.getParkingLot().getCarList().remove(car);
            this.emptyPosition++;
        } else {
            throw new ParkException("Unrecognized parking ticket.");
        }
        return car;
    }

}
