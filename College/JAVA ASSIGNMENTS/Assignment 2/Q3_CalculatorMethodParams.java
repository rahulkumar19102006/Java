// Question 3 - Calculator with Method Parameters.
import java.util.Scanner;

class Calculator3 {
    double add(double a, double b) {
        return a + b;
    }

    double subtract(double a, double b) {
        return a - b;
    }

    double multiply(double a, double b) {
        return a * b;
    }

    double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Division by zero!");
            return 0;
        }
        return a / b;
    }
}

public class Q3_CalculatorMethodParams {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator3 calc = new Calculator3();

        System.out.print("Enter first number: ");
        double a = sc.nextDouble();
        System.out.print("Enter second number: ");
        double b = sc.nextDouble();

        System.out.printf("1-Addition,%n2-Subtraction,%n3-Multiplication,%n4-Division%n");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Result: " + calc.add(a, b));
                break;
            case 2:
                System.out.println("Result: " + calc.subtract(a, b));
                break;
            case 3:
                System.out.println("Result: " + calc.multiply(a, b));
                break;
            case 4:
                System.out.println("Result: " + calc.divide(a, b));
                break;
            default:
                System.out.println("Invalid choice!");
        }
        sc.close();
    }
}
