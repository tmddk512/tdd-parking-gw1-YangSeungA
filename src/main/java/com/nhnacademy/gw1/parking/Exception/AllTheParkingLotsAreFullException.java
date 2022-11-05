package com.nhnacademy.gw1.parking.Exception;

public class AllTheParkingLotsAreFullException extends RuntimeException {
    public AllTheParkingLotsAreFullException(){
        super("Parking space does not exist");
    }
}
