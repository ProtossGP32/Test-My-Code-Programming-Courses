import java.util.ArrayList;

public class Hold {
    private int maxWeight;
    private ArrayList<Suitcase> suitcases;

    public Hold(int maxWeight) {
        this.suitcases = new ArrayList<>();
        this.maxWeight = maxWeight;
    }

    public boolean isEmpty() {
        return this.suitcases.isEmpty();
    }

    public int getCurrentWeight() {
        int currentHoldWeight = 0;
        for (Suitcase suitcase : this.suitcases) {
            currentHoldWeight += suitcase.totalWeight();
        }

        return currentHoldWeight;
    }

    public void addSuitcase(Suitcase suitcase) {
        if (this.isEmpty() && suitcase.totalWeight() <= this.maxWeight) {
            this.suitcases.add(suitcase);
        } else if (!this.isEmpty()) {
            int currentHoldWeight = this.getCurrentWeight();
            if (currentHoldWeight + suitcase.totalWeight() <= this.maxWeight) {
                this.suitcases.add(suitcase);
            }
        }
    }

    public void printItems() {
        for (Suitcase suitcase : this.suitcases) {
            suitcase.printItems();
        }
    }

    public String toString() {
        String returnString = "";
        if (this.isEmpty()) {
            returnString += "no items (";
        } else {
            int suitcasesSize = this.suitcases.size();
            if (suitcasesSize == 1) {
                returnString += suitcasesSize + " suitcase (";
            } else {
                returnString += suitcasesSize + " suitcases (";
            }
        }
        return returnString + this.getCurrentWeight() + " kg)";
    }
}
