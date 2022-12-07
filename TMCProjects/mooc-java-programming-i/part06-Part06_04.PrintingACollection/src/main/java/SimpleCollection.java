
import java.util.ArrayList;

public class SimpleCollection {

    private String name;
    private ArrayList<String> elements;

    public SimpleCollection(String name) {
        this.name = name;
        this.elements = new ArrayList<>();
    }

    public void add(String element) {
        this.elements.add(element);
    }

    public ArrayList<String> getElements() {
        return this.elements;
    }

    public String toString() {
        String answer = "The collection " + this.name;
        int elementsSize = this.getElements().size();
        if (elementsSize == 0) {
            return answer + " is empty.";
        }
        // If not empty, compose the rest of the message
        answer += " has " + elementsSize + " element";
        if (elementsSize == 1) {
            answer += ":";
        } else {
            answer += "s:";
        }

        for (String element : elements) {
            answer += "\n" + element;
        }
        return answer;
    }
    
}
