package com.nhnacademy.gw1.parking;

import com.nhnacademy.gw1.parking.Exception.CustomerDoesNotHaveEnoughMoneyException;

public class Exit {
    private final ParkingLot parkingLot;
    public Exit(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    //정산
    public void pay(Car car) {
        long parkingPrice = parkingLot.getParkingSystem().getPrice(car);
        long userMoney = car.getUser().getAmount();
        if(userMoney < parkingPrice) {
            throw new CustomerDoesNotHaveEnoughMoneyException(parkingPrice, userMoney);
        }
        car.getUser().subtractAmount(parkingPrice);
        parkingLot.freeParkingSpace(car);
    }

}
