package org.example;

import java.util.ArrayList;
import java.util.List;

public class RentalAgency {
    private String agencyName;
    private List<Vehicle> vehicles;
    private List<Customer> customers;

    // Constructor
    public RentalAgency(String name) {
        this.agencyName = name;
        this.vehicles = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    // Rental Agency Methods
    public void showVehicles() {
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }

    public List<Vehicle> listAvailableVehicles() {
        List<Vehicle> availableVehicles = new ArrayList<>();

        for (Vehicle vehicle : vehicles) {
            if (vehicle.getAvailable()) {
                availableVehicles.add(vehicle);
            }
        }

        return availableVehicles;
    }

    public void showCustomers() {
        for (Customer customer : customers) {
            System.out.println("Name: " + customer.getName() + "\n"
            + "Driver's License: " + customer.getDriversLicense() + "\n"
            + customer.getContactDetails());
        }
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
        System.out.println("Vehicle added: " + vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        vehicles.remove(vehicle);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
        System.out.println("Customer added: " + customer);
    }

    public void processRental(Customer customer, Vehicle vehicle, int rentalDays) {
        customer.rentVehicle(vehicle, rentalDays);
    }

    public void rentVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void processRental(Customer customer, Vehicle vehicle) {
        customer.returnVehicle(vehicle);
    }

    public double calculateTotalRevenue() {
        double totalRevenue = 0.0;
        for (Customer customer : customers) {
            for(RentalTransaction rental : customer.getRentalHistory()) {
                totalRevenue += rental.getTotalCost();
            }
        }
        return totalRevenue;
    }

    public double calculateCustomerRevenue(Customer customer) {
        double totalRevenue = 0.0;
        for(RentalTransaction rental : customer.getRentalHistory()) {
            totalRevenue += rental.getTotalCost();
        }
        return totalRevenue;
    }

    // Overloaded method to process rental by vehicleId
    public void processRental(Customer customer, int vehicleId, int rentalDays) {
        Vehicle vehicle = findVehicleById(vehicleId);
        if (vehicle != null) {
            vehicle.rent(customer, rentalDays);
            RentalTransaction rental = new RentalTransaction(customer, vehicle, rentalDays);
            customer.getRentalHistory().add(rental);
        } else {
            System.out.println("Vehicle not found.");
        }
    }

    protected Vehicle findVehicleById(int vehicleId) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVehicleId() == vehicleId) {
                return vehicle;
            }
        }
        return null;
    }

}
