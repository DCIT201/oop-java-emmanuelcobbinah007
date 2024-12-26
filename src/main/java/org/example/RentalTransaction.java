package org.example;
import java.time.LocalDate;

public class RentalTransaction {
    private Customer customer;
    private Vehicle vehicle;
    private int rentalDays;
    private double totalCost;
    private boolean returned = false;
    private LocalDate rentalStartDate;
    private LocalDate rentalEndDate;

    // Constructor
    public RentalTransaction(Customer customer, Vehicle vehicle, int rentalDays) {
        this.customer = customer;
        this.vehicle = vehicle;
        this.rentalDays = rentalDays;
        this.totalCost = vehicle.calculateRentalPrice(rentalDays);
        this.rentalStartDate = LocalDate.now();
        this.rentalEndDate = rentalStartDate.plusDays(rentalDays);
    }

    // Getters
    public Customer getCustomer() {
        return customer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public double getTotalCost() {
        return totalCost;
    }

    // RentalTransaction Methods
    public void returnVehicle () {
        vehicle.returnVehicle();
        this.returned = true;
    }

    @Override
    public String toString() {
        return "Rental Transaction: " +
                "\nVehicle: " + vehicle.getVehicleDetails() +
                "\nRental Days: " + rentalDays +
                "\nTotal Cost: $" + totalCost +
                "\nStart Date: " + rentalStartDate +
                "\nEnd Date: " + rentalEndDate +
                "\nReturned: " + (returned ? "Yes" : "No");
    }
}
