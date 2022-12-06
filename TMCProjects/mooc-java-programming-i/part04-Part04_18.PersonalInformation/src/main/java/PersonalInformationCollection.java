
import java.util.ArrayList;
import java.util.Scanner;

public class PersonalInformationCollection {

    public static void main(String[] args) {
        // implement here your program that uses the PersonalInformation class

        ArrayList<PersonalInformation> infoCollection = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Collect all personal information
        while (true) {
            // First name logic
            System.out.print("First name: ");
            String firstName = scanner.nextLine();
            if (firstName.isEmpty()) {
                System.out.println();
                break;
            }
            // Last name logic
            String lastName = "";
            while (lastName.isEmpty()) {
                System.out.print("Last name: ");
                lastName = scanner.nextLine();
                if (lastName.isEmpty()) {
                    System.out.println("Please enter a valid last name");
                }
            }
            // ID number logic
            String identificationNumber = "";
            while (identificationNumber.isEmpty()) {
                System.out.print("Identification number: ");
                identificationNumber = scanner.nextLine();
                if (identificationNumber.isEmpty()) {
                    System.out.println("Please enter a valid identification number");
                }
            }
            // Add personal information to list
            infoCollection.add(new PersonalInformation(firstName, lastName, identificationNumber));
        }

        // Print available personal information
        for (PersonalInformation user : infoCollection) {
            System.out.println(user.getFirstName() + " " + user.getLastName());
        }
    }
}
