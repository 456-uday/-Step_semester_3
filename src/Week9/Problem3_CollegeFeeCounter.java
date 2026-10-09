import java.util.Scanner;

abstract class Student {
    protected String name;
    static final double TUITION_FEE = 40000.0;
    static final double TRANSPORT_FEE = 12000.0;

    Student(String name) {
        this.name = name;
    }

    abstract double calculateFee();

    boolean usesBus() {
        return false;
    }

    double getTotalFee() {
        return calculateFee() + (usesBus() ? TRANSPORT_FEE : 0.0);
    }
}

class DayScholar extends Student {
    DayScholar(String name) {
        super(name);
    }

    @Override
    double calculateFee() {
        return TUITION_FEE;
    }

    @Override
    boolean usesBus() {
        return true;
    }
}

class Hosteller extends Student {
    Hosteller(String name) {
        super(name);
    }

    @Override
    double calculateFee() {
        return TUITION_FEE + 60000.0;
    }
}

class Scholar extends Student {
    Scholar(String name) {
        super(name);
    }

    @Override
    double calculateFee() {
        return TUITION_FEE / 2;
    }

    @Override
    boolean usesBus() {
        return true;
    }
}

public class Problem3_CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalCollected = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            String name = sc.next();

            Student student;

            switch (type) {
                case "DAY_SCHOLAR":
                    student = new DayScholar(name);
                    break;

                case "HOSTELLER":
                    student = new Hosteller(name);
                    break;

                case "SCHOLAR":
                    student = new Scholar(name);
                    break;

                default:
                    System.out.println("Invalid student type");
                    continue;
            }

            double fee = student.getTotalFee();

            System.out.printf("%s: %.2f%n", name, fee);

            totalCollected += fee;
        }

        System.out.printf("Total Collected: %.2f%n", totalCollected);

        sc.close();
    }
}
