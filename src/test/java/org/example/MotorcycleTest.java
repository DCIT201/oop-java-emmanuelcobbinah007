package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MotorcycleTest {
    private Motorcycle motorcycle;
    private Customer customer;
    private int days;

    @BeforeEach
    void setUp() {
        motorcycle = new Motorcycle(71639, "Dugatti", "Diavel", 2020, 80.0, "Red", "ER-8023-21", "V-4 Engine");
        customer = new Customer(33829, "John", "2024-12-26", "123 Fake Street", "0245123123", "johnd@gmail.com", "GHA_JSM3837_1");
        days = 5;
    }

    @Test
    void getEngineType() {
        String result = motorcycle.getEngineType();
        assertEquals("V-4 Engine", result);
    }

    @Test
    void calculateRentalPrice() {
        double result = motorcycle.calculateRentalPrice(days);
        assertEquals(496, result);
    }

    @Test
    void isAvailableForRental() {
        boolean result = motorcycle.isAvailableForRental();
        assertEquals(true, result);
    }

    @Test
    void rent() {
        motorcycle.rent(customer, days);
        assertFalse(motorcycle.available, "Motorcycle should not be available after being rented.");
    }

    @Test
    void returnVehicle() {
        motorcycle.returnVehicle();
        assertTrue(motorcycle.available, "Motorcycle should be available after being returned.");
    }
}