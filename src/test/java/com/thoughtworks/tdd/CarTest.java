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
}
