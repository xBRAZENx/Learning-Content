package com.atharva.CarRentalSystem;

import java.util.ArrayList;

public class RentalSystem {
    private ArrayList<Vehicle> vehicles = new ArrayList<>();

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public String rentVehicle(String model, int rentalDuration) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.model.equals(model)) {
                return vehicle.rentVehicle(rentalDuration);
            }
        }
        return String.format("Sorry, the %s is not available in our inventory.", model);
    }

    public void returnVehicle(String model) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.model.equals(model)) {
                vehicle.returnVehicle();
                return;
            }
        }
        System.out.println("Invalid model. Vehicle not found in our inventory.");
    }
}
