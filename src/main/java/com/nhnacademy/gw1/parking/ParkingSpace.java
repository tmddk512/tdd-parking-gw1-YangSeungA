package com.nhnacademy.gw1.parking;

import lombok.Getter;

@Getter
public class ParkingSpace {
    private final Car car;
    public ParkingSpace(Car car) {
        this.car = car;
    }
}
