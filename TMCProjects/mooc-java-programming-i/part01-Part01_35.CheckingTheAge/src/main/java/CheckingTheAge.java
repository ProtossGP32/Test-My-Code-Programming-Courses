
import java.util.Scanner;

public class CheckingTheAge {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String answer = "OK";
        System.out.println("How old are you?");
        int age = Integer.parseInt(scan.nextLine());
        if (age < 0 || age > 120) {
            answer = "Impossible!";
        }
        System.out.println(answer);
    }
}
