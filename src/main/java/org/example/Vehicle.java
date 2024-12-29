package org.example;
import java.time.LocalDate;

public abstract class Vehicle implements iRentable{
    private final int vehicleId;
    private final String licensePlate;
    private VehicleType vehicleType;
    private String make;
    private String model;
    private int year;
    private double rentalPricePerDay;
    private String color;
    protected boolean available;

    // Constructor Function
    public Vehicle(int vehicleId, String make, String model, int year, double rentalPricePerDay, String color, String licensePlate) {
        if (vehicleId <= 0) {
            throw new IllegalArgumentException("Vehicle ID must be positive.");
        }
        if (rentalPricePerDay < 0) {
            throw new IllegalArgumentException("Rental price per day cannot be negative.");
        }
        if (year < 1900 || year > LocalDate.now().getYear()) {
            throw new IllegalArgumentException("Year must be between 1900 and the current year.");
        }
        if (licensePlate == null || licensePlate.trim().isEmpty()) {
            throw new IllegalArgumentException("License plate cannot be empty.");
        }

        this.vehicleId = vehicleId;
        this.make = make;
        this.model = model;
        this.year = year;
        this.rentalPricePerDay = rentalPricePerDay;
        this.color = color;
        this.available = true;
        this.licensePlate = licensePlate;
    }

    //Getters
    public int getVehicleId() {
        return vehicleId;
    }

    public double getRentalPricePerDay() {
        return rentalPricePerDay;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public boolean getAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    // Abstract Methods
    public abstract double calculateRentalPrice(int daysRented);
    public abstract boolean isAvailableForRental();

    public String rentVehicle() {
        if (available) {
            available = false;
            return "Vehicle rented out successfully";
        } else {
            String s = "Vehicle not available";
            return s;
        }
    }

    @Override
    public void returnVehicle() {
        available = true;
    }

    public String getVehicleDetails() {
        return "Vehicle ID: " + vehicleId + "\n" +
                "Make: " + make + "\n" +
                "Model: " + model + "\n" +
                "Year: " + year + "\n" +
                "Rental Price per Day: $" + rentalPricePerDay + "\n" +
                "Color: " + color + "\n" +
                "Available: " + (available ? "Yes" : "No");
    }

    @Override
    public void rent(Customer customer, int days) {
        if (available) {
            available = false;
            System.out.println("Vehicle rented out to " + customer.getName() + " for " + days + " days.");
        } else {
            System.out.println("Vehicle not available for rent.");
        }
    }

}
