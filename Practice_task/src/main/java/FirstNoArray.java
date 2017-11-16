import java.util.Arrays;
import java.util.Scanner;

import static java.util.Arrays.*;

public class FirstNoArray{
    public static void main(String args[]) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the number of elements: ");
        int n = keyboard.nextInt();

        int min = 0;
        int max = 0;
        int sum = 0;
        int product = 1;

        for (int j=0; j<n; j++) {
            System.out.println("Enter an integer: ");
            int temp = keyboard.nextInt();
            if (temp < min) {min = temp;}
            else if (temp > max) {max = temp;}
            sum += temp;
            product *= temp;
        }

        System.out.println("Max value: " + max);
        System.out.println("Min value: " + min);
        System.out.println("Sum: " + sum);
        System.out.println("Product: " + product);
    }
}
