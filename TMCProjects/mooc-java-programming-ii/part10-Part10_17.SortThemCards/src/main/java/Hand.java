import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Hand implements Comparable<Hand> {
    // Part 2
    private List<Card> cardList;

    public Hand() {
        this.cardList = new ArrayList<>();
    }
    public void add(Card card) {
        this.cardList.add(card);
    }

    public void print() {
        Iterator<Card> cardIterator = this.cardList.iterator();
        while (cardIterator.hasNext()) {
            System.out.println(cardIterator.next());
        }
    }

    // Part 3
    public void sort() {
        // Using stream to create a new sorted list.
        // sorted() is using the compareTo overridden method in Card class
        this.cardList = this.cardList.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    @Override
    public int compareTo(Hand o) {
        // The best hand is the one with the highest sum of cards' values
        int thisHand = this.cardList.stream()
                .mapToInt(card -> card.getValue())
                .sum();

        int comparedHand = o.cardList.stream()
                .mapToInt(card -> card.getValue())
                .sum();
        return thisHand - comparedHand;
    }

    // Part6: Sorting the hand by suit
    public void sortBySuit() {
        BySuitInValueOrder sortBySuitSorter = new BySuitInValueOrder();
        Collections.sort(this.cardList, sortBySuitSorter);
    }
}
