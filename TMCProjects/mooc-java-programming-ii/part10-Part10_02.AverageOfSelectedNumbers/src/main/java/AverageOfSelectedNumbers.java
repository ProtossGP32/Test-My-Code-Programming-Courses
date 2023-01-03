
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class AverageOfSelectedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // toteuta ohjelmasi tänne
        List<String> inputs = new ArrayList<>();
        System.out.println("Input numbers, type \"end\" to stop.");

        while (true) {
            String row = scanner.nextLine();
            if (row.equals("end")) {
                break;
            }
            inputs.add(row);
        }

        System.out.println("Print the average of the negative numbers or the positive numbers? (n/p)");
        String averageType;
        while (true) {
            averageType = scanner.nextLine();
            if (averageType.equals("n") || averageType.equals("p")) {
                break;
            }
            System.out.println("Bad input, please enter \"n\" or \"p\"");
        }

        double filteredAverage;
        switch(averageType) {
            case "n":
                // Stream results: average of negative numbers
                filteredAverage = inputs.stream()
                        .mapToInt(s -> Integer.parseInt(s))
                        .filter(number -> number < 0)
                        .average()
                        .getAsDouble();
                System.out.println("Average of the negative noumbers: " + filteredAverage);
                break;
            case "p":
                // Stream results: average of positive numbers
                filteredAverage = inputs.stream()
                        .mapToInt(s -> Integer.parseInt(s))
                        .filter(number -> number >= 0)
                        .average()
                        .getAsDouble();
                System.out.println("Average of the positive numbers: " + filteredAverage);
                break;
            default:
                System.out.println("Unexpected value of averageType: " + averageType);
        }
    }
}
