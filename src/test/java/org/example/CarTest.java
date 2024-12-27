package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    private Car car;
    private Customer customer;
    private int days;

    @BeforeEach
    void setUp() {
        car = new Car(66739, "Toyota", "Corolla", 2018, 90.0, "Blue", "DC-2780-19", 4, true, true);
        customer = new Customer(33829, "John", "2024-12-26", "123 Fake Street", "0245123123", "johnd@gmail.com", "GHA_JSM3837_1");
        days = 5;
    }

    @Test
    void calculateRentalPrice() {
    double result = car.calculateRentalPrice(days);
    assertEquals(575, result);
    }

    @Test
    void isAvailableForRental() {
        boolean result = car.isAvailableForRental();
        assertTrue(result);
    }

    @Test
    void rent() {
        car.rent(customer, days);
        assertFalse(car.available, "Car should not be available after being rented.");
    }

    @Test
    void returnVehicle() {
        car.returnVehicle();
        assertTrue(car.available, "Car should be available after being returned.");
    }

    @Test
    void getNumberOfDoors() {
        int result = car.getNumberOfDoors();
        assertEquals(4, result);
    }

    @Test
    void hasAC() {
        boolean result = car.hasAC();
        assertTrue(result);
    }

    @Test
    void isAutomatic() {
        boolean result = car.isAutomatic();
        assertTrue(result);
    }
}