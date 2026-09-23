// Problem 3: Academic evaluation module with abstract class + interfaces + topper display.
import java.util.Scanner;

abstract class Student3 {
    private int rollNo;
    private String name;

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    void accept(Scanner sc) {
        System.out.print("Enter Roll No: ");
        setRollNo(sc.nextInt());
        sc.nextLine();
        System.out.print("Enter Name: ");
        setName(sc.nextLine());
    }

    abstract void displayDetails();
}

interface MidSem_Exam3 {
    void readInternalMarks(Scanner sc);
    double getInternalMarks();
    void showInternalMarks();
}

interface EndSemExam3 {
    void readExternalMarks(Scanner sc);
    double getExternalMarks();
    void showExternalMarks();
}

class FinalResult3 extends Student3 implements MidSem_Exam3, EndSemExam3 {
    private double internal;
    private double external;

    @Override
    public void readInternalMarks(Scanner sc) {
        System.out.print("Enter Internal Marks (out of 40): ");
        internal = sc.nextDouble();
    }

    @Override
    public double getInternalMarks() {
        return internal;
    }

    @Override
    public void showInternalMarks() {
        System.out.println("Internal Marks (MidSem): " + internal + " / 40");
    }

    @Override
    public void readExternalMarks(Scanner sc) {
        System.out.print("Enter External Marks (out of 60): ");
        external = sc.nextDouble();
    }

    @Override
    public double getExternalMarks() {
        return external;
    }

    @Override
    public void showExternalMarks() {
        System.out.println("External Marks (EndSem): " + external + " / 60");
    }

    double total() {
        return internal + external;
    }

    double percentage() {
        return total(); // out of 100
    }

    String getDivision() {
        double p = percentage();
        if (p >= 80) return "Distinction";
        else if (p >= 60) return "First Class";
        else if (p >= 50) return "Second Class";
        else if (p >= 40) return "Pass Class";
        else return "Fail";
    }

    @Override
    void displayDetails() {
        System.out.println("------- Student Report -------");
        System.out.println("Roll No: " + getRollNo());
        System.out.println("Name   : " + getName());
        showInternalMarks();
        showExternalMarks();
        System.out.println("Total (out of 100): " + total());
        System.out.println("Percentage: " + percentage() + "%");
        System.out.println("Division: " + getDivision());
        System.out.println("------------------------------");
    }
}

public class Q3_AcademicEvaluation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students (N): ");
        int n = sc.nextInt();

        FinalResult3[] students = new FinalResult3[n];
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Student " + (i + 1) + ":");
            students[i] = new FinalResult3();
            students[i].accept(sc);
            students[i].readInternalMarks(sc);
            students[i].readExternalMarks(sc);
        }

        // Display all students details
        System.out.println("\n===== ALL STUDENTS DETAILS =====");
        for (int i = 0; i < n; i++) {
            System.out.println("\nStudent " + (i + 1) + ":");
            students[i].displayDetails();
        }

        // Display class topper details
        int topperIndex = 0;
        for (int i = 1; i < n; i++) {
            if (students[i].percentage() > students[topperIndex].percentage()) {
                topperIndex = i;
            }
        }
        System.out.println("\n===== CLASS TOPPER =====");
        students[topperIndex].displayDetails();

        sc.close();
    }
}
