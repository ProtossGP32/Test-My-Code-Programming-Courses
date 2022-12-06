
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class IsItInTheFile {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Name of the file:");
        String file = scanner.nextLine();

        System.out.println("Search for:");
        String searchedFor = scanner.nextLine();

        // Initialize an empty array to save the file content
        ArrayList<String> list = new ArrayList<>();

        // Read the whole file and save each line inside an array list
        try (Scanner fileScanner = new Scanner(Paths.get(file))) {
            while (fileScanner.hasNextLine()) {
                list.add(fileScanner.nextLine());
            }

        } catch (Exception e) {
            System.out.println("Reading the file " + file + "failed.");
        }

        // Search for the given name inside the list
        boolean nameFound = false;
        for (String name : list) {
            if (searchedFor.equals(name)) {
                nameFound = true;
                break;
            }
        }
        // Print the output of the search
        if (nameFound) {
            System.out.println("Found!");
        } else {
            System.out.println("Not found.");
        }
    }
}
