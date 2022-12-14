public class Container {
    private int amount;

    public Container() {
        this.amount = 0;
    }

    public int contains() {
        return this.amount;
    }

    public void add(int amount) {
        if (amount > 0) {
            this.amount = Math.min(this.amount + amount, 100);
        }
    }

    public void remove(int amount) {
        if (amount > 0) {
            this.amount = Math.max(0, this.amount - amount);
        }
    }

    public String toString() {
        return this.amount + "/100";
    }
}
