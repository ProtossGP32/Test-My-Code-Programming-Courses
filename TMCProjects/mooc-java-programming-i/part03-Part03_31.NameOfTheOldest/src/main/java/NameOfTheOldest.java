
import java.util.Scanner;

public class NameOfTheOldest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int oldestAge = -1;
        String oldestName = "";
        while (true) {
            String text = scanner.nextLine();
            if (text.isEmpty()) {
                break;
            }
            String[] splitText = text.split(",");
            int currentAge = Integer.parseInt(splitText[1]);
            if (currentAge > oldestAge) {
                oldestAge = currentAge;
                oldestName = splitText[0];
            }
        }
        System.out.println("Name of the oldest: " + oldestName);
    }
}
