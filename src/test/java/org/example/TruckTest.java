package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TruckTest {
    private Truck truck;
    private Customer customer;
    private int days;

    @BeforeEach
    void setUp() {
        truck = new Truck(46689, "Scania", "P-100", 2009, 200.0, "Grey", "BD-9106-05", 500.5);
        customer = new Customer(33829, "John", "2024-12-26", "123 Fake Street", "0245123123", "johnd@gmail.com", "GHA_JSM3837_1");
        days = 5;
    }


    @Test
    void getCargoCapacity() {
        double result = truck.getCargoCapacity();
        assertEquals(500.5, result);
    }

    @Test
    void calculateRentalPrice() {
        double result = truck.calculateRentalPrice(days);
        assertEquals(1500, result);
    }

    @Test
    void isAvailableForRental() {
        boolean result = truck.isAvailableForRental();
        assertTrue(result);
    }

    @Test
    void rent() {
        truck.rent(customer, days);
        assertFalse(truck.available, "Truck should not be available after being rented.");
    }

    @Test
    void returnVehicle() {
        truck.returnVehicle();
        assertTrue(truck.available, "Truck should be available after being returned.");
    }
}