import java.util.ArrayList;

public class Box implements Packable{
    private double maxWeight;
    private ArrayList<Packable> storedItems;
    public Box(double maximumCapacity) {
        this.storedItems = new ArrayList<>();
        this.maxWeight = maximumCapacity;
    }

    public void add(Packable item) {
        if (item.weight() + this.weight() <= this.maxWeight) {
            this.storedItems.add(item);
        }
    }

    public double weight() {
        double weight = 0;
        for (Packable item : this.storedItems) {
            weight += item.weight();
        }
        return weight;
    }

    @Override
    public String toString() {
        return "Box: " + this.storedItems.size() + " items, total weight " + this.weight() + " kg";
    }
}
