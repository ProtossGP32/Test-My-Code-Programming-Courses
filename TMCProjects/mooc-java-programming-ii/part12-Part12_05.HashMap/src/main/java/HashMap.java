public class HashMap<K, V> {

    // Values is an array of lists of pairs, meaning that each position
    // of the array contains a List of key-value object
    private List<Pair<K, V>>[] values;
    private int storedValues;
    private final int growthRate = 2;
    private final double capacityLimitRate = 0.75;
    private final int defaultArraySize = 10;

    public HashMap() {
        this.values = new List[this.defaultArraySize];
        this.storedValues = 0;
    }

    public int size() {
        int totalObjects = 0;
        for (int i = 0; i < this.getFullLength(); i++) {
            if (this.values[i] != null) {
                totalObjects += this.values[i].size();
            }
        }
        return totalObjects;
    }

    public int getFullLength() {
        return this.values.length;
    }

    public int getGrowthRate() {
        return this.growthRate;
    }
    public double getCapacityLimitRate() {
        return this.capacityLimitRate;
    }

    public void add(K key, V value) {
        // Copy the suitable list into a local variable
        List<Pair<K, V>> valuesAtIndex = this.getListBasedOnKey(key);
        // Retrieve the index of the pair that has the same key in the
        // local subset of pairs
        int index = this.getIndexOfKey(valuesAtIndex, key);

        // If not found, add the new value to the List
        if (index < 0) {
            valuesAtIndex.add(new Pair<>(key, value));
            // Increase the number of stored values
            this.storedValues++;
        } else {
            // Else, replace the old value for that key with the new value
            valuesAtIndex.value(index).setValue(value);
        }

        // New functionality: if the number of key-value pairs is greater
        // than 75% of the size of the internal array, then we expand the internal
        // array
        if ((double) this.storedValues / this.values.length > this.capacityLimitRate) {
            grow();
        }
    }

    public V get(K key) {
        // Retrieve the list of pairs at the given index
        List<Pair<K, V>> valuesAtIndex = this.getListBasedOnKey(key);
        // Retrieve the index of the pair that has the same key in the
        // local subset of pairs
        int index = this.getIndexOfKey(valuesAtIndex, key);

        // If index is not found, add the new value to the List
        if (index < 0) {
            return null;
        }
        // Return the value for that key
        return valuesAtIndex.value(index).getValue();
    }

    public V remove(K key) {
        // Retrieve the subset of Pairs where the provided key should be
        List<Pair<K, V>> valuesAtIndex = getListBasedOnKey(key);
        // If the subset is empty, return null
        if (valuesAtIndex.size() == 0) {
            return null;
        }
        // Get the index of the list where the provided key is stored with its value
        int index = this.getIndexOfKey(valuesAtIndex, key);
        // If the key is not found, return null
        if (index < 0) {
            return null;
        }
        // Retrieve the Pair value, its value must be returned at the end
        Pair<K, V> pair = valuesAtIndex.value(index);
        V value = pair.getValue();
        // Use the remove method from the List class
        valuesAtIndex.remove(pair);
        // Reduce the number of stored values
        if (this.storedValues > 0) {
            this.storedValues--;
        }
        // Return the removed value
        return value;
    }

    public void print() {
        for (int i = 0; i < this.getFullLength(); i++) {
            if (this.values[i] != null) {
                System.out.println(this.values[i].toString());
            }
        }
    }

    // Private methods
    /**
     * Get the list of the internal array based on the value of the key to look for
     * @param key value to search
     * @return List of Pairs
     */
    private List<Pair<K, V>> getListBasedOnKey(K key) {
        // Compute the hash value for the key, used to figure out
        // which is the relevant index of the internal array
        //String stringKey = (String) key;
        int hashValue = this.getHashValue(key, this.values);
        // If the result is null, it means that there is no list in the calculated index
        // We initialize an empty one
        if (this.values[hashValue] == null) {
            this.values[hashValue] = new List<>();
        }
        // Retrieve the list of pairs at the given index
        return this.values[hashValue];
    }

    /**
     * Get the index of the Pair that contains the given key inside the List
     * @param myList List of Pairs to search in
     * @param key The key value to look for inside the List
     * @return The index of the Pair that contains the key
     */
    private int getIndexOfKey(List<Pair<K, V>> myList, K key) {
        // Traverse the given list searching for the desired key
        for (int i = 0; i < myList.size(); i++) {
            if (myList.value(i).getKey().equals(key)) {
                return i;
            }
        }
        // Else, return -1 as not found
        return -1;
    }

    /**
     * This method expands the internal list of lists size to the double
     */
    private void grow() {
        // Create a new array twice the size of the current one
        List<Pair<K, V>>[] newArray = new List[this.values.length * this.growthRate];

        for (int i = 0; i < this.values.length; i++) {
            // Copy the values of the old array into the new one
            copy(newArray, i);
        }

        // Replace the old array with the new one
        this.values = newArray;
    }

    /**
     * This method copies the key-value pairs to its new location
     * taking into account the new list size
     * @param newArray The extended array to be populated
     * @param fromIdx The index of the list where the values must be copied
     */
    private void copy(List<Pair<K, V>>[] newArray, int fromIdx) {
        // Only copy values if that array position is not null
        if (this.values[fromIdx] != null) {
            for (int i = 0; i < this.values[fromIdx].size(); i++) {
                Pair<K, V> oldValue = this.values[fromIdx].value(i);
                int hashValue = this.getHashValue(oldValue.getKey(), newArray);
                if (newArray[hashValue] == null) {
                    newArray[hashValue] = new List<>();
                }
                // Add the old value into the new array
                newArray[hashValue].add(oldValue);
            }
        }
    }

    /**
     * Returns the hashed value used as the internal array index
     * @param key value of the key to search
     * @param array The array whose length is used to compute the hash
     * @return The hashed value
     */
    private int getHashValue(K key, List<Pair<K, V>>[] array) {
        return Math.abs(key.hashCode() % array.length);
    }
}
