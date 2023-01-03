import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Employees {
    private List<Person> persons;

    public Employees() {
        this.persons = new ArrayList<>();
    }

    public void add(Person personToAdd) {
        if (!this.persons.contains(personToAdd)) {
            this.persons.add(personToAdd);
        }
    }

    public void add(List<Person> peopleToAdd) {
        for (Person newPerson : peopleToAdd) {
            this.add(newPerson);
        }
    }

    public void print() {
        // An Iterator must be used here!
        Iterator<Person> personIterator = this.persons.iterator();
        while (personIterator.hasNext()) {
            System.out.println(personIterator.next());
        }
    }

    public void print(Education education) {
        // An Iterator must be used here!
        Iterator<Person> personIterator = this.persons.iterator();
        while (personIterator.hasNext()) {
            Person currentPerson = personIterator.next();
            if (currentPerson.getEducation().equals(education)) {
                System.out.println(currentPerson);
            }
        }
    }

    // Part 4
    public void fire(Education education) {
        // An Iterator must be used here!
        Iterator<Person> personIterator = this.persons.iterator();
        while (personIterator.hasNext()) {
            // In this case we don't save the value of the current person
            // as we don't have to do anything with it
            if (personIterator.next().getEducation().equals(education)) {
                personIterator.remove();
            }
        }
    }
}
