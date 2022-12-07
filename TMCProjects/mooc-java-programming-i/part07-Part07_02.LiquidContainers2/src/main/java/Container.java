public class Container {
    private int amount;

    public Container() {
        this.amount = 0;
    }

    /**
     * Returns the amount of liquid in a container as an integer
     */
    public int contains() {
        return this.amount;
    }

    /**
     * Adds the amount of liquid given as a parameter to the container.
     * If the amount is negatives, no liquid is added.
     * A container can hold a maximum of 100 units of liquid.
     *
     * @param amount positive integer value to add
     */
    public void add(int amount) {
        if (amount > 0) {
            this.amount = Math.min(this.amount + amount, 100);
        }
    }

    /**
     * Removes the amount of liquid given as a parameter from the container.
     * If the amount is negative, no liquid is removed.
     * A container can never hold less than 0 units of liquid.
     */
    public void remove(int amount) {
        if (amount > 0) {
            this.amount = Math.max(0, this.amount - amount);
        }
    }

    /**
     * Returns the container as a string formatted "amount/100"
     */
    public String toString() {
        return this.amount + "/100";
    }

}
