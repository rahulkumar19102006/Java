// Assignment 5 - Exam Interface with Fee Receipt Program
import java.util.Scanner;

// Interface named "Exam"
interface Exam {
    // Abstract class inside the interface
    abstract class ConductExam {
        abstract void conduct();
    }

    // Default method containing examination guidelines
    default void guidelines() {
        System.out.println("\n----- Examination Guidelines -----");
        System.out.println("1. Students must carry their admit card and college ID.");
        System.out.println("2. Reach the examination hall 30 minutes before the exam.");
        System.out.println("3. Mobile phones and smart watches are strictly prohibited.");
        System.out.println("4. Malpractice will lead to disqualification.");
        System.out.println("----------------------------------");
    }

    // Static method
    static void display() {
        System.out.println("===========================================");
        System.out.println("   3rd Semester Examination Fee Portal     ");
        System.out.println("===========================================");
    }

    void acceptDetails(Scanner sc);
    void calculateFee();
    void printReceipt();
}

// OnlineExam implements Exam and extends the inner abstract class
class OnlineExam extends Exam.ConductExam implements Exam {
    String name;
    String regNo;
    int semester = 3;
    int numSubjects;
    int backPapers = 0;
    int totalFee = 0;

    @Override
    void conduct() {
        System.out.println("Online Exam will be conducted via the online portal.");
        System.out.println("Login with your registration number before the scheduled time.");
    }

    @Override
    public void acceptDetails(Scanner sc) {
        System.out.print("Enter student name: ");
        name = sc.nextLine();
        System.out.print("Enter registration number: ");
        regNo = sc.nextLine();
        System.out.print("Enter number of regular subjects: ");
        numSubjects = sc.nextInt();
        System.out.print("Do you have any back papers? (yes/no): ");
        sc.nextLine(); // consume newline
        String choice = sc.nextLine().trim().toLowerCase();
        if (choice.equals("yes") || choice.equals("y")) {
            System.out.print("Enter number of back-paper subjects: ");
            backPapers = sc.nextInt();
            sc.nextLine();
        } else {
            backPapers = 0;
        }
    }

    @Override
    public void calculateFee() {
        totalFee = (numSubjects * 100) + (backPapers * 200);
    }

    @Override
    public void printReceipt() {
        System.out.println("\n========== FEE RECEIPT (Online Exam) ==========");
        System.out.println("Student Name      : " + name);
        System.out.println("Registration No.  : " + regNo);
        System.out.println("Semester          : " + semester + "rd Semester");
        System.out.println("----------------------------------------------");
        System.out.println("Regular Subjects (" + numSubjects + " x Rs.100)  : Rs." + (numSubjects * 100));
        System.out.println("Back Papers (" + backPapers + " x Rs.200)      : Rs." + (backPapers * 200));
        System.out.println("----------------------------------------------");
        System.out.println("Total Fee Payable : Rs." + totalFee);
        System.out.println("==============================================");
    }
}

// OfflineExam implements Exam and extends the inner abstract class
class OfflineExam extends Exam.ConductExam implements Exam {
    String name;
    String regNo;
    int semester = 3;
    int numSubjects;
    int backPapers = 0;
    int totalFee = 0;

    @Override
    void conduct() {
        System.out.println("Offline Exam will be conducted in the college examination hall.");
        System.out.println("Check your seat allotment on the notice board.");
    }

    @Override
    public void acceptDetails(Scanner sc) {
        System.out.print("Enter student name: ");
        name = sc.nextLine();
        System.out.print("Enter registration number: ");
        regNo = sc.nextLine();
        System.out.print("Enter number of regular subjects: ");
        numSubjects = sc.nextInt();
        System.out.print("Do you have any back papers? (yes/no): ");
        sc.nextLine(); // consume newline
        String choice = sc.nextLine().trim().toLowerCase();
        if (choice.equals("yes") || choice.equals("y")) {
            System.out.print("Enter number of back-paper subjects: ");
            backPapers = sc.nextInt();
            sc.nextLine();
        } else {
            backPapers = 0;
        }
    }

    @Override
    public void calculateFee() {
        totalFee = (numSubjects * 100) + (backPapers * 200);
    }

    @Override
    public void printReceipt() {
        System.out.println("\n========== FEE RECEIPT (Offline Exam) ==========");
        System.out.println("Student Name      : " + name);
        System.out.println("Registration No.  : " + regNo);
        System.out.println("Semester          : " + semester + "rd Semester");
        System.out.println("-----------------------------------------------");
        System.out.println("Regular Subjects (" + numSubjects + " x Rs.100)  : Rs." + (numSubjects * 100));
        System.out.println("Back Papers (" + backPapers + " x Rs.200)      : Rs." + (backPapers * 200));
        System.out.println("-----------------------------------------------");
        System.out.println("Total Fee Payable : Rs." + totalFee);
        System.out.println("===============================================");
    }
}

// Main class
public class ExamFeeSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Exam.display();

        System.out.print("Choose exam mode (1-Online / 2-Offline): ");
        int mode = sc.nextInt();
        sc.nextLine(); // consume newline

        Exam exam;
        Exam.ConductExam conductor;

        if (mode == 1) {
            OnlineExam online = new OnlineExam();
            exam = online;
            conductor = online;
            exam.guidelines();
            conductor.conduct();
            online.acceptDetails(sc);
            online.calculateFee();
            online.printReceipt();
        } else {
            OfflineExam offline = new OfflineExam();
            exam = offline;
            conductor = offline;
            exam.guidelines();
            conductor.conduct();
            offline.acceptDetails(sc);
            offline.calculateFee();
            offline.printReceipt();
        }

        sc.close();
    }
}
