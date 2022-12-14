import java.util.ArrayList;

public class TodoList {
    private ArrayList<Task> tasks;

    public TodoList() {
        this.tasks = new ArrayList<>();
    }

    public boolean contains(String name) {
        for (Task task : this.tasks) {
            if (task.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void add(String task) {
        if (!this.contains(task)) {
            this.tasks.add(new Task(task));
        }
    }

    public void print() {
        for (int i = 1; i <= this.tasks.size(); i++) {
            System.out.println(i + ": " + this.tasks.get(i - 1));
        }
    }

    public void remove(int number) {
        if (number > 0 && number <= this.tasks.size()) {
            this.tasks.remove(number - 1);
        }
    }
}
