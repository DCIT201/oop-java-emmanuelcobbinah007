package org.example;

public class Motorcycle extends Vehicle {
    private String engineType;

    public String getEngineType() {
        return engineType;
    }

    // Constructor
    public Motorcycle(int vehicleId, String make, String model, int year, double rentalPricePerDay, String color, String licensePlate, String engineType) {
        super(vehicleId, make, model, year, rentalPricePerDay, color, licensePlate);

        if (engineType == null || engineType.trim().isEmpty()) {
            throw new IllegalArgumentException("Engine type cannot be empty.");
        }

        this.engineType = engineType;
    }

    @Override
    public double calculateRentalPrice(int daysRented) {
        double basePrice = 50 * daysRented;

        if (engineType.equalsIgnoreCase("Sportbike")) {
            basePrice *= 1.2;
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
