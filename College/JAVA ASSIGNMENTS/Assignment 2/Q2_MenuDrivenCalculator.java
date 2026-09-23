// Question 2 - Menu-Driven Calculator using while loop, class, constructor, switch.
import java.util.Scanner;

class Calculator2 {
    double num1;
    double num2;

    Calculator2(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    double addition() {
        return num1 + num2;
    }

    double subtraction() {
        return num1 - num2;
    }

    double multiplication() {
        return num1 * num2;
    }

    double division() {
        if (num2 == 0) {
            System.out.println("Error: Division by zero!");
            return 0;
        }
        return num1 / num2;
    }
}

public class Q2_MenuDrivenCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        while (choice != 5) {
            System.out.println("\n--- Calculator Menu ---");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            if (choice == 5) {
                System.out.println("Exiting... Thank you!");
                break;
            }

            System.out.print("Enter first number: ");
            double a = sc.nextDouble();
            System.out.print("Enter second number: ");
            double b = sc.nextDouble();

            Calculator2 calc = new Calculator2(a, b);

            switch (choice) {
                case 1:
                    System.out.println("Result: " + calc.addition());
                    break;
                case 2:
                    System.out.println("Result: " + calc.subtraction());
                    break;
                case 3:
                    System.out.println("Result: " + calc.multiplication());
                    break;
                case 4:
                    System.out.println("Result: " + calc.division());
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
        sc.close();
    }
}
