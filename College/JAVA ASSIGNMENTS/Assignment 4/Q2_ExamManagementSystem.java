// Problem 2: Examination management system using interfaces + array of objects + search by rollNo.
import java.util.Scanner;

class Student2 {
    int rollNo;
    String name;

    void accept(Scanner sc) {
        System.out.print("Enter Roll No: ");
        rollNo = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        name = sc.nextLine();
    }

    void show() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name   : " + name);
    }
}

interface MidSem_Exam {
    void readMarks(Scanner sc);   // read internal marks
    void showMarks();             // display internal marks
    double internalMarks();       // return internal marks
}

interface EndSemExam {
    void readMarksEndSem(Scanner sc); // read external marks
    void displayMarks();              // display external marks
    double externalMarks();           // return external marks
}

class FinalResult2 extends Student2 implements MidSem_Exam, EndSemExam {
    double internal;
    double external;

    // MidSem_Exam implementation (internal out of 40)
    @Override
    public void readMarks(Scanner sc) {
        System.out.print("Enter Internal Marks (out of 40): ");
        internal = sc.nextDouble();
    }

    @Override
    public void showMarks() {
        System.out.println("Internal Marks (MidSem): " + internal + " / 40");
    }

    @Override
    public double internalMarks() {
        return internal;
    }

    // EndSemExam implementation (external out of 60)
    @Override
    public void readMarksEndSem(Scanner sc) {
        System.out.print("Enter External Marks (out of 60): ");
        external = sc.nextDouble();
    }

    @Override
    public void displayMarks() {
        System.out.println("External Marks (EndSem): " + external + " / 60");
    }

    @Override
    public double externalMarks() {
        return external;
    }

    double total() {
        return internal + external; // out of 100
    }

    double calculatePercentage() {
        return total(); // total itself is percentage since out of 100
    }

    String getDivision() {
        double p = calculatePercentage();
        if (p >= 80) return "Distinction";
        else if (p >= 60) return "First Class";
        else if (p >= 50) return "Second Class";
        else if (p >= 40) return "Pass Class";
        else return "Fail";
    }

    void showReport() {
        System.out.println("------- Final Report -------");
        show();
        showMarks();
        displayMarks();
        System.out.println("Total (out of 100): " + total());
        System.out.println("Percentage: " + calculatePercentage() + "%");
        System.out.println("Division: " + getDivision());
        System.out.println("----------------------------");
    }
}

public class Q2_ExamManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students (N): ");
        int n = sc.nextInt();

        FinalResult2[] students = new FinalResult2[n];
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Student " + (i + 1) + ":");
            students[i] = new FinalResult2();
            students[i].accept(sc);
            students[i].readMarks(sc);
            students[i].readMarksEndSem(sc);
        }

        System.out.println("\n===== FINAL EXAM PERFORMANCE REPORT =====");
        for (int i = 0; i < n; i++) {
            System.out.println("\nStudent " + (i + 1) + ":");
            students[i].showReport();
        }

        // Search feature by rollNo
        System.out.print("\nEnter Roll No to search: ");
        int searchRoll = sc.nextInt();
        boolean found = false;
        for (int i = 0; i < n; i++) {
            if (students[i].rollNo == searchRoll) {
                System.out.println("\nRecord found:");
                students[i].showReport();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student with Roll No " + searchRoll + " not found!");
        }
        sc.close();
    }
}
