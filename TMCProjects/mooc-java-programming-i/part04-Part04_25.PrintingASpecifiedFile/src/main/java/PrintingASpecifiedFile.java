
import java.nio.file.Paths;
import java.util.Scanner;

public class PrintingASpecifiedFile {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which file should have its content printed?");
        String filename = scanner.nextLine();
        // Create a scanner for reading the file
        try (Scanner fileScanner = new Scanner(Paths.get(filename))) {
            // Read the file until no lines are left
            while (fileScanner.hasNextLine()) {
                // Read one line and print it
                System.out.println(fileScanner.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
