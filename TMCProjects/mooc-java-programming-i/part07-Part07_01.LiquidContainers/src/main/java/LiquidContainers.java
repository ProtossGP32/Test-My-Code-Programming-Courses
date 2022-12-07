
import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int firstContainer = 0;
        int secondContainer = 0;

        while (true) {
            // Print the contents of both containers. Don't take negative values into consideration
            System.out.println("First: " + firstContainer + "/100");
            System.out.println("Second: " + secondContainer + "/100");
            System.out.print("> ");

            String input = scan.nextLine();
            if (input.equals("quit")) {
                break;
            }

            // Parse the input content
            String[] parts = input.split(" ");
            String command = parts[0];
            int amount = Integer.parseInt(parts[1]);

            if (command.equals("add")) {
                // Adds the amount of liquid specified by the parameter to the first container.
                // The inserted amount must be specified as an integer.
                // The container can't hold more than a hundred liters and everything added past that will go to waste
                if (amount > 0) {
                    firstContainer += amount;
                }
                if (firstContainer > 100) {
                    firstContainer = 100;
                }

            } else if (command.equals("move")) {
                // Moves the amount of liquid specified by the parameter from the first container to the second container.
                // The given amount must be specified as an integer.
                // If the program is requested to move more liquid than the first container currently holds, move all the remaining liquid.
                // The second container can't hold more than one hundred liters of liquid and everything past that will go to waste.
                if (amount > 0) {
                    if (amount <= firstContainer) {
                        firstContainer -= amount;
                        secondContainer += amount;
                    } else {
                        secondContainer += firstContainer;
                        firstContainer = 0;
                    }
                }
                // Remove excess from secondCounter
                if (secondContainer > 100) {
                    secondContainer = 100;
                }

            } else if (command.equals("remove")) {
                // Removes the amount of liquid specified by the parameter from the second container.
                // If the program is requested to remove more liquid than the container currently holds, remove all the remaining liquid.
                if (amount > 0) {
                    if (amount < secondContainer) {
                        secondContainer -= amount;
                    } else {
                        secondContainer = 0;
                    }
                }
            }
        }
    }
}
