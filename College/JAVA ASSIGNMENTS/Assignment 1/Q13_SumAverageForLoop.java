// 13. Write a Java program to compute the sum of 1, 2, 3, ..., to 100 and display the average of sum. (Use for loop)
public class Q13_SumAverageForLoop {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum = sum + i;
        }
        double average = sum / 100.0;
        System.out.println("Sum of 1 to 100: " + sum);
        System.out.println("Average: " + average);
    }
}
