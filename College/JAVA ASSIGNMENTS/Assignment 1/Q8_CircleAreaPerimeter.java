// 8. Write a Java program to print the area and perimeter of a circle.
import java.util.Scanner;

public class Q8_CircleAreaPerimeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter radius of circle: ");
        double r = sc.nextDouble();
        double area = Math.PI * r * r;
        double perimeter = 2 * Math.PI * r;
        System.out.println("Area: " + area);
        System.out.println("Perimeter (Circumference): " + perimeter);
        sc.close();
    }
}
