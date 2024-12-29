package org.example;

public class Car extends Vehicle {
    private int numberOfDoors;
    private boolean hasAC;
    private boolean isAutomatic;

    // Constructor
    public Car(int vehicleId, String make, String model, int year, double rentalPricePerDay, String color, String licensePlate, int numberOfDoors, boolean hasAC, boolean isAutomatic) {
        super(vehicleId, make, model, year, rentalPricePerDay, color, licensePlate);

        if (numberOfDoors <= 0) {
            throw new IllegalArgumentException("Number of doors must be positive.");
        }

        this.numberOfDoors = numberOfDoors;
        this.hasAC = hasAC;
        this.isAutomatic = isAutomatic;
    }

    @Override
    public double calculateRentalPrice(int daysRented) {
        double basePrice = getRentalPricePerDay() * daysRented;
        double newPrice = basePrice;
        if (hasAC) {
            newPrice += 10 * daysRented;
        }

        if (isAutomatic) {
            newPrice += 5 * daysRented;
        }

        return newPrice;
    }

    @Override
    public boolean isAvailableForRental() {
        return super.getAvailable();
    }

    @Override
    public void rent(Customer customer, int days) {
        super.rent(customer, days);
    }

    @Override
    public void returnVehicle() {
        super.returnVehicle();
    }

    // Getters
    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public boolean hasAC() {
        return hasAC;
    }

    public boolean isAutomatic() {
        return isAutomatic;
    }


}
