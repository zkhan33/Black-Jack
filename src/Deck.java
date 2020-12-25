
import java.util.ArrayList;

public class Deck {

    protected ArrayList<Card> deck = new ArrayList<Card>();

    public Deck() {
        for (int i = 1; i <= 13; i++) {
            for (int j = 0; j < 4; j++) {
                if (j == 0) {
                    deck.add(new Card("\u2665", i));

                } else if (j == 1) {
                    deck.add(new Card("\u2666", i));

                } else if (j == 2) {
                    deck.add(new Card("\u2660", i));

                } else if (j == 3) {
                    deck.add(new Card("\u2663", i));
                }
            }
        }

    }
}
