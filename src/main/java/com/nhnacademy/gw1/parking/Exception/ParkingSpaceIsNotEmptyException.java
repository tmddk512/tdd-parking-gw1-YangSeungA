package com.nhnacademy.gw1.parking.Exception;

public class ParkingSpaceIsNotEmptyException extends RuntimeException {
    public ParkingSpaceIsNotEmptyException(String parkingId) {
        super("Parking space is not empty : " + parkingId);
    }
}
