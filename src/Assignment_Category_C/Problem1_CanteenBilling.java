package Assignment_Category_C;

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
        return price;
    }
}

public class Problem1_CanteenBilling {

    public static void main(String[] args) {

        BillingCustomer student = new BillingStudent(200);
        BillingCustomer staff = new BillingStaff(300);
        BillingCustomer guest = new BillingGuest(160);

        System.out.printf("STUDENT: %.2f%n", student.calculateBill());
        System.out.printf("STAFF: %.2f%n", staff.calculateBill());
        System.out.printf("GUEST: %.2f%n", guest.calculateBill());

        double total = student.calculateBill()
                + staff.calculateBill()
                + guest.calculateBill();

        System.out.printf("Total: %.2f%n", total);
    }
}