import java.util.ArrayList;

public class MisplacingBox extends Box{
    private ArrayList<Item> storedItems;

    public MisplacingBox() {
        this.storedItems = new ArrayList<>();
    }
    @Override
    public void add(Item item) {
        this.storedItems.add(item);
    }

    @Override
    public boolean isInBox(Item item) {
        return false;
    }
}
