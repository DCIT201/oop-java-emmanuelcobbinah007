package org.example;

public class Motorcycle extends Vehicle {
    private String engineType;

    // Constructor
    public Motorcycle(int vehicleId, String make, String model, int year, double rentalPricePerDay, String color, String licensePlate, String engineType) {
        super(vehicleId, make, model, year, rentalPricePerDay, color, licensePlate);

        if (engineType == null || engineType.trim().isEmpty()) {
            throw new IllegalArgumentException("Engine type cannot be empty.");
        }

        this.engineType = engineType;
    }

    public String getEngineType() {
        return engineType;
    }

    @Override
    public double calculateRentalPrice(int daysRented) {
        double basePrice = getRentalPricePerDay() * daysRented;

        if (engineType.equalsIgnoreCase("V-4 Engine")) {
            basePrice += getRentalPricePerDay() * 1.2;
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
