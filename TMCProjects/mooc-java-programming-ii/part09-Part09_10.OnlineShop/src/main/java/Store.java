import java.sql.SQLOutput;
import java.util.Map;
import java.util.Scanner;

public class Store {
    // Part 8
    private Warehouse warehouse;
    private Scanner scanner;

    public Store(Warehouse warehouse, Scanner scanner) {
        this.warehouse = warehouse;
        this.scanner = scanner;
    }

    // The method that handles the customers visit to the store.
    public void shop(String customer) {
        ShoppingCart cart = new ShoppingCart();
        System.out.println("Welcome to the store " + customer);
        System.out.println("our selection:");

        // List the available products
        for (String product : this.warehouse.products()) {
            System.out.println(product);
        }

        while (true) {
            System.out.print("What to put in the cart (press enter to go to the register): ");
            String product = scanner.nextLine();

            // No product --> End of shopping
            if (product.isEmpty()) {
                break;
            }


            if (this.warehouse.products().contains(product)) {
                // Retrieve the price of the product
                int productPrice = this.warehouse.price(product);
                // Reduce the available quantity of this item in the warehouse
                this.warehouse.take(product);
                // Add the product to the ShoppingCart
                cart.add(product, productPrice);
            }
        }

        System.out.println("your shoppingcart contents: ");
        cart.print();
        System.out.println("total: " + cart.price());
    }


}
