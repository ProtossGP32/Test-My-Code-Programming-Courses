
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class NumbersFromAFile {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("File? ");
        String file = scanner.nextLine();
        System.out.print("Lower bound? ");
        int lowerBound = Integer.valueOf(scanner.nextLine());
        System.out.print("Upper bound? ");
        int upperBound = Integer.valueOf(scanner.nextLine());

        // Try to read the file
        //ArrayList<Integer> numbers = new ArrayList<>();
        int count = 0;
        try (Scanner fileScanner = new Scanner(Paths.get(file))) {
            while (fileScanner.hasNextLine()) {
                int newNumber = Integer.parseInt(fileScanner.nextLine());
                if (newNumber >= lowerBound && newNumber <= upperBound) {
                    ++count;
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Print the number of valid numbers
        System.out.println("Numbers: " + count);

    }

}
