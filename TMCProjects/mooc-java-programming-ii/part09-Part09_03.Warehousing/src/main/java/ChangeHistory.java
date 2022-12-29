import java.util.ArrayList;
import java.util.Collections;

public class ChangeHistory {
    private ArrayList<Double> changeHistory;
    public ChangeHistory() {
        this.changeHistory = new ArrayList<>();
    }


    public void add(double status) {
        this.changeHistory.add(status);
    }

    public void clear() {
        this.changeHistory.clear();
    }

    public double maxValue() {
        return Collections.max(this.changeHistory);
    }

    public double minValue() {
        return Collections.min(this.changeHistory);
    }

    public double average() {
        if (this.changeHistory.size() > 0) {
            double sum = 0;
            for (double value : this.changeHistory) {
                sum += value;
            }
            return sum / this.changeHistory.size();
        }
        return 0.0;
    }

    public String toString() {
        return this.changeHistory.toString();
    }
}
