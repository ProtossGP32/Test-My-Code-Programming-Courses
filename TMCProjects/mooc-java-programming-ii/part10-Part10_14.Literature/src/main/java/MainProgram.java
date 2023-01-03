
import java.util.*;

public class MainProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Book> books = readBooks(scanner);
        orderByAgeRecommendationAndName(books);
        printBooks(books);
    }

    public static List<Book> readBooks(Scanner scanner) {
        List<Book> books = new ArrayList<>();
        ArrayList<String> bookInfo = new ArrayList<>();
        while (true) {
            if (bookInfo.isEmpty()) {
                System.out.print("Input the name of the book, empty stops: ");
            } else {
                System.out.print("Input the age recommendation: ");
            }
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                bookInfo.clear();
                break;
            }
            bookInfo.add(input);
            if (bookInfo.size() == 2) {
                books.add(new Book(bookInfo.get(0), Integer.parseInt(bookInfo.get(1))));
                bookInfo.clear();
                System.out.println("");
            }
        }

        return books;
    }

    public static void orderByAgeRecommendationAndName(List<Book> books) {
        Comparator<Book> ageComparator = Comparator
                .comparing(Book::getAgeRecommendation)
                .thenComparing(Book::getName);

        Collections.sort(books, ageComparator);
    }
    public static void printBooks(List<Book> books) {
        System.out.println(books.size() + " books in total.");
        System.out.println("");
        System.out.println("Books:");
        books.stream()
                .forEach(book -> System.out.println(book));
    }
}
