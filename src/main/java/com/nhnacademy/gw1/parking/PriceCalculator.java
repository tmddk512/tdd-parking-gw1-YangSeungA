package com.nhnacademy.gw1.parking;

import java.time.LocalDateTime;

public interface PriceCalculator {
    long calculate(LocalDateTime startTime, LocalDateTime endTime);
}