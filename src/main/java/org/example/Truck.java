package org.example;

public class Truck extends Vehicle {
    private double cargoCapacity;

    public double getCargoCapacity() {
        return cargoCapacity;
    }

    // Constructor
    public Truck(int vehicleId, String make, String model, int year, double rentalPricePerDay, String color, String licensePlate, double cargoCapacity) {
        super(vehicleId, make, model, year, rentalPricePerDay, color, licensePlate);

        if (cargoCapacity <= 0) {
            throw new IllegalArgumentException("Cargo capacity must be positive.");
        }

        this.cargoCapacity = cargoCapacity;
    }

    @Override
    public double calculateRentalPrice(int daysRented) {
        double basePrice = 100 * daysRented;

        // Adjust base price based on cargo capacity
        if (cargoCapacity > 10) {
            basePrice *= 1.5;
        }
        return basePrice;
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
}
