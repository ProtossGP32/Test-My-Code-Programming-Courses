
import java.nio.file.Paths;
import java.util.Scanner;

public class PrintingAFile {

    public static void main(String[] args) {
        // Create a scanner for reading the file
        try (Scanner scanner = new Scanner(Paths.get("data.txt"))) {
            // Read the file until no lines are left
            while (scanner.hasNextLine()) {
                // Read one line and print it
                System.out.println(scanner.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
