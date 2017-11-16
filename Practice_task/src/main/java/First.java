import java.util.Arrays;
import java.util.Scanner;

import static java.util.Arrays.*;

public class First{
    public static void main(String args[]) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the number of elements: ");
        int n = keyboard.nextInt();
        int[] numbers = new int[n];
        for (int j=0; j<n; j++) {
            System.out.println("Enter an integer: ");
            numbers[j] = keyboard.nextInt();
        }
        System.out.println("Max value: " + stream(numbers).max().getAsInt());
        System.out.println("Min value: " + stream(numbers).min().getAsInt());
        System.out.println("Sum: " + stream(numbers).sum());

        int product = 1;
        for (int j=0; j<n; j++) {
            product *= numbers[j];
        }
        System.out.println("Product: " + product);
    }
}
