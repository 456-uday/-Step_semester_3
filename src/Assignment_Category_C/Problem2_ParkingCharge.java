package Assignment_Category_C;

import java.util.Scanner;

abstract class Vehicle {
    protected int hours;

    Vehicle(int hours) {
        this.hours = hours;
    }

    abstract double calculateCharge();
}

class Bike extends Vehicle {

    Bike(int hours) {
        super(hours);
    }

    @Override
    double calculateCharge() {
        return hours * 10;
    }
}

class Car extends Vehicle {

    Car(int hours) {
        super(hours);
    }

    @Override
    double calculateCharge() {
        return 30 + (hours - 1) * 20;
    }
}

class Truck extends Vehicle {

    Truck(int hours) {
        super(hours);
    }

    @Override
    double calculateCharge() {
        double charge = hours * 50;
        return Math.max(charge, 100);
    }
}

public class Problem2_ParkingCharge {

    public static void main(String[] args) {

        String[] types = {"BIKE", "CAR", "TRUCK", "CAR"};
        int[] hours = {3, 4, 1, 1};

        double total = 0;

        for (int i = 0; i < types.length; i++) {

            Vehicle vehicle;

            switch (types[i]) {
                case "BIKE":
                    vehicle = new Bike(hours[i]);
                    break;

                case "CAR":
                    vehicle = new Car(hours[i]);
                    break;

                case "TRUCK":
                    vehicle = new Truck(hours[i]);
                    break;

                default:
                    continue;
            }

            double charge = vehicle.calculateCharge();

            System.out.printf("%s: %.2f%n", types[i], charge);
            total += charge;
        }

        System.out.printf("Total: %.2f%n", total);
    }}