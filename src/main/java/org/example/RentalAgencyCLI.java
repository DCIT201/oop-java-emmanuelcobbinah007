package org.example;

import java.util.Date;
import java.util.Scanner;

    public class RentalAgencyCLI {

        private static final Scanner scanner = new Scanner(System.in);

        // Simulate some vehicles and customers
        private static final Vehicle[] vehicles = {
                new Car(1, "Toyota", "Camry", 2022, 50.0, "Red", "XYZ123", 4, true, true),
                new Motorcycle(2, "Harley Davidson", "Sportster", 2021, 30.0, "Black", "ABC456", "Cruiser"),
                new Truck(3, "Ford", "F-150", 2020, 80.0, "Blue", "LMN789", 15.0)
        };

        private static final Customer customer = new Customer(1, "John Doe", new Date(), "123 Main St", "555-1234", "johndoe@example.com", "D1234567");

        public static void main(String[] args) {
            while (true) {
                showMenu();
                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume the newline character

                switch (choice) {
                    case 1:
                        viewAvailableVehicles();
                        break;
                    case 2:
                        rentVehicle();
                        break;
                    case 3:
                        returnVehicle();
                        break;
                    case 4:
                        System.out.println("Thank you for using the Rental Agency. Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }

        private static void showMenu() {
            System.out.println("\n=== Rental Agency ===");
            System.out.println("1. View Available Vehicles");
            System.out.println("2. Rent a Vehicle");
            System.out.println("3. Return a Vehicle");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
        }

        private static void viewAvailableVehicles() {
            System.out.println("\n=== Available Vehicles ===");
            for (Vehicle vehicle : vehicles) {
                if (vehicle.isAvailableForRental()) {
                    System.out.println(vehicle.getVehicleDetails());
                }
            }
        }

        private static void rentVehicle() {
            System.out.println("\nEnter the vehicle ID to rent:");
            int vehicleId = scanner.nextInt();
            System.out.print("Enter the rental period (in days): ");
            int rentalDays = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            Vehicle selectedVehicle = null;
            for (Vehicle vehicle : vehicles) {
                if (vehicle.getVehicleId() == vehicleId && vehicle.isAvailableForRental()) {
                    selectedVehicle = vehicle;
                    break;
                }
            }

            if (selectedVehicle != null) {
                customer.rentVehicle(selectedVehicle, rentalDays);
                System.out.println("You have rented the vehicle successfully.");
            } else {
                System.out.println("Vehicle not available or invalid ID.");
            }
        }

        private static void returnVehicle() {
            System.out.println("\nEnter the vehicle ID to return:");
            int vehicleId = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            Vehicle selectedVehicle = null;
            for (Vehicle vehicle : vehicles) {
                if (vehicle.getVehicleId() == vehicleId) {
                    selectedVehicle = vehicle;
                    break;
                }
            }

            if (selectedVehicle != null) {
                customer.returnVehicle(selectedVehicle);
                System.out.println("You have returned the vehicle successfully.");
            } else {
                System.out.println("Invalid vehicle ID.");
            }
        }
    }
