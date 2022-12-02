
import java.util.ArrayList;
import java.util.Scanner;

public class Login {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> usernames = new ArrayList<>();
        ArrayList<String> passwords = new ArrayList<>();
        // Populate the username and password arrays
        usernames.add("alex");
        passwords.add("sunshine");
        usernames.add("emma");
        passwords.add("haskell");
        // Ask for username and password entry
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();

        // Check if credentials are correct
        boolean isLoggedIn = false;
        if (usernames.contains(username)) {
            int usernameIdx = usernames.indexOf(username);
            if (passwords.get(usernameIdx).equals(password)) {
                isLoggedIn = true;
            }
        }
        // Return log in status
        if (isLoggedIn) {
            System.out.println("You have successfully logged in!");
        } else {
            System.out.println("Incorrect username or password!");
        }
    }
}
