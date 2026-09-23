// Problem 1: Basic class result system for multiple students.
// Base: Student (rollNo, name, accept(), show())
// Derived: FinalResult (internalMarks, externalMarks, readMarks(), total(), showFinalResult())
import java.util.Scanner;

class Student1 {
    int rollNo;
    String name;

    void accept(Scanner sc) {
        System.out.print("Enter Roll No: ");
        rollNo = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter Name: ");
        name = sc.nextLine();
    }

    void show() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name   : " + name);
    }
}

class FinalResult1 extends Student1 {
    double internalMarks;
    double externalMarks;

    void readMarks(Scanner sc) {
        System.out.print("Enter Internal Marks (out of 100): ");
        internalMarks = sc.nextDouble();
        System.out.print("Enter External Marks (out of 100): ");
        externalMarks = sc.nextDouble();
    }

    double total() {
        return internalMarks + externalMarks;
    }

    double percentage() {
        return total() / 2.0; // total out of 200
    }

    void showFinalResult() {
        System.out.println("------- Result Sheet -------");
        show();
        System.out.println("Internal Marks: " + internalMarks);
        System.out.println("External Marks: " + externalMarks);
        System.out.println("Total (out of 200): " + total());
        System.out.println("Percentage: " + percentage() + "%");
        System.out.println("----------------------------");
    }
}

public class Q1_BasicResultSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students (N): ");
        int n = sc.nextInt();

        FinalResult1[] students = new FinalResult1[n];

        // Loop to accept details and marks for all students
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Student " + (i + 1) + ":");
            students[i] = new FinalResult1();
            students[i].accept(sc);
            students[i].readMarks(sc);
        }

        // Loop to display complete result sheet for every student
        System.out.println("\n===== COMPLETE RESULT SHEET =====");
        for (int i = 0; i < n; i++) {
            System.out.println("\nStudent " + (i + 1) + ":");
            students[i].showFinalResult();
        }
        sc.close();
    }
}
