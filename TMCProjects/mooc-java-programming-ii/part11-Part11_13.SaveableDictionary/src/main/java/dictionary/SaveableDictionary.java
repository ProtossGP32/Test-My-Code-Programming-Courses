package dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SaveableDictionary {
    private Map<String, String> dictionary;
    private File dictionaryFile = null;
    public SaveableDictionary() {
        this.dictionary = new HashMap<>();
    }

    public SaveableDictionary(String file) {
        // Invoke the non-parametric constructor
        this();
        // Don't load the dictionary yet, just initialize the file attribute
        this.dictionaryFile = new File(file);
    }

    public boolean load() {
        // Read the dictionaryFile and dump it into the dictionary map
        try (Scanner fileReader = new Scanner(this.dictionaryFile)) {
            while (fileReader.hasNext()) {
                String line = fileReader.nextLine();
                String[] parts = line.split(":");
                this.dictionary.putIfAbsent(parts[0], parts[1]);
            }
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean save() {
        // Write the dictionary map into the dictionaryFile
        try (PrintWriter writer = new PrintWriter(this.dictionaryFile)) {
            for (String word : this.dictionary.keySet()) {
                writer.println(word + ":" + this.dictionary.get(word));
            }
            return true;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void add(String words, String translation) {
        this.dictionary.putIfAbsent(words, translation);
    }

    public String translate(String word) {
        String translation = this.dictionary.getOrDefault(word, null);
        if (translation == null && this.dictionary.containsValue(word)) {
            for (String key : this.dictionary.keySet()) {
                if (this.dictionary.get(key).equals(word)) {
                    return key;
                }
            }
        }
        return translation;
    }

    // Part 2
    public void delete(String word) {
        if (this.dictionary.containsKey(word)) {
            this.dictionary.remove(word);
        } else if (this.dictionary.containsValue(word)) {
            for (String key : this.dictionary.keySet()) {
                if (this.dictionary.get(key).equals(word)) {
                    this.dictionary.remove(key);
                    break;
                }
            }
        }
    }
}
