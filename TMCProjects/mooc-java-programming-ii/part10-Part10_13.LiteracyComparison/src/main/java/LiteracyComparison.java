
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LiteracyComparison {
    // CSV header:
    // theme, age group, gender, country, year, literacy percent
    public static void main(String[] args) {
        List<String[]> literacy = readAndSort("literacy.csv");
        literacy.stream()
                .forEach(entry -> printLiteracyRate(entry));
    }

    public static List<String[]> readAndSort(String file) {
        List<String[]> rows = new ArrayList<>();
        try {
            Files.lines(Paths.get(file))
                    .map(row -> row.split(","))
                    .filter(row -> row.length >= 5)
                    .sorted((rate1, rate2) -> {
                        return rate1[5].trim().compareTo(rate2[5].trim());
                    })
                    .forEach(row -> rows.add(row));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return rows;
    }

    public static void printLiteracyRate(String[] entry) {
        String genre = entry[2].trim().split(" ")[0];
        System.out.println(entry[3].trim() + " (" + entry[4].trim() + "), " + genre + ", " + entry[5].trim());
    }
}
