// 12. Write a Java program to add two numbers. Enter first and second number from user (Use Scanner class).
import java.util.Scanner;

public class Q12_AddTwoNumbersScanner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        System.out.print("Enter second number: ");
        int b = sc.nextInt();
        int sum = a + b;
        System.out.println("Sum: " + sum);
        sc.close();
    }
}
