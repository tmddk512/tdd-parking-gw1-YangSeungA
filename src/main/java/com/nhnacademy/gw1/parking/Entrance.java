package com.nhnacademy.gw1.parking;

import com.nhnacademy.gw1.parking.Exception.AllTheParkingLotsAreFullException;

public class Entrance {
    private final ParkingLot parkingLot;
    public Entrance(ParkingLot parkingLot){
        this.parkingLot = parkingLot;
    }

    public void scan(Car car){
        if(parkingLot.isFull()) {
            throw new AllTheParkingLotsAreFullException();
        }
        parkingLot.getParkingSystem().recordEntryTime(car);
    }
}
