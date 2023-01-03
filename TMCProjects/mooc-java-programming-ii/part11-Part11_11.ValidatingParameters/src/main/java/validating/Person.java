package validating;

public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        if (name == null || name.isEmpty() || name.length() > 40) {
            throw new IllegalArgumentException("Bad name entry, can't be empty, null or over 40 chars: " + name);
        }
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Bad age entry, must be between 0 and 120: " + age);
        }
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
