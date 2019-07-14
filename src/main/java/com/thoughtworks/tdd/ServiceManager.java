package com.thoughtworks.tdd;

import java.util.List;

public class ServiceManager {

    private ParkingLot parkingLot;
    private List<ParkingBoy> parkingBoyList;


    public Ticket park(Car car) {
        return parkingLot.park(car, parkingLot);
    }

    public Car fetch(Ticket ticket) {
        if (ticket == null) return null;
        if (ticket.getParkingLot() == parkingLot)
            return parkingLot.fetch(ticket);
        return null;
    }

    public boolean askParkingWork(Car car, ParkingBoy parkingBoy) {
        if (parkingBoy.park(car) != null) {
            return true;
        }
        return false;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public List<ParkingBoy> getParkingBoyList() {
        return parkingBoyList;
    }

    public void setParkingBoyList(List<ParkingBoy> parkingBoyList) {
        this.parkingBoyList = parkingBoyList;
    }


}
