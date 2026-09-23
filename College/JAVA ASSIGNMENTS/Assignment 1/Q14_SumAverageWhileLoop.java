// 14. Write a Java program to compute the sum of 1, 2, 3, ..., to 100 and display the average of sum. (Use while loop)
public class Q14_SumAverageWhileLoop {
    public static void main(String[] args) {
        int sum = 0;
        int i = 1;
        while (i <= 100) {
            sum = sum + i;
            i++;
        }
        double average = sum / 100.0;
        System.out.println("Sum of 1 to 100: " + sum);
        System.out.println("Average: " + average);
    }
}
