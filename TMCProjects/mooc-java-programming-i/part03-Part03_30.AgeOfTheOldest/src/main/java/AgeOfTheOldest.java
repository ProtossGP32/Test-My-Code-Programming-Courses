
import java.util.Scanner;

public class AgeOfTheOldest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int oldestAge = -1;

        while (true) {
            String text = scanner.nextLine();
            if (text.isEmpty()) {
                break;
            }
            String[] splitText = text.split(",");
            int currentAge = Integer.parseInt(splitText[1]);
            if (currentAge > oldestAge) {
                oldestAge = currentAge;
            }
        }
        System.out.println("Age of the oldest: " + oldestAge);
    }
}
