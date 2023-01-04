import java.util.ArrayList;
import java.util.List;

public class Pipe<T> {
    List<T> values;
    public Pipe() {
        this.values = new ArrayList<>();
    }

    public void putIntoPipe(T value) {
        this.values.add(value);
    }

    public T takeFromPipe() {
        if (!this.values.isEmpty()) {
            return this.values.remove(0);
        }
        return null;
    }

    public boolean isInPipe() {
        return !this.values.isEmpty();
    }
}
