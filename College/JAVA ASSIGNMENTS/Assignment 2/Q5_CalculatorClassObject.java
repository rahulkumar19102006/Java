// Question 5 - Calculator with class, object, parameterized constructor,
// four methods, switch inside a method with 3 parameters (num1, num2, operator).
import java.util.Scanner;

class Calculator5 {
    double num1;
    double num2;

    // Parameterized constructor
    Calculator5(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

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

    // Method with 3 parameters containing switch statement
    double calculate(double a, double b, char operator) {
        switch (operator) {
            case '+':
                return add(a, b);
            case '-':
                return subtract(a, b);
            case '*':
                return multiply(a, b);
            case '/':
                return divide(a, b);
            default:
                System.out.println("Invalid operator!");
                return 0;
        }
    }
}

public class Q5_CalculatorClassObject {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        double a = sc.nextDouble();
        System.out.print("Enter second number: ");
        double b = sc.nextDouble();
        System.out.print("Enter operator (+, -, *, /): ");
        char op = sc.next().charAt(0);

        Calculator5 calc = new Calculator5(a, b);
        double result = calc.calculate(a, b, op);
        System.out.println("Result: " + result);
        sc.close();
    }
}
