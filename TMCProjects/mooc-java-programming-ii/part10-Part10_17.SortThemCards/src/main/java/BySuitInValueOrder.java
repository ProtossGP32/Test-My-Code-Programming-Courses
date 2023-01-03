import java.util.Comparator;

// Part 5: Sorting cards with different criteria
public class BySuitInValueOrder implements Comparator<Card> {
    @Override
    public int compare(Card c1, Card c2) {
        // Sorting priority is suit; if they are equal then sort by value
        int suitOrder = c1.getSuit().ordinal() - c2.getSuit().ordinal();
        int valueOrder = c1.getValue() - c2.getValue();
        if (suitOrder == 0) {
            return valueOrder;
        }
        return suitOrder;
    }
}
