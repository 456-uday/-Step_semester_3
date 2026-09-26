package Assignment_Category_C;

import java.util.Scanner;

abstract class BillingCustomer {
    protected double price;

    BillingCustomer(double price) {
        this.price = price;
    }

    abstract double calculateBill();
}

class BillingStudent extends BillingCustomer {

    BillingStudent(double price) {
        super(price);
    }

    @Override
    double calculateBill() {
        return price * 0.90;
    }
}

class BillingStaff extends BillingCustomer {

    BillingStaff(double price) {
        super(price);
    }

    @Override
    double calculateBill() {
        return price * 0.95;
    }
}

class BillingGuest extends BillingCustomer {

    BillingGuest(double price) {
        super(price);
    }

    @Override
    double calculateBill() {
        return price + 10;
    }
}

public class Problem1_CanteenBilling {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = scanner.next();
            double price = scanner.nextDouble();

            BillingCustomer customer;

            switch (type) {
                case "STUDENT":
                    customer = new BillingStudent(price);
                    break;

                case "STAFF":
                    customer = new BillingStaff(price);
                    break;

                case "GUEST":
                    customer = new BillingGuest(price);
                    break;

                default:
                    continue;
            }

            double bill = customer.calculateBill();

            System.out.printf("%s: %.2f%n", type, bill);

            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);

        scanner.close();
    }
}