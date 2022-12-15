
import java.util.Objects;

public class LicensePlate {
    // don't modify existing parts of this class

    // these instance variables have been defined as final, meaning 
    // that once set, their value can't be changed
    private final String liNumber;
    private final String country;

    public LicensePlate(String country, String liNumber) {
        this.liNumber = liNumber;
        this.country = country;
    }

    public int hashCode() {
        return (this.country + this.liNumber).hashCode();
    }

    public boolean equals(Object compared) {
        if (this == compared) {
            return true;
        }
        if (!(compared instanceof LicensePlate)) {
            return false;
        }

        LicensePlate comparedLicensePlate = (LicensePlate) compared;

        if (this.liNumber.equals(comparedLicensePlate.liNumber) &&
                this.country.equals(comparedLicensePlate.country)) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return country + " " + liNumber;
    }

}
