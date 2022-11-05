package com.nhnacademy.gw1.parking;

import com.nhnacademy.gw1.parking.Exception.AllTheParkingLotsAreFullException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EntranceTest {
    ParkingLot parkingLot;

    PriceCalculator priceCalculator;
    Entrance entrance;
    Car car;

    @BeforeEach
    void setUp() {
        car = mock(Car.class);
        parkingLot = mock(ParkingLot.class);
        priceCalculator = mock(NhnPriceCalculator.class);
        entrance = new Entrance(parkingLot);
    }

    @Test
    @DisplayName("주차장이 꽉 차있으면 예외 발생")
    void scan_allParkingLotsFull_thenThrowAllTheParkingLotsAreFullException() {
        when(parkingLot.isFull()).thenReturn(true);

        assertThatThrownBy(() -> entrance.scan(car))
                .isInstanceOf(AllTheParkingLotsAreFullException.class)
                .hasMessage("Parking space does not exist");
    }

    @Test
    @DisplayName("scan(car)에서 recordEntryTime(car)이 호출되었는지 검사")
    void scan(){
        ParkingSystem parkingSystem = new ParkingSystem(priceCalculator);

        when(parkingLot.getParkingSystem()).thenReturn(parkingSystem);

        entrance.scan(car);
        verify(parkingLot, times(1)).getParkingSystem();
    }
}