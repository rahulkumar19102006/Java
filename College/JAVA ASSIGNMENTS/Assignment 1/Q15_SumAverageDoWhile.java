// 15. Write a Java program to compute the sum of 1, 2, 3, ..., to 100 and display the average of sum (Use do-while loop).
public class Q15_SumAverageDoWhile {
    public static void main(String[] args) {
        int sum = 0;
        int i = 1;
        do {
            sum = sum + i;
            i++;
        } while (i <= 100);
        double average = sum / 100.0;
        System.out.println("Sum of 1 to 100: " + sum);
        System.out.println("Average: " + average);
    }
}
