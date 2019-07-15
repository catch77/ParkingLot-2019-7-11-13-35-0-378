package com.thoughtworks.tdd;

import java.util.List;

public class ServiceManager {

    private ParkingLot parkingLot;
    private List<ParkingBoy> parkingBoyList;


    public Ticket park(String car) throws ParkException {
        return parkingLot.park(car, parkingLot);
    }

    public String fetch(Ticket ticket) throws ParkException {
        if (ticket == null) return null;
        if (ticket.getParkingLot() == parkingLot)
            return parkingLot.fetch(ticket);
        return null;
    }

    public boolean askParkingWork(String car, ParkingBoy parkingBoy) throws ParkException {
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
