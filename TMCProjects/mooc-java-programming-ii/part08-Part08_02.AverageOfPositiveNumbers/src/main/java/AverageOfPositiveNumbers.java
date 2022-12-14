
import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfPositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> positiveNumbers = new ArrayList<>();

        while (true) {
            int number = scanner.nextInt();
            if (number == 0) {
                break;
            }

            if (number > 0) {
                positiveNumbers.add(number);
            }
        }

        // Return the average of the array
        if (positiveNumbers.size() == 0) {
            System.out.println("Cannot calculate the average");
        } else {
            System.out.println(averageOfArray(positiveNumbers));
        }

    }

    public static double averageOfArray(ArrayList<Integer> list) {
        int sum = 0;
        for (int number : list) {
            sum += number;
        }
        return (double) sum / list.size();
    }
}
