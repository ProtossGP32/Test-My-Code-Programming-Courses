import java.util.ArrayList;

public class Suitcase {

    private ArrayList<Item> items;
    private int maxWeight;

    public Suitcase(int maxWeight) {
        this.items = new ArrayList<>();
        this.maxWeight = maxWeight;
    }

    public int totalWeight() {
        int currentWeight = 0;
        for (Item storedItem : this.items) {
            currentWeight += storedItem.getWeight();
        }
        return currentWeight;
    }
    public void addItem(Item item) {
        if (items.isEmpty() && item.getWeight() <= this.maxWeight) {
            items.add(item);
        } else if (!items.isEmpty()) {
            int currentWeight = this.totalWeight();
            if (currentWeight + item.getWeight() <= this.maxWeight) {
                items.add(item);
            }
        }
    }

    public boolean isEmpty() {
        return this.items.isEmpty();
    }

    public void printItems() {
        for (Item item : this.items) {
            System.out.println(item);
        }
    }

    public Item heaviestItem() {
        if (this.isEmpty()) {
            return null;
        }
        Item heaviestItem = this.items.get(0);

        for (Item item : items) {
            if (heaviestItem.getWeight() < item.getWeight()) {
                heaviestItem = item;
            }
        }

        return heaviestItem;
    }

    public String toString() {
        String returnString = "";
        if (this.items.isEmpty()) {
            returnString += "no items (";
        } else {
            if (this.items.size() == 1) {
                returnString += this.items.size() + " item (";
            } else {
                returnString += this.items.size() + " items (";
            }
        }
        return returnString + this.totalWeight() + " kg)";
    }

}
