package dictionary;

public class Main {
    public static void main(String[] args) {
        // You can test your dictionary here
        // Part 1: Basic functionality
        SaveableDictionary dictionary = new SaveableDictionary();
        System.out.println("Part 1:");
        dictionary.add("apina", "monkey");
        dictionary.add("banaani", "banana");
        dictionary.add("apina", "apfe");

        System.out.println(dictionary.translate("apina"));
        System.out.println(dictionary.translate("monkey"));
        System.out.println(dictionary.translate("ohjelmointi"));
        System.out.println(dictionary.translate("banana"));

        // Part 2
        System.out.println();
        System.out.println("Part 2:");
        dictionary.add("apina", "monkey");
        dictionary.add("banaani", "banana");
        dictionary.add("apina", "apfe");
        dictionary.add("ohjelmointi", "programming");
        dictionary.delete("apina");
        dictionary.delete("banana");

        System.out.println(dictionary.translate("apina"));
        System.out.println(dictionary.translate("monkey"));
        System.out.println(dictionary.translate("banana"));
        System.out.println(dictionary.translate("banaani"));
        System.out.println(dictionary.translate("ohjelmointi"));

        // Part 3: Reading from file
        System.out.println();
        System.out.println("Part 2:");
        SaveableDictionary fileDictionary = new SaveableDictionary("words.txt");
        boolean wasSuccessful = fileDictionary.load();

        if (wasSuccessful) {
            System.out.println("Successfully loaded the dictionary from file");
        }

        System.out.println(fileDictionary.translate("apina"));
        System.out.println(fileDictionary.translate("ohjelmointi"));
        System.out.println(fileDictionary.translate("alla oleva"));
    }
}
