package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    public void should_park_car_by_parking_boy() {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy boy = new ParkingBoy();
        boy.getParkingLotList().add(parkingLot);
        Ticket ticket = boy.park(car);
        Assertions.assertSame(car, boy.fetch(ticket));
    }

    @Test
    public void should_park_multiple_cars_by_parking_boy() {
        Car car = new Car();
        Car car1 = new Car();
        ParkingBoy boy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot();
        boy.getParkingLotList().add(parkingLot);
        Ticket ticket = boy.park(car);
        Ticket ticket1 = boy.park(car1);
        Assertions.assertSame(car1, boy.fetch(ticket1));
        Assertions.assertSame(car, boy.fetch(ticket));
    }

    @Test
    public void should_fetch_no_car_with_wrong_ticket_or_null_ticket() {
        ParkingBoy boy = new ParkingBoy();
        Ticket ticket = new Ticket();
        ParkingLot parkingLot = new ParkingLot();
        boy.getParkingLotList().add(parkingLot);
        ticket.setParkingLot(parkingLot);
        Assertions.assertSame(null, boy.fetch(ticket));
        Assertions.assertSame(null, boy.fetch(null));
    }

    @Test
    public void should_fetch_no_car_with_used_ticket() {
        ParkingBoy boy = new ParkingBoy();
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        boy.getParkingLotList().add(parkingLot);
        Ticket ticket = boy.park(car);
        ticket.setParkingLot(parkingLot);
        Assertions.assertSame(car, boy.fetch(ticket));
        Assertions.assertSame(null, boy.fetch(ticket));
    }

    @Test
    public void should_park_no_car_when_parking_lot_fulled() {
        ParkingBoy boy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot();
        boy.getParkingLotList().add(parkingLot);
        for (int i = 0; i < 10; i++) {
            Car car = new Car();
            boy.park(car);
        }
        Car car = new Car();
        Ticket ticket = boy.park(car);
        Assertions.assertSame(null, boy.park(car));
    }

    @Test
    public void should_get_wrong_msg_when_ticket_is_used_or_null() {
        ParkingBoy boy = new ParkingBoy();
        Car car = new Car();
        Ticket ticket = boy.park(car);
        boy.fetch(ticket);
        Assertions.assertSame("Unrecognized parking ticket.", boy.queryWrongMsg(ticket));
//        Assertions.assertSame("Unrecognized parking ticket.", boy.queryWrongMsg(null));
    }

//    @Test
//    public void should_get_wrong_msg_when_ticket_is_null() {
//        ParkingBoy boy = new ParkingBoy();
//        Car car = new Car();
//        Ticket ticket = boy.park(car);
//        boy.fetch(ticket);
//        Assertions.assertSame("Please provide your parking ticket.", boy.queryWrongMsg(null));
//    }
//
//    @Test
//    public void should_get_wrong_msg_when_parking_lot_is_fulled() {
//        ParkingBoy boy = new ParkingBoy();
//        for (int i = 0; i < 10; i++) {
//            Car car = new Car();
//            boy.park(car);
//        }
//        Car car = new Car();
//        Assertions.assertSame("Not enough position.", boy.park(car));
//    }

    @Test
    public void should_get_the_car_to_second_parking_lot_when_the_first_parking_lot_is_fulled() {
        ParkingBoy boy = new ParkingBoy();
        boy.getParkingLotList().add(new ParkingLot());
        ParkingLot parkingLot = new ParkingLot();
        boy.getParkingLotList().add(parkingLot);
        for (int i = 0; i < 10; i++) {
            Car car = new Car();
            boy.park(car);
        }
        Car car = new Car();
        Ticket ticket = boy.park(car);
        Assertions.assertSame(parkingLot, ticket.getParkingLot());
    }

    @Test
    public void should_park_the_car_by_smart_parking_boy() {
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
        ParkingBoy boy = new ParkingBoy();
        ParkingLot lessParkingLot = new ParkingLot();
        smartParkingBoy.getParkingLotList().add(lessParkingLot);
        boy.getParkingLotList().add(lessParkingLot);
        ParkingLot parkingLot = new ParkingLot();
        smartParkingBoy.getParkingLotList().add(parkingLot);
        boy.getParkingLotList().add(parkingLot);
        for (int i=0; i<4; i++){
            Car car = new Car();
            boy.park(car);
        }
        smartParkingBoy.getParkingLotList().add(parkingLot);
        Car car = new Car();
        Ticket ticket = smartParkingBoy.park(car);
        Assertions.assertSame(parkingLot, ticket.getParkingLot());
    }
}
