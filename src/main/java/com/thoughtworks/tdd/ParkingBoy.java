package com.thoughtworks.tdd;

public class ParkingBoy {

    private ParkingLot parkingLot = new ParkingLot();

//    public ParkingLot getParkingLot() {
//        return parkingLot;
//    }
//
//    public void setParkingLot(ParkingLot parkingLot) {
//        this.parkingLot = parkingLot;
//    }

    public Ticket park(Car car) {
        return parkingLot.park(car);
    }

    public Car fetch(Ticket ticket) {
        return parkingLot.fetch(ticket);
    }
}
