import java.util.Scanner;

public class TextUI {
    private Scanner scanner;
    private SimpleDictionary dictionary;

    public TextUI(Scanner scanner, SimpleDictionary dictionary) {
        this.scanner = scanner;
        this.dictionary = dictionary;
    }

    public void start() {

        while (true) {
            System.out.print("Command: ");
            String userInput = this.scanner.nextLine();
            if (userInput.equals("end")) {
                System.out.println("Bye bye!");
                break;
            } else if (userInput.equals("add")) {
                System.out.print("Word: ");
                String newWord = this.scanner.nextLine();
                System.out.print("Translation: ");
                String newTranslation = this.scanner.nextLine();
                if (!newWord.isEmpty() && !newTranslation.isEmpty()) {
                    this.dictionary.add(newWord, newTranslation);
                }
            } else if (userInput.equals("search")) {
                System.out.print("To be translated: ");
                String wordToTranslate = this.scanner.nextLine();
                String translatedWord = this.dictionary.translate(wordToTranslate);
                if (translatedWord == null) {
                    System.out.println("Word " + wordToTranslate + " was not found");
                } else {
                    System.out.println("Translation: " + translatedWord);
                }
            } else {
                System.out.println("Unknown command");
            }
        }
    }
}
