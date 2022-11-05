package com.nhnacademy.gw1.parking;

import lombok.Getter;
@Getter
public class Car {
    private String number;
    private User user;
    private String parkingId;

    public Car(String number, User user){
        this.number = number;
        this.user = user;
    }

    public void setParkingId(String parkingId) {
        this.parkingId = parkingId;
    }
}
