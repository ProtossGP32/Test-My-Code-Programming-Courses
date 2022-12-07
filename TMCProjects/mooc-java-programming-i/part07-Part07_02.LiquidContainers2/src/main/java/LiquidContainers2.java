
import java.util.Scanner;

public class LiquidContainers2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Container firstContainer = new Container();
        Container secondContainer = new Container();

        while (true) {
            // Print the contents of both containers. Don't take negative values into consideration
            System.out.println("First: " + firstContainer);
            System.out.println("Second: " + secondContainer);
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
                firstContainer.add(amount);

            } else if (command.equals("move")) {
                // Moves the amount of liquid specified by the parameter from the first container to the second container.
                // The given amount must be specified as an integer.
                // If the program is requested to move more liquid than the first container currently holds, move all the remaining liquid.
                // The second container can't hold more than one hundred liters of liquid and everything past that will go to waste.
                if (amount > 0) {
                    if (amount < firstContainer.contains()) {
                        firstContainer.remove(amount);
                        secondContainer.add(amount);
                    } else {
                        secondContainer.add(firstContainer.contains());
                        firstContainer.remove(firstContainer.contains());
                    }
                }

            } else if (command.equals("remove")) {
                // Removes the amount of liquid specified by the parameter from the second container.
                // If the program is requested to remove more liquid than the container currently holds, remove all the remaining liquid.
                if (amount > 0) {
                    secondContainer.remove(amount);
                }
            }
        }
    }
}
