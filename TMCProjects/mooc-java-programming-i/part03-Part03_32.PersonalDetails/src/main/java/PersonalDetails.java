
import java.util.ArrayList;
import java.util.Scanner;

public class PersonalDetails {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int longestLength = -1;
        String longestName = "";
        int numberEntries = 0;
        int sumYears = 0;

        while (true) {
            String text = scanner.nextLine();
            if (text.isEmpty()) {
                break;
            }
            String[] splitText = text.split(",");
            // Retrieve the year and add it to the aggregated for later average
            numberEntries++;
            sumYears += Integer.parseInt(splitText[1]);
            // Check name's length
            if (splitText[0].length() > longestLength) {
                longestLength = splitText[0].length();
                longestName = splitText[0];
            }
        }
        System.out.println("Longest name: " + longestName);
        System.out.println("Average of the birth years: " + ((double) sumYears / numberEntries));
    }
}
