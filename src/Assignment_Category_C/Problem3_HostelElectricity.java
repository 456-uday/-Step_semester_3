package Assignment_Category_C;

import java.util.Scanner;

abstract class Room {
    protected int units;

    Room(int units) {
        this.units = units;
    }

    abstract double calculateBill();
}

class SingleRoom extends Room {

    SingleRoom(int units) {
        super(units);
    }

    @Override
    double calculateBill() {
        return units * 8;
    }
}

class SharedRoom extends Room {
    private int occupants;

    SharedRoom(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    @Override
    double calculateBill() {
        return (units * 6) / occupants;
    }
}

class ACRoom extends Room {

    ACRoom(int units) {
        super(units);
    }

    @Override
    double calculateBill() {
        return units * 10 + 200;
    }
}

public class Problem3_HostelElectricity {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = scanner.next();
            int units = scanner.nextInt();

            Room room;

            switch (type) {
                case "SINGLE":
                    room = new SingleRoom(units);
                    break;

                case "SHARED":
                    int occupants = scanner.nextInt();
                    room = new SharedRoom(units, occupants);
                    break;

                case "AC":
                    room = new ACRoom(units);
                    break;

                default:
                    continue;
            }

            double bill = room.calculateBill();

            System.out.printf("%s: %.2f%n", type, bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);

        scanner.close();
    }
}