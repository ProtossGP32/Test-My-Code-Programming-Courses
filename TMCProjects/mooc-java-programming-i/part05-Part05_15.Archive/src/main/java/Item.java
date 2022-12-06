public class Item {
    private String identifier;
    private String name;

    public Item(String identifier, String name) {
        this.identifier = identifier;
        this.name = name;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getName() {
        return name;
    }

    public boolean equals(Object compared) {
        if (this == compared) {
            return true;
        }

        if (!(compared instanceof Item)) {
            return false;
        }

        Item comparedItem = (Item) compared;

        // Only the identifyer is used to consider both items the same
        if (this.getIdentifier().equals(comparedItem.getIdentifier())) {
            return true;
        }

        return false;
    }

    public String toString() {
        return this.getIdentifier() + ": " + this.getName();
    }
}

