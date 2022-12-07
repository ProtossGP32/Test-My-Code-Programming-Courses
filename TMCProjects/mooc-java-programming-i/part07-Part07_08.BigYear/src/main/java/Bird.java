public class Bird {
    private String name;
    private String latin;

    private int observations;

    public Bird(String name, String latin) {
        this.name = name;
        this.latin = latin;
        this.observations = 0;
    }

    public void increaseWatch() {
        ++this.observations;
    }

    public boolean equals(String name) {
        return this.name.equals(name);
    }

    public boolean equals(Object compared) {
        // Check if they are exactly the same object
        if (this == compared) {
            return true;
        }
        // Check instance type
        if (!(compared instanceof Bird)) {
            return false;
        }

        Bird comparedBird = (Bird) compared;
        if (this.name.equals(comparedBird.name)) {
            return true;
        }
        // Else, they are different
        return false;
    }

    public String toString() {
        String plural = "s";
        if (this.observations == 1) {
            plural = "";
        }
        return this.name + " (" + this.latin + "): " + this.observations + " observation" + plural;
    }
}
