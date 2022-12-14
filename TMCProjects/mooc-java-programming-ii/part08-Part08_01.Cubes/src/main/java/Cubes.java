
import java.util.Scanner;

public class Cubes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String text = scanner.nextLine();
            if (text.equals("end")) {
                break;
            }
            int number = Integer.parseInt(text);
            System.out.println((int) Math.pow(number, 3));
        }

    }
}
