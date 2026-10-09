import java.util.Scanner;

interface NightService {
    double applyNightFare(double fare);
}

abstract class Cab {
    protected double distance;
    static final double MINIMUM_FARE = 100.0;

    Cab(double distance) {
        this.distance = distance;
    }

    abstract double calculateFare();

    double getFare() {
        return Math.max(calculateFare(), MINIMUM_FARE);
    }
}

class Mini extends Cab {
    Mini(double distance) {
        super(distance);
    }

    @Override
    double calculateFare() {
        return distance * 10.0;
    }
}

class Sedan extends Cab implements NightService {
    Sedan(double distance) {
        super(distance);
    }

    @Override
    double calculateFare() {
        return distance * 14.0;
    }

    @Override
    public double applyNightFare(double fare) {
        return fare * 1.20;
    }
}

class SUV extends Cab implements NightService {
    SUV(double distance) {
        super(distance);
    }

    @Override
    double calculateFare() {
        return distance * 18.0;
    }

    @Override
    public double applyNightFare(double fare) {
        return fare * 1.20;
    }
}

public class Problem4_CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double km = sc.nextDouble();
            String time = sc.next().toUpperCase();

            Cab cab;

            switch (type) {
                case "MINI":
                    cab = new Mini(km);
                    break;

                case "SEDAN":
                    cab = new Sedan(km);
                    break;

                case "SUV":
                    cab = new SUV(km);
                    break;

                default:
                    System.out.println("Invalid cab type");
                    continue;
            }

            if (time.equals("NIGHT") && !(cab instanceof NightService)) {
                System.out.println(type + ": night service not available");
                continue;
            }

            double fare = cab.getFare();

            if (time.equals("NIGHT") && cab instanceof NightService) {
                fare = ((NightService) cab).applyNightFare(fare);
            }

            System.out.printf("%s: %.2f%n", type, fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}