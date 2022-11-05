package com.nhnacademy.gw1.parking;

import com.nhnacademy.gw1.parking.Exception.AllTheParkingLotsAreFullException;
import com.nhnacademy.gw1.parking.Exception.CustomerDoesNotHaveEnoughMoneyException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ExitTest {
    ParkingLot parkingLot;
    ParkingSystem parkingSystem;

    Car car;
    User user;
    Exit exit;

    @BeforeEach
    void setUp() {
        car = mock(Car.class);
        parkingLot = mock(ParkingLot.class);
        parkingSystem = mock(ParkingSystem.class);
        user = mock(User.class);
        exit = new Exit(parkingLot);
    }

    @Test
    @DisplayName("지불 후 고객의 돈이 제대로 정산되었는지 Test")
    void exit_succeessPay() {
        when(car.getUser()).thenReturn(user);
        when(user.getAmount()).thenReturn(8000L);
        when(parkingLot.getParkingSystem()).thenReturn(parkingSystem);
        long expected = 6000L;
        when(parkingSystem.getPrice(car)).thenReturn(expected);

        exit.pay(car);
        verify(user, times(1)).subtractAmount(expected);
    }

    @Test
    @DisplayName("사용자가 가진 돈이 주차요금보다 적을 때 에러 Test")
    void exit_userMoneyLessThanParkingPrice_thenCustomerDoesNotHaveEnoughMoneyException(){
        when(car.getUser()).thenReturn(user);
        when(user.getAmount()).thenReturn(5000L);
        when(parkingLot.getParkingSystem()).thenReturn(parkingSystem);
        when(parkingSystem.getPrice(car)).thenReturn(6000L);

        assertThatThrownBy(() -> exit.pay(car))
                .isInstanceOf(CustomerDoesNotHaveEnoughMoneyException.class)
                .hasMessage("The customer doesn't have enough money (Parking Fee: 6000, User Money: 5000");
    }
}