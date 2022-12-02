
import java.util.Scanner;

public class Positivity {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Write your program here
        System.out.println("Give a number:");
        int number = Integer.parseInt(scan.nextLine());
        String text;
        if (number > 0) {
            text = "positive";
        } else {
            text = "not positive";
        }
        System.out.println("The number is " + text);
    }
}
