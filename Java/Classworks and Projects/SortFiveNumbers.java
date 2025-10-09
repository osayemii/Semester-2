import java.util.Arrays;
import java.util.Scanner;

public class SortFiveNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] numbers = new int[5]; // Array to store 5 integers

        // Receive input from user
        System.out.println("Enter 5 integers:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = input.nextInt();
        }

        // Sort the array in ascending order
        Arrays.sort(numbers);

        // Display sorted numbers
        System.out.println("\nNumbers in ascending order:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }

        input.close();
    }
}
