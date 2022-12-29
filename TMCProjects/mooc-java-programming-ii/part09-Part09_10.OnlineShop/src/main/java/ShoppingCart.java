import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    // Part 5
    private Map<String, Item> items;

    public ShoppingCart() {
        this.items = new HashMap<>();
    }

    public void add(String product, int price) {
        if (this.items.containsKey(product)) {
            // Part 7
            this.items.get(product).increaseQuantity();
        } else {
            this.items.put(product, new Item(product, 1, price));
        }
    }

    public int price() {
        int totalPrice = 0;
        for (Item item : this.items.values()) {
            totalPrice += (item.price());
        }
        return totalPrice;
    }

    // Part 6
    public void print() {
        for (Item item : this.items.values()) {
            System.out.println(item);
        }
    }
}
