package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    private Customer customer; // Declare the Customer object
    private Car car1; // Declare a Car object for reuse
    private Car car2;

    @BeforeEach
    void setUp() {
        customer = new Customer(33829, "John", "2024-12-26", "123 Fake Street", "0245123123", "johnd@gmail.com", "GHA_JSM3837_1");

        car1 = new Car(66738, "Honda", "Civic", 2017, 86.0, "Red", "DC-2779-19", 4, true, true);
        car2 = new Car(66739, "Toyota", "Corolla", 2018, 90.0, "Blue", "DC-2780-19", 4, true, true);
    }

    @Test
    void getCustomerId() {
        int result = customer.getCustomerId();
        assertEquals(33829, result);
    }

    @Test
    void getName() {
        String result = customer.getName();
        assertEquals("John", result);
    }

    @Test
    void getDob() {
        String result = customer.getDob();
        assertEquals("2024-12-26", result);
    }

    @Test
    void getContactDetails() {
        String result = customer.getContactDetails();

        String expected = """
                Address: 123 Fake Street
                Phone: 0245123123
                Email: johnd@gmail.com""";

        assertEquals(expected, result);
    }

    @Test
    void getDriversLicense() {
        String result = customer.getDriversLicense();
        assertEquals("GHA_JSM3837_1", result);
    }

    @Test
    void rentVehicle() {
        String result = customer.rentVehicle(car1,7);
        assertEquals("Vehicle Rented Successfully!", result);
    }

    @Test
    void returnVehicle() {
       // Rent the vehicle first
        customer.rentVehicle(car1, 7);

        // Now return the vehicle
        String result = customer.returnVehicle(car1);

        assertEquals("Vehicle Returned Successfully!", result);
    }

    @Test
    void getRentalHistory() {
        customer.rentVehicle(car1, 7);
        customer.rentVehicle(car2, 5);

        List<RentalTransaction> result = customer.getRentalHistory();

        List expected = result;
        assertEquals(expected, result);
    }
}