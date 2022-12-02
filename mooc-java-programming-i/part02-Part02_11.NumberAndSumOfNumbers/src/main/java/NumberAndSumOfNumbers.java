
import java.util.Scanner;

public class NumberAndSumOfNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int numberOfNumbers = 0;
        while (true) {
            System.out.println("Give a number:");
            int number = Integer.parseInt(scanner.nextLine());
            if (number == 0) {
                break;
            }
            sum += number;
            numberOfNumbers += 1;
        }
        System.out.println("Number of numbers: " + numberOfNumbers);
        System.out.println("Sum of the numbers: " + sum);
    }
}
