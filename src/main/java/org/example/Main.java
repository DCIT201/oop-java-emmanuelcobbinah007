package org.example;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            RentalAgency rentalAgency = new RentalAgency("FireRentals");
            Scanner scanner = new Scanner(System.in);

        Car car = new Car(66738, "Honda", "Civic", 2017, 86.0, "Red", "DC-2779-19", 4, true, true);
            Motorcycle motorcycle = new Motorcycle(71639, "Dugatti", "Diavel", 2020, 80.0, "Red", "ER-8023-21", "V-4 Engine");
            Truck truck = new Truck(46689, "Scania", "P-100", 2009, 200.0, "Grey", "BD-9106-05", 500.5);

            // Adding vehicles to the rental agency
            rentalAgency.addVehicle(car);
            rentalAgency.addVehicle(motorcycle);
            rentalAgency.addVehicle(truck);

            // Adding a customer
            Customer customer = new Customer(33829, "John", "2024-12-26", "123 Fake Street", "0245123123", "johnd@gmail.com", "GHA_JSM3837_1");
            rentalAgency.addCustomer(customer);

            System.out.println("Welcome to the Vehicle Rental Management System!");

            // Demonstration loop
            while (true) {
                System.out.println("\nSelect an option:");
                System.out.println("1. View available vehicles");
                System.out.println("2. Rent a vehicle");
                System.out.println("3. Return a vehicle");
                System.out.println("4. Exit");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        System.out.println("Available Vehicles:");
                        rentalAgency.listAvailableVehicles();
                        break;

                    case 2:
                        System.out.print("Enter Vehicle ID to rent: ");
                        int vehicleId = scanner.nextInt();
                        System.out.print("Enter number of days: ");
                        int days = scanner.nextInt();
                        scanner.nextLine(); // Consume newline left by nextInt()

                        Vehicle vehicleInConsideration = null;
                        for (Vehicle vehicle : rentalAgency.listAvailableVehicles()) {
                            if (vehicleId == vehicle.getVehicleId()) {
                                vehicleInConsideration = vehicle;
                                break; // Exit loop once the vehicle is found
                            }
                        }

                        if (vehicleInConsideration != null) {
                            System.out.println("The price is " + vehicleInConsideration.calculateRentalPrice(days));

                            System.out.println("Do you want to proceed (Y/N)?");
                            String res = scanner.nextLine().trim(); // Read input and remove whitespace

                            if (res.equalsIgnoreCase("Y")) { // Case-insensitive comparison
                                System.out.println("Vehicle rented successfully!");
                                vehicleInConsideration.setAvailable(false);
                            } else if (res.equalsIgnoreCase("N")) {
                                System.out.println("You chose not to proceed.");
                            } else {
                                System.out.println("Invalid input. Please enter 'Y' or 'N'.");
                            }
                        } else {
                            System.out.println("Vehicle not found.");
                        }
                        break;

                    case 3:
                        System.out.print("Enter Vehicle ID to return: ");
                        int returnVehicleId = scanner.nextInt();
                        scanner.nextLine();

                        Vehicle vehicleInConsideration2 = null;
                        for (Vehicle vehicle : rentalAgency.showVehicles()) {
                            if (returnVehicleId == vehicle.getVehicleId()) {
                                vehicleInConsideration2 = vehicle;
                                break;
                            }
                        }
                        if (vehicleInConsideration2 != null) {
                            if (rentalAgency.returnVehicle(vehicleInConsideration2)) {
                                System.out.println("Vehicle returned successfully!");
                            } else {
                                System.out.println("Unable to return vehicle. Ensure it is currently rented.");
                            }
                        } else {
                            System.out.println("Vehicle not found. Please check the ID and try again.");
                        }
                        break;

                    case 4:
                        System.out.println("Thank you for using the Vehicle Rental Management System!");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }

}
