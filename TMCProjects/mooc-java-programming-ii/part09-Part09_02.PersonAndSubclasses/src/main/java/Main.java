import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // Part 1: Person
        System.out.println("Part 1: Person");
        Person ada = new Person("Ada Lovelace", "24 Maddox St. London W1S 2QN");
        Person esko = new Person("Esko Ukkonen", "Mannerheimintie 15 00100 Helsinki");
        System.out.println(ada);
        System.out.println(esko);

        // Part 2 and 3: Student
        System.out.println("Part 2 and 3: Student");
        Student ollie = new Student("Ollie", "6381 Hollywood Blvd. Los Angeles 90028");
        System.out.println(ollie);
        ollie.study();
        System.out.println(ollie);

        // Part 4: Teacher
        System.out.println("Part 4: Teacher");
        Teacher ada2 = new Teacher("Ada Lovelace", "24 Maddox St. London W1S 2QN", 1200);
        Teacher esko2 = new Teacher("Esko Ukkonen", "Mannerheimintie 15 00100 Helsinki", 5400);
        System.out.println(ada2);
        System.out.println(esko2);

        Student ollie2 = new Student("Ollie", "6381 Hollywood Blvd. Los Angeles 90028");

        int i = 0;
        while (i < 25) {
          ollie2.study();
          i = i + 1;
        }
        System.out.println(ollie2);

        // Part 5: List all Persons
        System.out.println("Part 5: List all persons");
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(ada);
        persons.add(esko);
        persons.add(ollie);
        persons.add(ada2);
        persons.add(esko2);
        persons.add(ollie2);
        printPersons(persons);

    }

    public static void printPersons(ArrayList<Person> persons) {
        for (Person person : persons) {
            System.out.println(person);
        }
    }

}
