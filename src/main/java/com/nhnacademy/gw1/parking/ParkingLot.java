package com.nhnacademy.gw1.parking;

import com.nhnacademy.gw1.parking.Exception.ParkingSpaceIsNotEmptyException;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class ParkingLot {
    private final ParkingSystem parkingSystem;
    private Map<String, ParkingSpace> parkingSpaces;

    public ParkingLot(int size, PriceCalculator priceCalculator) {
        parkingSystem = new ParkingSystem(priceCalculator);
        parkingSpaces = new HashMap<>();
        for (int i = 0; i < size; i++) {
            String id = "A-" + (i + 1);
            parkingSpaces.put(id, null);
        }
    }

    public void parkingCar(String parkingId, Car car) {
        if (parkingSpaces.get(parkingId) != null) {
            throw new ParkingSpaceIsNotEmptyException(parkingId);
        }
        parkingSpaces.replace(parkingId, new ParkingSpace(car));
        car.setParkingId(parkingId);
    }

    public boolean isFull() {
        for (int i = 0; i < parkingSpaces.size(); i++) {
            if (parkingSpaces.get("A-"+(i+1)) == null)
                return false;
        }
        return true;
    }

    public void freeParkingSpace(Car car) {
        String parkingId = car.getParkingId();
        parkingSpaces.replace(parkingId, null);
    }
}
