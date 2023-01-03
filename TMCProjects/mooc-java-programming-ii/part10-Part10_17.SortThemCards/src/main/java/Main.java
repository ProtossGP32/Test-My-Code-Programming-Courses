import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        // test your code here

        Card first = new Card(2, Suit.DIAMOND);
        Card second = new Card(14, Suit.SPADE);
        Card third = new Card(12, Suit.HEART);

        System.out.println(first);
        System.out.println(second);
        System.out.println(third);

        // Part 3
        System.out.println("");
        System.out.println("Part 3:");
        Hand hand = new Hand();

        hand.add(new Card(2, Suit.DIAMOND));
        hand.add(new Card(14, Suit.SPADE));
        hand.add(new Card(12, Suit.HEART));
        hand.add(new Card(2, Suit.SPADE));

        hand.sort();

        hand.print();

        // Part 4: Comparing hands
        System.out.println("");
        System.out.println("Part 4: Comparing hands");
        Hand hand1 = new Hand();

        hand1.add(new Card(2, Suit.DIAMOND));
        hand1.add(new Card(14, Suit.SPADE));
        hand1.add(new Card(12, Suit.HEART));
        hand1.add(new Card(2, Suit.SPADE));

        Hand hand2 = new Hand();

        hand2.add(new Card(11, Suit.DIAMOND));
        hand2.add(new Card(11, Suit.SPADE));
        hand2.add(new Card(11, Suit.HEART));

        int comparison = hand1.compareTo(hand2);

        if (comparison < 0) {
            System.out.println("better hand is");
            hand2.print();
        } else if (comparison > 0){
            System.out.println("better hand is");
            hand1.print();
        } else {
            System.out.println("hands are equal");
        }

        // Part 5: Sorting with different criteria
        System.out.println("");
        System.out.println("Part 5: Sorting with different criteria");
        ArrayList<Card> cards = new ArrayList<>();

        cards.add(new Card(3, Suit.SPADE));
        cards.add(new Card(2, Suit.DIAMOND));
        cards.add(new Card(14, Suit.SPADE));
        cards.add(new Card(12, Suit.HEART));
        cards.add(new Card(2, Suit.SPADE));

        BySuitInValueOrder sortBySuitSorter = new BySuitInValueOrder();
        Collections.sort(cards, sortBySuitSorter);

        cards.stream().forEach(c -> System.out.println(c));

        // Part 6: Sorting the hand by suit
        System.out.println("");
        System.out.println("Part 6: Sorting the hand by suit");
        Hand hand6 = new Hand();

        hand6.add(new Card(12, Suit.HEART));
        hand6.add(new Card(4, Suit.SPADE));
        hand6.add(new Card(2, Suit.DIAMOND));
        hand6.add(new Card(14, Suit.SPADE));
        hand6.add(new Card(7, Suit.HEART));
        hand6.add(new Card(2, Suit.SPADE));

        hand6.sortBySuit();

        hand6.print();
    }
}
