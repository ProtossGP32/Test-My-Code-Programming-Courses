
import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int first = 0;
        int second = 0;

        while (true) {
            System.out.println("First: " + first + "/100");
            System.out.println("Second: " + second + "/100");
            System.out.print("> ");

            String input = scan.nextLine();
            System.out.println();
            if (input.equals("quit")) {
                break;
            }

            String[] splitInput = input.split(" ");
            int amount = Integer.parseInt(splitInput[1]);
            if (amount > 0) {
                switch (splitInput[0]) {
                    case "add":
                        // Adds the specified amount to the first container
                        // Max capacity is 100, anything past it goes to waste
                        first += amount;
                        if (first > 100) {
                            first = 100;
                        }
                        break;
                    case "move":
                        // Moves the specified amount from first to second container
                        // Max capacity is 100, anything past it goes to waste
                        // If first container has less than the amount, move all the remaining liquid
                        if (amount < first) {
                            first -= amount;
                            second += amount;
                        } else {
                            second += first;
                            first = 0;
                        }
                        if (second > 100) {
                            second = 100;
                        }
                        break;
                    case "remove":
                        // Removes the amount of liquid specified from the second container
                        // If second container has less than the amount, remove all the remaining liquid
                        if (amount < second) {
                            second -= amount;
                        } else {
                            second = 0;
                        }
                        break;
                    default:
                        System.out.println("Unknown command");
                        break;
                }
            }



        }
    }

}
