public class Cat extends Animal{
    // Part 3
    public Cat(String name) {
        super(name);
    }

    public Cat() {
        this("Cat");
    }

    public void purr() {
        System.out.println(this.getName() + " purrs");
    }


    @Override
    public void makeNoise() {
        this.purr();
    }
}
