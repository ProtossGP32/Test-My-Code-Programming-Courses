import java.util.ArrayList;
import java.util.Scanner;

public class BirdsObservatory {
    private ArrayList<Bird> birds;
    private Scanner scanner;

    public BirdsObservatory(Scanner scanner) {
        this.birds = new ArrayList<>();
        this.scanner = scanner;
    }

    public boolean contains(Bird newBird) {
        for (Bird bird : this.birds) {
            if (bird.equals(newBird)) {
                return true;
            }
        }
        return false;
    }

    public void addBird() {
        while (true) {
            System.out.print("Name: ");
            String name = this.scanner.nextLine();
            if (name.isEmpty()) {
                System.out.println("Please insert a valid name");
                continue;
            }
            System.out.print("Name in latin: ");
            String latin = this.scanner.nextLine();
            if (latin.isEmpty()) {
                System.out.println("Please insert a valid latin name");
                continue;
            }
            // Add the new bird if it doesn't already exist in the list
            Bird newBird = new Bird(name, latin);
            if (!this.contains(newBird)) {
                this.birds.add(newBird);
            }
            // Get out of the loop
            break;
        }
    }

    public void observation() {
        String name;
        while (true) {
            System.out.print("Bird? ");
            name = this.scanner.nextLine();
            if (name.isEmpty()) {
                System.out.println("Please insert a valid name");
                continue;
            }

            // Check if the name of the bird exists in the birds list
            boolean birdFound = false;
            for (Bird bird : birds) {
                if (bird.equals(name)) {
                    bird.increaseWatch();
                    birdFound = true;
                    break;
                }
            }
            if (!birdFound) {
                System.out.println("Not a bird!");
            }
            break;
        }
    }

    private void printOneBird() {
        System.out.print("Bird? ");
        String name = this.scanner.nextLine();
        boolean birdFound = false;
        for (Bird bird : this.birds) {
            if (bird.equals(name)) {
                System.out.println(bird);
                birdFound = true;
                break;
            }
        }
        if (!birdFound) {
            System.out.println("Not a bird!");
        }
    }

    private void printAllBirds() {
        for (Bird bird : this.birds) {
            System.out.println(bird);
        }
    }

    public void start() {
        /*
        Expected commands:
        - Add: adds a bird
        - Observation: adds an observation
        - All: prints all birds
        - One: prints one bird
        - Quit: ends the program
        */
        while (true) {
            System.out.print("? ");
            String command = this.scanner.nextLine();
            if (command.equals("Quit")) {
                break;
            }
            switch (command){
                case "Add":
                    this.addBird();
                    break;
                case "Observation":
                    this.observation();
                    break;
                case "All":
                    this.printAllBirds();
                    break;
                case "One":
                    this.printOneBird();
                    break;
                default:
                    System.out.println("Unknown command");
                    break;
            }
        }
    }
}
