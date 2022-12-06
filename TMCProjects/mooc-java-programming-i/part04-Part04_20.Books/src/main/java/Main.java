import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        // implement here the program that allows the user to enter 
        // book information and to examine them
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();

        // Retrieve books information until "title" is empty
        while (true) {
            System.out.print("Title: ");
            String title = scanner.nextLine();
            if (title.isEmpty()) {
                System.out.println("");
                break;
            }
            int pages = 0;
            while (pages <= 0) {
                System.out.print("Pages: ");
                pages = Integer.parseInt(scanner.nextLine());
                if (pages <= 0) {
                    System.out.println("Bad number of pages, try again.");
                }
            }
            int year = 0;
            while (year <= 0) {
                System.out.print("Year: ");
                year = Integer.parseInt(scanner.nextLine());
                if (year <= 0) {
                    System.out.println("Bad year, try again.");
                }
            }
            books.add(new Book(title, pages, year));
        }

        // Ask the user what to be printed
        System.out.print("What information will be printed? ");
        String infoLevel = scanner.nextLine();
        for (Book book : books) {
            book.printDetails(infoLevel);
        }
    }
}
