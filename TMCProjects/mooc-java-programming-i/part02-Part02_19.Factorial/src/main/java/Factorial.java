
import java.util.Scanner;

public class Factorial {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give a number: ");
        int number = Integer.parseInt(scanner.nextLine());
        int factorial = 1;
        if (number > 0) {
            for (int i = 2; i <= number; i++) {
                factorial *= i;
            }
        }
        System.out.println("Factorial: " + factorial);
    }
}
