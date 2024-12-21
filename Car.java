public class Car extends Vehicle {
    private int numberOfDoors;
    private boolean hasAC;
    private boolean isAutomatic;

    // Constructor
    public Car(int vehicleId, String make, String model, int year, double rentalPricePerDay, String color, String licensePlate, int numberOfDoors, boolean hasAC, boolean isAutomatic) {
        super(vehicleId, make, model, year, rentalPricePerDay, color, licensePlate);
        this.numberOfDoors = numberOfDoors;
        this.hasAC = hasAC;
        this.isAutomatic = isAutomatic;
    }

    @Override
    public double calculateRentalPrice(int daysRented) {
        double basePrice = 100 * daysRented;
        if (hasAC) {
            basePrice += 10 * daysRented;
        }

        if (isAutomatic) {
            basePrice += 5 * basePrice;
        }

        return basePrice;
    }

    @Override
    public boolean isAvailableForRental() {
        if(!available) {
            return false;
        } else {
            return true;
        }
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
