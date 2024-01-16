package com.atharva.CarRentalSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RentalSystem rentalSystem = new RentalSystem();

        // Add available vehicles
        rentalSystem.addVehicle(new Car("Toyota", 1050, true));
        rentalSystem.addVehicle(new Bike("Honda", 1020, true));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nVehicle Rental System");
            System.out.println("1. Rent a vehicle");
            System.out.println("2. Return a vehicle");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter model to rent: ");
                    String model = scanner.next();
                    System.out.print("Enter rental duration (days): ");
                    int rentalDuration = scanner.nextInt();
                    System.out.println(rentalSystem.rentVehicle(model, rentalDuration));
                    break;
                case 2:
                    System.out.print("Enter model to return: ");
                    model = scanner.next();
                    rentalSystem.returnVehicle(model);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}