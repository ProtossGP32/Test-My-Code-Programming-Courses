
import java.util.Scanner;

public class LiquidContainers2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Container first = new Container();
        Container second = new Container();

        while (true) {
            System.out.println("First: " + first);
            System.out.println("Second: " + second);
            System.out.print("> ");

            String input = scan.nextLine();
            System.out.println();
            if (input.equals("quit")) {
                break;
            }
            String[] inputSplit = input.split(" ");
            int amount = Integer.parseInt(inputSplit[1]);
            if (amount > 0) {
                switch(inputSplit[0]) {
                    case "add":
                        first.add(amount);
                        break;
                    case "move":
                        if (amount <= first.contains()) {
                            first.remove(amount);
                            second.add(amount);
                        } else {
                            second.add(first.contains());
                            first.remove(first.contains());
                        }
                        break;
                    case "remove":
                        second.remove(amount);
                        break;
                    default:
                        System.out.println("Unknown command");
                        break;
                }
            }

        }
    }

}
