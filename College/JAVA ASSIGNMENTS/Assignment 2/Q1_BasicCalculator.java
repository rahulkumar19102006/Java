// Question 1 - Basic Calculator using class, object, constructor and switch.
import java.util.Scanner;

class Calculator1 {
    double num1;
    double num2;

    // Constructor to initialize two numbers
    Calculator1(double num1, double num2) {
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

public class Q1_BasicCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        double a = sc.nextDouble();
        System.out.print("Enter second number: ");
        double b = sc.nextDouble();

        Calculator1 calc = new Calculator1(a, b);

        System.out.println("Select operation: 1-Addition, 2-Subtraction, 3-Multiplication, 4-Division");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

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
                System.out.println("Invalid choice!");
        }
        sc.close();
    }
}
