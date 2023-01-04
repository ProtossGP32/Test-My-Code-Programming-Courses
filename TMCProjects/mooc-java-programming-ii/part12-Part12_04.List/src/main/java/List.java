public class List<Type> {
    private Type[] values;
    private int firstFreeIndex;
    public List() {
        // Java can't create a "new Type[10]", so we create a "new Object[10]"
        // and cast it to "Type[]"
        this.values = (Type[]) new Object[10];
        this.firstFreeIndex = 0;
    }

    public void add(Type value) {
        // Check if we've reached the end of the array
        // and increase it
        if(this.firstFreeIndex == this.values.length) {
            this.grow();
        }
        this.values[this.firstFreeIndex] = value;
        this.firstFreeIndex++;
    }

    public int size() {
        return this.values.length;
    }

    public int getFirstFreeIndex() {
        return this.firstFreeIndex;
    }

    public boolean contains(Type value) {
        // Check for the existence of value until the first free index
        int indexFound = this.indexOfValue(value);
        if (indexFound > -1) {
            return true;
        }
        return false;
    }

    public void remove(Type value) {
        int indexOfValue = this.indexOfValue(value);
        if (indexOfValue < 0) {
            return; // not found
        }
        // move values to the left to remove current value
        this.moveToTheLeft(indexOfValue);
        // Decrease the value of the first free index.
        this.firstFreeIndex--;
        // Overwrite with null the new first Free Index value
        this.values[this.firstFreeIndex] = null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < this.size(); i++) {
            stringBuilder.append(this.values[i]);
            if (i != this.size() - 1) {
                stringBuilder.append(", ");
            } else {
                stringBuilder.append("]");
            }
        }
        return stringBuilder.toString();
    }

    // Private methods
    /**
     * Increase the values array size
     */
    private void grow() {
        int newSize = this.values.length + this.values.length / 2;
        // Create a new array with the new size
        Type[] newValues = (Type[]) new Object[newSize];
        // Copy the values of the old array into the new array
        for (int i = 0; i < this.values.length; i++) {
            newValues[i] = this.values[i];
        }
        // Replace the instance values array with the new one
        this.values = newValues;
    }

    /**
     * Get the index of a given value
     */
    private int indexOfValue(Type value) {
        for (int i = 0; i < this.firstFreeIndex; i++) {
            if (this.values[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Move values from the given index one place to the left
     */
    private void moveToTheLeft(int fromIndex) {
        for (int i = fromIndex; i < this.firstFreeIndex - 1; i++) {
            this.values[i] = this.values[i + 1];
        }
        // Remove the last value from the list as it is duplicated on both
        // firstFreeIndex and firstFreeIndex - 1 indexes
    }
}
