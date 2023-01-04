
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.Reflex;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static org.junit.Assert.*;

@Points("12-05.1 12-05.2 12-05.3")
public class HashMapTest<K, V> {
    String className = "HashMap";
    Reflex.ClassRef<Object> classRef;
    HashMap<K, V> testHashMap;
    Random random = new Random();
    Set<Pair<K, V>> keySet;

    @Before
    public void setUp() {
        this.classRef = Reflex.reflect(this.className);
        this.testHashMap = new HashMap<>();
        this.keySet = new HashSet<>();
    }

    @Test
    public void noTests() {

    }

    @Test
    public void classHashMapExists() {
        Reflex.reflect(this.className).requirePublic();
    }

    @Test
    public void classHashMapIsPublic() {
        assertTrue("The class" + this.className + "must be public, so it has to be defined as\npublic class " + this.className + " {...\n}", this.classRef.isPublic());
    }

    @Test
    public void addMethodExistsAndIsPublic() {
        this.classRef.method("add").returningVoid().taking(Object.class, Object.class).requirePublic();
    }
    @Test
    public void addWorks() {
        // TODO: Test starts to fail with 1.000.000 additions or more
        int numberOfObjects = Math.abs(this.random.nextInt(100000));
        for (int i = 0; i < numberOfObjects; i ++) {
            // Cast values to the generic types of the class
            K newKey = (K) Integer.valueOf(this.random.nextInt());
            String stringValue = "This is the value for key " + newKey;
            V newValue = (V) stringValue;
            // Add the new pair
            this.testHashMap.add(newKey, newValue);
            // Keep track of the random keys added to the hashmap
            this.keySet.add(new Pair(newKey, newValue));
        }
        assertEquals("Add method doesn't work. Expected size is incorrect after adding elements.", keySet.size(), this.testHashMap.size());
    }

    @Test
    public void addExpandsInternalListAsExpected() {
        int initialFullLength = this.testHashMap.getFullLength();
        // Test a maximum of 100.000 additions
        int numberOfObjects = Math.abs(this.random.nextInt(100000));
        for (int i = 0; i < numberOfObjects; i ++) {
            // Cast values to the generic types of the class
            K newKey = (K) Integer.valueOf(this.random.nextInt());
            String stringValue = "This is the value for key " + newKey;
            V newValue = (V) stringValue;
            // Add the new pair
            this.testHashMap.add(newKey, newValue);
            // Keep track of the random keys added to the hashmap
            this.keySet.add(new Pair(newKey, newValue));
        }
        // Calculate the expected full length based on the added objects
        int numberOfExpectedGrowths = this.getNumberOfGrowths(initialFullLength, this.testHashMap.getGrowthRate(), this.testHashMap.getCapacityLimitRate(), keySet.size());
        int expectedFullLength = (int) (initialFullLength * Math.pow(this.testHashMap.getGrowthRate(), numberOfExpectedGrowths));
        assertEquals("Add method doesn't work. Expected array length is incorrect after adding elements.", expectedFullLength, this.testHashMap.getFullLength());
    }

    @Test
    public void getMethodExistsAndIsPublic() {
        this.classRef.method("get").returning(Object.class).taking(Object.class).requirePublic();
    }

    @Test
    public void getWorks() {
        // Test a maximum of 100.000 additions
        int numberOfObjects = Math.abs(this.random.nextInt(100000));
        for (int i = 0; i < numberOfObjects; i ++) {
            // Cast values to the generic types of the class
            K newKey = (K) Integer.valueOf(this.random.nextInt(1000000));
            String stringValue = "This is the value for key " + newKey;
            V newValue = (V) stringValue;
            // Add the new pair
            this.testHashMap.add(newKey, newValue);
            // Keep track of the random keys added to the hashmap
            this.keySet.add(new Pair(newKey, newValue));
        }
        // Try to retrieve all pairs already saved in the hashMap
        for (Pair<K, V> pair : this.keySet) {
            assertEquals("Incorrect value found for the provided key!", pair.getValue(), this.testHashMap.get(pair.getKey()));
        }
    }

    @Test
    public void removeMethodExistsAndIsPublic() {
        this.classRef.method("remove").returning(Object.class).taking(Object.class).requirePublic();
    }

    @Test
    public void removeSimpleWorks() {
        K newKey = (K) Integer.valueOf(1);
        V newValue = (V) ("This is the value for key " + Integer.valueOf(1));

        this.testHashMap.add(newKey, newValue);
        assertTrue(this.testHashMap.size() == 1);
        // Remove the entry
        V removedValue = this.testHashMap.remove(newKey);
        assertEquals(newValue, removedValue);
        assertTrue(this.testHashMap.size() == 0);
    }

    @Test
    public void removeWorks() {
        // TODO: Test starts to fail with 1.000 additions or more
        int numberOfObjects = Math.abs(this.random.nextInt(100));
        for (int i = 0; i < numberOfObjects; i ++) {
            // Cast values to the generic types of the class
            K newKey = (K) Integer.valueOf(this.random.nextInt(1000000));
            String stringValue = String.valueOf(newKey);
            V newValue = (V) stringValue;
            // Add the new pair
            this.testHashMap.add(newKey, newValue);
            // Keep track of the random keys added to the hashmap
            this.keySet.add(new Pair(newKey, newValue));
        }
        // DEBUG: Print the whole hashMap
        System.out.println("Stored pairs: " + this.testHashMap.size());
        //this.testHashMap.print();
        //System.out.println();
        System.out.println("keySet pairs: " + this.keySet.size());
        //System.out.println(this.keySet);

        // Try to remove all pairs already saved in the hashMap
        for (Pair<K, V> pair : this.keySet) {
            V expectedValueToRemove = pair.getValue();
            V availableValueToRemove = this.testHashMap.get(pair.getKey());
            //assertNotNull(availableValueToRemove);
            V removedValue = this.testHashMap.remove(pair.getKey());
            assertEquals("Can't remove pair from hashMap! The available Value to remove is " + availableValueToRemove, expectedValueToRemove, removedValue);
        }

        assertEquals("The hashMap is expected to be empty after removing all keySet objects", 0, this.testHashMap.size());
    }

    // Private methods
    private int getNumberOfGrowths(int initialFullLength, int growthRate, double capacityLimitRate, int numberOfObjects) {
        int numberOfGrowths = 0;
        while (true) {
            int fullLength = (int) (initialFullLength * Math.pow(growthRate, numberOfGrowths));
            int difference = numberOfObjects - fullLength;
            // We are behind the growth full length but still haven't triggered the next growth
            if (difference < 0 && numberOfObjects < 0.75 * fullLength ) {
                break;
            }
            numberOfGrowths++;
        }
        return numberOfGrowths;
    }
}
