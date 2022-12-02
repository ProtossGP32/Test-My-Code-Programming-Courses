
import java.util.Scanner;

public class AverageOfPositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int numberOfPositiveNumbers = 0;

        while (true) {
            System.out.println("Give a number:");
            int number = Integer.parseInt(scanner.nextLine());
            if (number == 0) {
                break;
            } else if (number > 0) {
                sum += number;
                numberOfPositiveNumbers += 1;
            }
        }
        if (numberOfPositiveNumbers > 0) {
            double average = (double) sum / numberOfPositiveNumbers;
            System.out.println("Average of the numbers: " + average);
        } else {
            System.out.println("Cannot calculate the average");
        }

    }
}
