// Question 4 - Calculator with Constructor, repeated using while loop until Exit.
import java.util.Scanner;

class Calculator4 {
    int num1;
    int num2;

    // Parameterized constructor to initialize two integer numbers
    Calculator4(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    int addition() {
        return num1 + num2;
    }

    int subtraction() {
        return num1 - num2;
    }

    int multiplication() {
        return num1 * num2;
    }

    double division() {
        if (num2 == 0) {
            System.out.println("Error: Division by zero!");
            return 0;
        }
        return (double) num1 / num2;
    }
}

public class Q4_CalculatorWithConstructor {
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

            System.out.print("Enter first integer: ");
            int a = sc.nextInt();
            System.out.print("Enter second integer: ");
            int b = sc.nextInt();

            Calculator4 calc = new Calculator4(a, b);

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
