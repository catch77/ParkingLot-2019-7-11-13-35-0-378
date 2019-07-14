package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    public void should_park_car_by_parking_boy() {
        Car car = new Car();
        ParkingBoy boy = new ParkingBoy();
        Ticket ticket = boy.park(car);
        Assertions.assertSame(car, boy.fetch(ticket));
    }

    @Test
    public void should_park_multiple_cars_by_parking_boy() {
        Car car = new Car();
        Car car1 = new Car();
        ParkingBoy boy = new ParkingBoy();
        Ticket ticket = boy.park(car);
        Ticket ticket1 = boy.park(car1);
        Assertions.assertSame(car1, boy.fetch(ticket1));
        Assertions.assertSame(car, boy.fetch(ticket));
    }

    @Test
    public void should_fetch_no_car_with_wrong_ticket_or_null_ticket() {
        ParkingBoy boy = new ParkingBoy();
        Ticket ticket = new Ticket();
        Assertions.assertSame(null, boy.fetch(ticket));
        Assertions.assertSame(null, boy.fetch());
    }
}
