public class Dog extends Animal{
    public Dog(String name) {
        super(name);
    }

    public Dog() {
        this("Dog");
    }

    public void bark() {
        System.out.println(this.getName() + " barks");
    }

    @Override
    public void makeNoise() {
        this.bark();
    }
}
