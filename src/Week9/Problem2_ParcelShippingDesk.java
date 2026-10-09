import java.util.Scanner;

interface Insurable {
    double calculateInsurance(double declaredValue);
}

abstract class Parcel {
    protected double weight;

    Parcel(double weight) {
        this.weight = weight;
    }

    abstract double calculateCharge();
}

class StandardParcel extends Parcel {
    StandardParcel(double weight) {
        super(weight);
    }

    @Override
    double calculateCharge() {
        return 40.0 + 10.0 * weight;
    }
}

class ExpressParcel extends Parcel implements Insurable {
    ExpressParcel(double weight) {
        super(weight);
    }

    @Override
    double calculateCharge() {
        return 80.0 + 15.0 * weight;
    }

    @Override
    public double calculateInsurance(double declaredValue) {
        return declaredValue * 0.02;
    }
}

class FragileParcel extends Parcel implements Insurable {
    FragileParcel(double weight) {
        super(weight);
    }

    @Override
    double calculateCharge() {
        return 40.0 + 10.0 * weight + 50.0;
    }

    @Override
    public double calculateInsurance(double declaredValue) {
        return declaredValue * 0.02;
    }
}

public class Problem2_ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double grandTotal = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double weight = sc.nextDouble();
            double declaredValue = sc.nextDouble();

            Parcel parcel;

            switch (type) {
                case "STANDARD":
                    parcel = new StandardParcel(weight);
                    break;

                case "EXPRESS":
                    parcel = new ExpressParcel(weight);
                    break;

                case "FRAGILE":
                    parcel = new FragileParcel(weight);
                    break;

                default:
                    System.out.println("Invalid parcel type");
                    continue;
            }

            double charge = parcel.calculateCharge();
            double insurance = 0.0;

            if (parcel instanceof Insurable) {
                insurance = ((Insurable) parcel)
                        .calculateInsurance(declaredValue);
            }

            double total = charge + insurance;
            grandTotal += total;

            System.out.printf(
                    "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    type, charge, insurance, total
            );
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);

        sc.close();
    }
}