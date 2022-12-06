
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize an array of Items
        ArrayList<Item> items = new ArrayList<>();

        while (true) {
            System.out.println("Identifier? (empty will stop)");
            String newIdentifier = scanner.nextLine();
            if (newIdentifier.isEmpty()) {
                break;
            }
            System.out.println("Name? (empty will stop)");
            String newName = scanner.nextLine();
            if (newName.isEmpty()) {
                break;
            }

            // Add Item to list
            items.add(new Item(newIdentifier, newName));
        }

        // Print the list of items. only once per identifier
        ArrayList<Item> printedItems = new ArrayList<>();
        for (Item item : items) {
            if (!printedItems.contains(item)) {
                System.out.println(item);
                printedItems.add(item);
            }
        }
    }
}
