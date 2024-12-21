import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Customer {
    private int customerId;
    private String name;
    private Date dob;
    private String address;
    private String phone;
    private String email;
    private String driversLicense;
    private List<RentalTransaction> rentalHistory;

    //Constructor
    public Customer(int customerId, String name, Date dob, String address, String phone, String email, String driversLicense) {
        this.customerId = customerId;
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.driversLicense = driversLicense;
        this.rentalHistory = new ArrayList<>();
    }

    //Getters
    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public Date getDob() {
        return dob;
    }

    public String getContactDetails() {
        return "Address: " + address + "\n"
                + "Phone: " + phone + "\n"
                + "Email: " + email;
    }

    public String getDriversLicense() {
        return driversLicense;
    }

    public List<RentalTransaction> getRentalHistory() {
        return rentalHistory;
    }

    // Customer Activities
    public void rentVehicle(Vehicle vehicle, int rentalDays) {
        if (!vehicle.isAvailableForRental()) {
            System.out.println("Vehicle is not available for rent.");
            return;
        } else {
            RentalTransaction rental = new RentalTransaction(this, vehicle, rentalDays);
            rentalHistory.add(rental);
            vehicle.rentVehicle();
        }

    }

    public void returnVehicle(Vehicle vehicle) {
        for (RentalTransaction rental : rentalHistory) {
            if (rental.getVehicle().equals(vehicle)) {
                rental.returnVehicle();
                vehicle.returnVehicle();
                break;
            }
        }
    }

}
