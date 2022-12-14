import java.util.HashMap;

public class Abbreviations {
    HashMap<String, String> abbreviations;

    public Abbreviations() {
        this.abbreviations = new HashMap<>();
    }

    public boolean hasAbbreviation(String abbreviation) {
        abbreviation = sanitizedString(abbreviation);
        if (this.abbreviations.containsKey(abbreviation)) {
            return true;
        }
        return false;
    }
    public void addAbbreviation(String abbreviation, String explanation) {
        abbreviation = sanitizedString(abbreviation);
        if (!this.hasAbbreviation(abbreviation)) {
            this.abbreviations.put(abbreviation, explanation);
        }
    }

    public String findExplanationFor(String abbreviation) {
        abbreviation = sanitizedString(abbreviation);
        if (this.hasAbbreviation(abbreviation)) {
            return this.abbreviations.get(abbreviation);
        }
        return null;
    }

    public static String sanitizedString(String string) {
        if (string == null) {
            return "";
        }

        string = string.toLowerCase();
        return string.trim();
    }
}
