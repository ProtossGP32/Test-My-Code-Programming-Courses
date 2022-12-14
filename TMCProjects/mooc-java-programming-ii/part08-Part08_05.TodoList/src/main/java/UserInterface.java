import java.util.Scanner;

public class UserInterface {
    private TodoList list;
    private Scanner scanner;

    public UserInterface(TodoList list, Scanner scanner) {
        this.list = list;
        this.scanner = scanner;
    }

    public void addCommand() {
        System.out.print("To add: ");
        String exercise = this.scanner.nextLine();
        this.list.add(exercise);
    }

    private void listCommand() {
        this.list.print();
    }

    private void removeCommand() {
        System.out.print("Which one is removed? ");
        int number = this.scanner.nextInt();
        this.list.remove(number);
    }

    public void start() {
        while (true) {
            System.out.print("Command: ");
            String command = this.scanner.nextLine();
            if (command.equals("stop")) {
                break;
            }

            switch(command) {
                case "add":
                    addCommand();
                    break;
                case "list":
                    listCommand();
                    break;
                case "remove":
                    removeCommand();
                    break;
                default:
                    System.out.println("Unknown command");
                    break;
            }
        }
    }
}
