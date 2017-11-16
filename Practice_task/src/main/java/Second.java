import java.util.Scanner;

public class Second {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Input integer: ");
        int temp = keyboard.nextInt();

        while (temp != 1) {
            if (temp % 2 == 0) {
                temp /= 2;
            } else {
                temp *= 3;
                temp += 1;
            }
            System.out.println("Current value: " + temp);
        }
    }
}
