package com.nhnacademy.gw1.parking;

import com.nhnacademy.gw1.parking.Exception.ParkingSpaceIsNotEmptyException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

class ParkingLotTest {
    Car car;
    ParkingLot parkingLot;
    ParkingSpace parkingSpace;
    PriceCalculator priceCalculator;

    @BeforeEach
    void setUp() {
        car = mock(Car.class);
        priceCalculator = mock(NhnPriceCalculator.class);
        parkingLot = new ParkingLot(10, priceCalculator);
        parkingSpace = new ParkingSpace(car);
    }

    @Test
    @DisplayName("이미 주차된 자리에 새로운 차가 주차를 시도할 때 나오는 에러")
    void scan_AllParkingLotsFull_thenThrowAllTheParkingLotsAreFullException() throws NoSuchFieldException, IllegalAccessException {
        String parkingId = "A-1";
        parkingLot.parkingCar(parkingId, car);

        assertThatThrownBy(() -> parkingLot.parkingCar(parkingId, car))
                .isInstanceOf(ParkingSpaceIsNotEmptyException.class)
                .hasMessageContaining("Parking space is not empty : ", parkingId);
    }

    @Test
    @DisplayName("주차했을 때 그 자리에 차가 제대로 들어갔는지 Test")
    void parkingCar() {
        String parkingId = "A-2";
        parkingLot.parkingCar(parkingId, car);

        assertThat(parkingLot.getParkingSpaces().get(parkingId).getCar()).isEqualTo(car);
    }

    @Test
    @DisplayName("주차 공간이 가득 차 있을 때 Test")
    void parkingSpaceIsFull_trueTest() {
        for(int i = 0; i<10; i++) {
            parkingLot.parkingCar("A-"+(i+1), car);
        }
        assertThat(parkingLot.isFull()).isTrue();
    }

    @Test
    @DisplayName("주차장에 빈 공간이 있을 때 Test")
    void parkingSpaceIsFull_falseTest() {
        assertThat(parkingLot.isFull()).isEqualTo(false);
    }
}