import java.util.Scanner;

public class UserInterface {
    private TodoList todoList;
    private Scanner scanner;

    public UserInterface(TodoList todoList, Scanner scanner) {
        this.todoList = todoList;
        this.scanner = scanner;
    }

    public void start() {
        while (true) {
            System.out.print("Command: ");
            String command = this.scanner.nextLine();
            if (command.equals("stop")) {
                break;
            } else if (command.equals("add")) {
                // Add new task to the to-do list
                this.addTask();
            } else if (command.equals("list")) {
                // Print all the tasks on the to-do list
                this.listTasks();
            } else if (command.equals("remove")) {
                // Remove the task in the to-do list based on its ID (index)
                this.removeTask();
            } else {
                System.out.println("Unknown command");
            }
        }
    }

    public void addTask() {
        System.out.print("To add: ");
        String newTask = this.scanner.nextLine();
        this.todoList.add(newTask);
    }

    public void listTasks() {
        this.todoList.print();
    }

    public void removeTask() {
        System.out.print("Which one is removed? ");
        int removeIndex = Integer.parseInt(this.scanner.nextLine());
        this.todoList.remove(removeIndex);
    }
}
