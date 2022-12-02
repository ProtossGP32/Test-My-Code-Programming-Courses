
import java.util.ArrayList;
import java.util.Scanner;

public class AVClub {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String text = scanner.nextLine();
            if (text.isEmpty()) {
                break;
            }
            String[] splitText = text.split(" ");
            for (String s : splitText) {
                if (s.contains("av")) {
                    System.out.println(s);
                }
            }
        }

    }
}
