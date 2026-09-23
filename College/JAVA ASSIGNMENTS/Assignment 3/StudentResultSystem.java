// Student Results Processing System - Single File Version
// Demonstrates multiple inheritance using interface:
// Result extends Test (which extends Student) and implements Sports.

class Student {
    protected int rollNumber;
    protected String studentName;
    protected String address;

    // Parameterised constructor to initialize data members
    public Student(int rollNumber, String studentName, String address) {
        this.rollNumber = rollNumber;
        this.studentName = studentName;
        this.address = address;
    }

    public void setStudent(int rollNumber, String studentName, String address) {
        this.rollNumber = rollNumber;
        this.studentName = studentName;
        this.address = address;
    }

    public void displayStudent() {
        System.out.println("Roll Number : " + rollNumber);
        System.out.println("Student Name: " + studentName);
        System.out.println("Address     : " + address);
    }
}

class Test extends Student {
    protected double os;
    protected double ds;
    protected double javaMarks;
    protected double math;
    protected double de;

    public Test(int rollNumber, String studentName, String address,
                double os, double ds, double javaMarks, double math, double de) {
        super(rollNumber, studentName, address);
        setMarks(os, ds, javaMarks, math, de);
    }

    public void setMarks(double os, double ds, double javaMarks, double math, double de) {
        this.os = os;
        this.ds = ds;
        this.javaMarks = javaMarks;
        this.math = math;
        this.de = de;
    }

    public void displayMarks() {
        System.out.println("OS Marks  : " + os);
        System.out.println("DS Marks  : " + ds);
        System.out.println("Java Marks: " + javaMarks);
        System.out.println("Math Marks: " + math);
        System.out.println("DE Marks  : " + de);
    }

    public double getAcademicTotal() {
        return os + ds + javaMarks + math + de;
    }
}

interface Sports {
    int SPORTS_WEIGHTAGE = 10; // constant sports score / weightage (max marks)

    void displaySportsScore();
}

class Result extends Test implements Sports {
    private int sportsScore;

    public Result(int rollNumber, String studentName, String address,
                  double os, double ds, double javaMarks, double math, double de,
                  int sportsScore) {
        super(rollNumber, studentName, address, os, ds, javaMarks, math, de);
        if (sportsScore > SPORTS_WEIGHTAGE) {
            this.sportsScore = SPORTS_WEIGHTAGE;
        } else if (sportsScore < 0) {
            this.sportsScore = 0;
        } else {
            this.sportsScore = sportsScore;
        }
    }

    @Override
    public void displaySportsScore() {
        System.out.println("Sports Score: " + sportsScore + " (out of " + SPORTS_WEIGHTAGE + ")");
    }

    public double calculateGrandTotal() {
        return getAcademicTotal() + sportsScore;
    }

    public void displayReportCard() {
        System.out.println("========== REPORT CARD ==========");
        displayStudent();
        System.out.println("-------------------------------");
        displayMarks();
        displaySportsScore();
        System.out.println("-------------------------------");
        System.out.println("Academic Total (5 subjects): " + getAcademicTotal());
        System.out.println("Grand Total (Academic + Sports): " + calculateGrandTotal());
        System.out.println("===============================");
    }
}

public class StudentResultSystem {
    public static void main(String[] args) {
        // Array of objects: 5 different students
        Result[] students = new Result[5];

        students[0] = new Result(101, "Rahul Kumar", "Patna, Bihar", 85, 90, 88, 92, 80, 9);
        students[1] = new Result(102, "Priya Singh", "Gaya, Bihar", 78, 82, 85, 79, 88, 10);
        students[2] = new Result(103, "Amit Verma", "Muzaffarpur, Bihar", 90, 87, 91, 89, 93, 8);
        students[3] = new Result(104, "Sneha Das", "Bhagalpur, Bihar", 70, 75, 72, 68, 74, 7);
        students[4] = new Result(105, "Vikash Yadav", "Darbhanga, Bihar", 88, 84, 86, 90, 82, 10);

        System.out.println("Student Results Processing System (Multiple Inheritance using Interface)\n");

        for (int i = 0; i < students.length; i++) {
            System.out.println("\nStudent " + (i + 1) + ":");
            students[i].displayReportCard();
        }
    }
}
