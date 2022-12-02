
import java.util.ArrayList;
import java.util.Scanner;

public class OnlyTheseNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> numbers = new ArrayList<>();
        while (true) {
            int number = Integer.parseInt(scanner.nextLine());
            if (number == -1) {
                break;
            }

            numbers.add(number);
        }
        // Ask for start and end list indexes to print
        System.out.print("From where? ");
        int whereFrom = Integer.parseInt(scanner.nextLine());
        System.out.print("To where? ");
        int whereTo = Integer.parseInt(scanner.nextLine());
        for (int i = whereFrom; i <= whereTo; i++) {
            System.out.println(numbers.get(i));
        }
    }
}
