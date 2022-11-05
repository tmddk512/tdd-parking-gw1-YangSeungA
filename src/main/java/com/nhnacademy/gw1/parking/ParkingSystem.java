package com.nhnacademy.gw1.parking;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ParkingSystem {
    Map<Car, LocalDateTime> timeRecordTable = new HashMap<>();
    private PriceCalculator priceCalculator;
    public ParkingSystem(PriceCalculator priceCalculator) {
        priceCalculator = priceCalculator;
    }

    public void recordEntryTime(Car car) {
        timeRecordTable.put(car, LocalDateTime.now());
    }

    public long getPrice(Car car) {
        LocalDateTime endTime = LocalDateTime.now();
        long parkingPrice = priceCalculator.calculate(timeRecordTable.get(car), endTime);
        return parkingPrice;
    }
}
