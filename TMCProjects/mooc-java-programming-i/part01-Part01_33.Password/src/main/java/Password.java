
import java.util.Scanner;

public class Password {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Write your program here
        String password = "Caput Draconis";
        String answer = "Off with you!";
        System.out.println("Password?");
        String inputPassword = scan.nextLine();
        if (password.equals(inputPassword)) {
            answer = "Welcome!";
        }
        System.out.println(answer);
    }
}
