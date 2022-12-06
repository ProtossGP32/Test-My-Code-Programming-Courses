
public class HealthStation {

    private int numberOfWeighs;

    public HealthStation() {
        this.numberOfWeighs = 0;
    }

    public int weigh(Person person) {
        // return the weight of the person passed as the parameter
        ++this.numberOfWeighs;
        return person.getWeight();
    }

    public void feed(Person person) {
        person.setWeight(person.getWeight() + 1);
    }

    public int weighings() {
        return this.numberOfWeighs;
    }
}
