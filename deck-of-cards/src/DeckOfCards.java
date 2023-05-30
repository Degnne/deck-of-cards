import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckOfCards {

    private List<PlayingCard> deck = new ArrayList<PlayingCard>();

    public void shuffle() {
        Collections.shuffle(deck);
    }

    public List<PlayingCard> getDeck() {
        return deck;
    }

    public DeckOfCards() {
        for (int i = 0; i < 4; i++) {
            String suit = "";
            switch (i) {
                case 0: suit = "Spades"; break;
                case 1: suit = "Hearts"; break;
                case 2: suit = "Clubs"; break;
                case 3: suit = "Diamonds"; break;
            }
            for (int j = 1; j <= 13; j++) {
                String rank = "";
                switch (j) {
                    case 1: rank = "Ace"; break;
                    case 2: rank = "Two"; break;
                    case 3: rank = "Three"; break;
                    case 4: rank = "Four"; break;
                    case 5: rank = "Five"; break;
                    case 6: rank = "Six"; break;
                    case 7: rank = "Seven"; break;
                    case 8: rank = "Eight"; break;
                    case 9: rank = "Nine"; break;
                    case 10: rank = "Ten"; break;
                    case 11: rank = "Jack"; break;
                    case 12: rank = "Queen"; break;
                    case 13: rank = "King"; break;
                }
                deck.add(new PlayingCard(suit, rank));
            }
        }
    }
}
