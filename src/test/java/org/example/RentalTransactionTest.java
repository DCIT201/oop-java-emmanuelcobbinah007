package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class RentalTransactionTest {
    Customer customer;
    Car car;
    int days;
    RentalTransaction result;

    @BeforeEach
    void setUp() {
        customer = new Customer(33829, "John", "2024-12-26", "123 Fake Street", "0245123123", "johnd@gmail.com", "GHA_JSM3837_1");
        car = new Car(66739, "Toyota", "Corolla", 2018, 90.0, "Blue", "DC-2780-19", 4, true, true);
        days = 5;

        result = new RentalTransaction(customer, car, days);
    }

    @Test
    void getCustomer() {
        assertEquals(customer, result.getCustomer());

    }

    @Test
    void getVehicle() {
        assertEquals(car, result.getVehicle());
    }

    @Test
    void getRentalDays() {
        assertEquals(days, result.getRentalDays());
    }

    @Test
    void getTotalCost() {
        assertEquals(525, car.calculateRentalPrice(days));
    }

    @Test
    void returnVehicle() {
        result.returnVehicle();
        assertTrue(result.returned);
    }

    @Test
    void testToString() {
        String expected = "Rental Transaction: " +
                "\nVehicle: " + car.getVehicleDetails() +
                "\nRental Days: " + days +
                "\nTotal Cost: $" + car.calculateRentalPrice(days) +
                "\nStart Date: " + LocalDate.now() +
                "\nEnd Date: " + LocalDate.now().plusDays(days) +
                "\nReturned: No";

        String actual = result.toString();

        assertEquals(expected, actual);

    }
}