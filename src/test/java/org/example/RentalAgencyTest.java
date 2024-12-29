package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RentalAgencyTest {
    private RentalAgency rentalAgency;
    private Customer customer;
    private Customer customer2;
    private Customer customer3;
    private Car car1;
    private Car car2;
    private Car car3;
    private int days;

    @BeforeEach
    void setUp() {
        rentalAgency = new RentalAgency("AgencyOne");
        customer = new Customer(33829, "John", "2024-12-26", "123 Fake Street", "0245123123", "johnd@gmail.com", "GHA_JSM3837_1");
        customer2 = new Customer(1, "John Doe", "1990-01-01", "123 Main St", "1234567890", "john.doe@example.com", "DL12345");
        customer3 = new Customer(2, "Jane Doe", "1992-02-02", "456 Elm St", "0987654321", "jane.doe@example.com", "DL54321");
        days = 5;
        car1 = new Car(66738, "Honda", "Civic", 2017, 86.0, "Red", "DC-2779-19", 4, true, true);
        car2 = new Car(66739, "Toyota", "Corolla", 2018, 90.0, "Blue", "DC-2780-19", 4, true, true);
        car3 = new Car(12345, "Hyndai", "Corolla", 2020, 75.5, "Black", "GT-1234-20", 4, true, false);
        rentalAgency.addVehicle(car1);
        rentalAgency.addVehicle(car2);
        rentalAgency.addVehicle(car3);
        rentalAgency.addCustomer(customer);
        rentalAgency.addCustomer(customer2);
        rentalAgency.addCustomer(customer3);

    }


    @Test
    void showVehicles() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        rentalAgency.showVehicles();

        System.setOut(originalOut);

        String output = outputStream.toString().trim();
        assertTrue(output.contains(car1.toString()), "Output should contain details of car1.");
        assertTrue(output.contains(car2.toString()), "Output should contain details of car2.");


    }

    @Test
    void listAvailableVehicles() {
        List<Vehicle> availableVehicles = rentalAgency.listAvailableVehicles();

        assertEquals(3, availableVehicles.size(), "There should be 3 available vehicles.");
        assertTrue(availableVehicles.contains(car1), "Available vehicles should include car1.");
        assertTrue(availableVehicles.contains(car2), "Available vehicles should include car2.");
    }

    @Test
    void showCustomers() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        rentalAgency.showCustomers();

        System.setOut(originalOut);

        String output = outputStream.toString().trim();
        assertTrue(output.contains(customer.getName()), "Output should contain the name of customer1.");
        assertTrue(output.contains(customer2.getName()), "Output should contain the name of customer2.");
        assertTrue(output.contains(customer.getDriversLicense()), "Output should contain the driver's license of customer1.");
        assertTrue(output.contains(customer2.getDriversLicense()), "Output should contain the driver's license of customer2.");

    }

    @Test
    void addVehicle() {
        Car car4 = new Car(12346, "Mazda", "CX-5", 2021, 95.0, "White", "GT-5678-21", 5, true, true);
        rentalAgency.addVehicle(car4);
        List<Vehicle> vehicles = rentalAgency.listAvailableVehicles();
        assertTrue(vehicles.contains(car4));
    }

    @Test
    void removeVehicle() {
        rentalAgency.removeVehicle(car1);
        List<Vehicle> vehicles = rentalAgency.listAvailableVehicles();
        assertFalse(vehicles.contains(car1));
    }

    @Test
    void addCustomer() {
        List<Customer> customers = rentalAgency.getCustomers();
        assertEquals(3, customers.size(), "The number of customers should be 3.");
        assertTrue(customers.contains(customer2), "The customer list should contain customer2.");
        assertTrue(customers.contains(customer3), "The customer list should contain customer3.");
    }

    @Test
    void processRental() {
        rentalAgency.processRental(customer, car1, days);
        assertFalse(car1.getAvailable());
        assertEquals(1, customer.getRentalHistory().size());
    }

    @Test
    void rentVehicle() {
        car1.setAvailable(false);
        rentalAgency.rentVehicle(car1);
        assertFalse(car1.getAvailable());
    }

    @Test
    void testProcessRental() {
        rentalAgency.processRental(customer, car2, days);
        assertFalse(car2.getAvailable());
        assertEquals(1, customer.getRentalHistory().size());
        assertEquals(car2, customer.getRentalHistory().get(0).getVehicle());
    }

    @Test
    void calculateTotalRevenue() {
        rentalAgency.processRental(customer, car1, days);
        rentalAgency.processRental(customer, car2, days);
        double totalRevenue = rentalAgency.calculateTotalRevenue();
        assertEquals(car1.calculateRentalPrice(days) + car2.calculateRentalPrice(days), totalRevenue);
    }

    @Test
    void calculateCustomerRevenue() {
        rentalAgency.processRental(customer, car1, days);
        rentalAgency.processRental(customer, car2, days);
        double customerRevenue = rentalAgency.calculateCustomerRevenue(customer);
        assertEquals(car1.calculateRentalPrice(days) + car2.calculateRentalPrice(days), customerRevenue);
    }

    @Test
    void testProcessRental1() {
        rentalAgency.processRental(customer, car1.getVehicleId(), days);
        assertFalse(car1.getAvailable());
        assertEquals(1, customer.getRentalHistory().size());
        assertEquals(car1, customer.getRentalHistory().get(0).getVehicle());
    }

    @Test
    void findVehicleById() {
        Vehicle foundVehicle = rentalAgency.findVehicleById(car1.getVehicleId());
        assertNotNull(foundVehicle);
        assertEquals(car1, foundVehicle);

        Vehicle notFoundVehicle = rentalAgency.findVehicleById(99999);
        assertNull(notFoundVehicle);
    }
}