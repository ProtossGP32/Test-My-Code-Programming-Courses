
import java.util.Scanner;

public class AverageOfNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int numberOfNumbers = 0;
        double average = 0;
        while (true) {
            System.out.println("Give a number:");
            int number = Integer.parseInt(scanner.nextLine());
            if (number == 0) {
                break;
            }
            sum += number;
            numberOfNumbers += 1;
        }
        if (numberOfNumbers > 0) {
            average = (double) sum / numberOfNumbers;
        }
        System.out.println("Average of the numbers: " + average);
    }
}
