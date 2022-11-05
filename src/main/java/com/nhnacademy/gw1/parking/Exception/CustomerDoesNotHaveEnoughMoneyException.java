package com.nhnacademy.gw1.parking.Exception;

public class CustomerDoesNotHaveEnoughMoneyException extends RuntimeException {
    public CustomerDoesNotHaveEnoughMoneyException(long parkingFee, long userMoney) {
        super("The customer doesn't have enough money (Parking Fee: " + parkingFee + ", User Money: "+ userMoney);
    }
}
