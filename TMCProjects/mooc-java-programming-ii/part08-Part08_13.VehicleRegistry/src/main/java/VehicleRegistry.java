import java.util.ArrayList;
import java.util.HashMap;

public class VehicleRegistry {
    private HashMap<LicensePlate, String> owners;

    public VehicleRegistry() {
        this.owners = new HashMap<>();
    }
    public boolean add(LicensePlate licensePlate, String owner) {
        if (!this.owners.containsKey(licensePlate)) {
            owners.put(licensePlate, owner);
            return true;
        }
        return false;
    }

    public String get(LicensePlate licensePlate) {
        if (this.owners.containsKey(licensePlate)) {
            return this.owners.get(licensePlate);
        }
        return null;
    }

    public boolean remove(LicensePlate licensePlate) {
        if (this.owners.containsKey(licensePlate)) {
            this.owners.remove(licensePlate);
            return true;
        }
        return false;
    }

    public void printLicensePlates() {
        for (LicensePlate licensePlate : this.owners.keySet()) {
            System.out.println(licensePlate);
        }
    }

    public void printOwners() {
        ArrayList<String> ownersList = new ArrayList<>();
        for (String owner : this.owners.values()) {
            if (!ownersList.contains(owner)) {
                System.out.println(owner);
                ownersList.add(owner);
            }
        }
    }
}
