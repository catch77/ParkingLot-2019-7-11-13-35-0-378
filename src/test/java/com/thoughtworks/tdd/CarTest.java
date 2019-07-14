package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    public void should_park_car_parking_boy() {
        Car car = new Car();
        ParkingBoy boy = new ParkingBoy();
        Ticket ticket = boy.park(car);
        Assertions.assertSame(car, boy.fetch(ticket));
    }
}
