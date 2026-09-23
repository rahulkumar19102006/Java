// 5. Write a Java program that takes two numbers as input and displays the multiplication of two numbers.
import java.util.Scanner;

public class Q5_MultiplyTwoNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        System.out.print("Enter second number: ");
        int b = sc.nextInt();
        int product = a * b;
        System.out.println("Multiplication: " + product);
        sc.close();
    }
}
