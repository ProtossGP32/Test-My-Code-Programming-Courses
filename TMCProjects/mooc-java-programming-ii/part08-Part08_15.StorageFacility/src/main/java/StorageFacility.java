import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class StorageFacility {
    private HashMap<String, ArrayList<String>> storageUnits;

    public StorageFacility() {
        this.storageUnits = new HashMap<>();
    }

    public void add(String unit, String item) {
        this.storageUnits.putIfAbsent(unit, new ArrayList<>());
        this.storageUnits.get(unit).add(item);
    }

    public ArrayList<String> contents(String storageUnit) {
        return this.storageUnits.getOrDefault(storageUnit, new ArrayList<>());
    }

    public void remove(String storageUnit, String item) {
        if (this.storageUnits.containsKey(storageUnit)) {
            this.storageUnits.get(storageUnit).remove(item);
        }
    }

    public ArrayList<String> storageUnits() {
        ArrayList<String> usedUnits = new ArrayList<>();
        for (String storageUnit : this.storageUnits.keySet()) {
            if (this.storageUnits.get(storageUnit).size() > 0) {
                usedUnits.add(storageUnit);
            }
        }
        return usedUnits;
    }
}
