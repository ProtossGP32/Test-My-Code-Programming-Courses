public class Person {
    // Part 2
    private String name;
    private Education education;

    public Person(String name, Education education) {
        this.name = name;
        this.education = education;
    }

    public Education getEducation() {
        return this.education;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.getEducation();
    }

    @Override
    public boolean equals(Object compared) {
        if (this == compared) {
            return true;
        }
        if (!(compared instanceof Person)) {
            return false;
        }

        Person comparedPerson = (Person) compared;

        if (this.name.equals(comparedPerson.name)
                && this.getEducation().equals(comparedPerson.getEducation())) {
            return true;
        }

        return false;
    }
}
