import java.util.ArrayList;
import java.util.List;

public class Herd implements Movable{
    private List<Movable> individuals;

    public Herd() {
        this.individuals = new ArrayList<>();
    }

    public void addToHerd(Movable movable) {
        this.individuals.add(movable);
    }
    @Override
    public void move(int dx, int dy) {
        for (Movable being : this.individuals) {
            being.move(dx, dy);
        }
    }

    public String toString() {
        String herdString = "";
        for (Movable being : this.individuals) {
            herdString += being + "\n";
        }
        return herdString;
    }
}
