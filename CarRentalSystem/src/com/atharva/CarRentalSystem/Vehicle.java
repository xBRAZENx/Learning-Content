package com.atharva.CarRentalSystem;
import java.util.Scanner;

public class Vehicle {
    protected String vehicleType;
    protected String model;
    protected double Rate;
    protected boolean availability;

    public Vehicle(String vehicleType, String model, double Rate, boolean availability) {
        this.vehicleType = vehicleType;
        this.model = model;
        this.Rate = Rate;
        this.availability = availability;
    }

    public double CostCalculation(int rentalDuration) {
    	double totalcost = Rate*rentalDuration;
    	return totalcost;
    }
    
    public String rentVehicle(int rentalDuration) {
        if (availability) {
            availability = false;
            double TotalRent = CostCalculation(rentalDuration);
            return String.format("You have successfully rented the %s for %d days. The total cost will be Rs%.2f", model, rentalDuration, TotalRent);
        } else {
            return String.format("Sorry, the %s is currently unavailable for rent.", model);
        }
    }

    public void returnVehicle() {
        availability = true;
        System.out.println("The vehicle has been successfully returned.");
    }
}