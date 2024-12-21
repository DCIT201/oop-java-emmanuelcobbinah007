public abstract class Vehicle {
    private final int vehicleId;
    private final String licensePlate;
    private VehicleType vehicleType;
    private String make;
    private String model;
    private int year;
    private double rentalPricePerDay;
    private String color;
    private boolean available;

    // Constructor Function
    public Vehicle(int vehicleId, String make, String model, int year, double rentalPricePerDay, String color, String licensePlate) {
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

    // Abstract Methods
    public abstract double calculateRentalPrice(int daysRented);
    public abstract boolean isAvailableForRental();


    public void rentVehicle() {
        if (available) {
            available = false;
            System.out.println("Vehicle rented out successfully");
        } else {
            System.out.println("Vehicle not available");
        }
    }

    public void returnVehicle() {
        available = true;
        System.out.println("Vehicle returned successfully");
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

}
