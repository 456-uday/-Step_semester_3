package Assignment_Category_C;

import java.util.Scanner;

abstract class Employee {
    protected String name;
    protected double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    abstract double calculateBonus();
}

class FullTimeEmployee extends Employee {

    FullTimeEmployee(String name, double salary) {
        super(name, salary);
    }

    @Override
    double calculateBonus() {
        return salary * 0.10;
    }
}

class PartTimeEmployee extends Employee {

    PartTimeEmployee(String name, double salary) {
        super(name, salary);
    }

    @Override
    double calculateBonus() {
        return salary * 0.05;
    }
}

class InternEmployee extends Employee {

    InternEmployee(String name, double salary) {
        super(name, salary);
    }

    @Override
    double calculateBonus() {
        return 2000;
    }
}

public class Problem4_FestivalBonus {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        double totalBonus = 0;

        for (int i = 0; i < n; i++) {

            String type = scanner.next();
            String name = scanner.next();
            double salary = scanner.nextDouble();

            Employee employee;

            switch (type) {

                case "FULLTIME":
                    employee = new FullTimeEmployee(name, salary);
                    break;

                case "PARTTIME":
                    employee = new PartTimeEmployee(name, salary);
                    break;

                case "INTERN":
                    employee = new InternEmployee(name, salary);
                    break;

                default:
                    continue;
            }

            double bonus = employee.calculateBonus();

            System.out.printf("%s: %.2f%n", name, bonus);

            totalBonus += bonus;
        }

        System.out.printf("Total Bonus: %.2f%n", totalBonus);

        scanner.close();
    }
}