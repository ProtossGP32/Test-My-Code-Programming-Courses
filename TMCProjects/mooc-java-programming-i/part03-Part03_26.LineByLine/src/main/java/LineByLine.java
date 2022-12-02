
import java.util.Scanner;

public class LineByLine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String text = scanner.nextLine();
            if (text.isEmpty()) {
                break;
            }

            String[] splitText = text.split(" ");
            for (String s : splitText) {
                System.out.println(s);
            }
        }

    }
}
