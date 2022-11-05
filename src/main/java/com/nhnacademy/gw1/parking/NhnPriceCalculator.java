package com.nhnacademy.gw1.parking;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class NhnPriceCalculator implements PriceCalculator {

    public static final int MAXIMUM_PRICE_PER_DAY = 10000;
    public static final int TEN_MINUTES_TO_SECONDS = 600;
    public static final int ADDITIONAL_PRICE_PER_TEN_MINUTES = 500;
    private static final int THIRTY_MINUTES_TO_SECONDS = 1800;
    private static final int THIRTY_MINUTES_BASIC_PRICE = 1000;

    public long calculate(LocalDateTime startTime, LocalDateTime endTime) {
        int startDay = startTime.getDayOfMonth();
        int endDay = startTime.getDayOfMonth();
        if(endDay -  startDay > 0) {
            return MAXIMUM_PRICE_PER_DAY * (endDay - startDay);
        }
        long elapsedSeconds = ChronoUnit.SECONDS.between(startTime, endTime);
        if(elapsedSeconds <= THIRTY_MINUTES_TO_SECONDS) {
            return THIRTY_MINUTES_BASIC_PRICE;
        }
        if(elapsedSeconds >= 12600) {
            return MAXIMUM_PRICE_PER_DAY;
        }
        return THIRTY_MINUTES_BASIC_PRICE
                + (((elapsedSeconds-THIRTY_MINUTES_TO_SECONDS)/TEN_MINUTES_TO_SECONDS)*ADDITIONAL_PRICE_PER_TEN_MINUTES);
    }
}
