
import java.nio.file.Paths;
import java.util.Scanner;

public class RecordsFromAFile {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Name of the file:");
        String file = scanner.nextLine();
        try (Scanner fileScanner = new Scanner(Paths.get(file))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] splitLine = line.split(",");
                String year = "year";
                if (Integer.parseInt(splitLine[1]) != 1) {
                    year += "s";
                }
                System.out.println(splitLine[0] + ", age: " + splitLine[1] + " " + year);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}