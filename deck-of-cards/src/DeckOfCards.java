import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckOfCards {

    private List<PlayingCard> deck = new ArrayList<PlayingCard>();

    public PlayingCard drawCard() {
        return deck.remove(0);
    }

    public boolean hasCards() {
        return deck.size() > 0;
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    public List<PlayingCard> getDeck() {
        return deck;
    }

    public int getDeckSize() {
        return deck.size();
    }

    public DeckOfCards() {
        for (PlayingCard.Suit suit : PlayingCard.Suit.values()) {
            for (PlayingCard.Rank rank : PlayingCard.Rank.values()) {
                deck.add(new PlayingCard(suit, rank));
            }
        }
    }
}
