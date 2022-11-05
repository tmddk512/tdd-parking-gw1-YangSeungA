package com.nhnacademy.gw1.parking;

public class User {
    private long amount;
    public User(long amount){
        this.amount = amount;
    }

    public long getAmount() {
        return amount;
    }

    public void subtractAmount(long parkingPrice) {
        this.amount -= parkingPrice;
    }
}
