import java.util.ArrayList;

public class BoxWithMaxWeight extends Box{
    private int maxWeight;
    private ArrayList<Item> items;
    public BoxWithMaxWeight(int capacity) {
        this.maxWeight = capacity;
        this.items = new ArrayList<>();
    }

    @Override
    public void add(Item item) {
        int currentWeight = 0;
        for (Item storedItem : this.items) {
            currentWeight += storedItem.getWeight();
        }

        if (currentWeight + item.getWeight() <= this.maxWeight) {
            this.items.add(item);
        }
    }

    @Override
    public boolean isInBox(Item item) {
        return this.items.contains(item);
    }
}
