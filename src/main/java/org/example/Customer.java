package org.example;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int customerId;
    private String name;
    private String dob;
    private String address;
    private String phone;
    private String email;
    private String driversLicense;
    private List<RentalTransaction> rentalHistory;

    //Constructor
    public Customer(int customerId, String name, String dob, String address, String phone, String email, String driversLicense) {
        if (customerId <= 0) {
            throw new IllegalArgumentException("Customer ID must be positive.");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        if (address == null || address.trim().isEmpty()) {
            throw new IllegalArgumentException("Address cannot be empty.");
        }
        if (phone == null || phone.trim().isEmpty()) {
            throw new IllegalArgumentException("Phone number cannot be empty.");
        }
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be empty.");
        }
        if (dob == null) {
            throw new IllegalArgumentException("Date of birth cannot be empty.");
        }
        if (driversLicense == null || driversLicense.trim().isEmpty()) {
            throw new IllegalArgumentException("Driver's license cannot be empty.");
        }


        this.customerId = customerId;
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.driversLicense = driversLicense;
        this.rentalHistory = new ArrayList<>();
    }

    //Getters
    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public String getContactDetails() {
        return "Address: " + address + "\n"
                + "Phone: " + phone + "\n"
                + "Email: " + email;
    }

    public String getDriversLicense() {
        return driversLicense;
    }

    public List<RentalTransaction> getRentalHistory() {
        return rentalHistory;
    }

    // Customer Activities
    public String rentVehicle(Vehicle vehicle, int rentalDays) {
        if (!vehicle.isAvailableForRental()) {
            System.out.println("Vehicle is not available for rent.");
            return "Vehicle is not available for rent.";
        } else {
            RentalTransaction rental = new RentalTransaction(this, vehicle, rentalDays);
            rentalHistory.add(rental);
            vehicle.rentVehicle();
        }

        return "Vehicle Rented Successfully!";
    }

    public String returnVehicle(Vehicle vehicle) {
        for (RentalTransaction rental : rentalHistory) {
            if (rental.getVehicle().equals(vehicle)) {
                rental.returnVehicle();
                vehicle.returnVehicle();
                return "Vehicle Returned Successfully!";
            }
        }
        return "Car wasn't found";
    }

    public void displayRentalHistory() {
        if (rentalHistory.isEmpty()) {
            System.out.println("No rental history found.");
        } else {
            System.out.println("Rental History for " + name + ":");
            for (RentalTransaction rental : rentalHistory) {
                System.out.println(rental);
            }
        }
    }

}
