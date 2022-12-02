
import java.util.Scanner;

public class Adulthood {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Write your program here
        System.out.println("How old are you?");
        int age = Integer.parseInt(scan.nextLine());
        String adult = "";
        if (age < 18) {
            adult = "not ";
        }
        System.out.println("You are " + adult + "an adult");
    }
}
