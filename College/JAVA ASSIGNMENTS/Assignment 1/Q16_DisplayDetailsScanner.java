// 16. Write a Java program to take input your name, reg.no, rollno, branch, address using scanner class and display all details.
import java.util.Scanner;

public class Q16_DisplayDetailsScanner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.print("Enter registration number: ");
        String regNo = sc.nextLine();
        System.out.print("Enter roll no: ");
        String rollNo = sc.nextLine();
        System.out.print("Enter branch: ");
        String branch = sc.nextLine();
        System.out.print("Enter address: ");
        String address = sc.nextLine();

        System.out.println("\n--- Student Details ---");
        System.out.println("Name: " + name);
        System.out.println("Registration Number: " + regNo);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Branch: " + branch);
        System.out.println("Address: " + address);
        sc.close();
    }
}
