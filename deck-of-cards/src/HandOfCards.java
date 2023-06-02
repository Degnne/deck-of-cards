import java.util.ArrayList;
import java.util.List;

public class HandOfCards {

    private List<PlayingCard> hand;

    public HandOfCards() {
        hand = new ArrayList<PlayingCard>();
    }

    public int getHandSize() {
        return hand.size();
    }

    public List<PlayingCard> getHand() {
        return hand;
    }

    public void drawCards(DeckOfCards deckToDrawFrom, int numberOfCards) {
        for (int i = 0; i < numberOfCards; i++) {
            if (deckToDrawFrom.hasCards()) {
                hand.add(deckToDrawFrom.drawCard());
            }
            else {
                break;
            }
        }
    }

    public void discardCard(DiscardPile discardPile, PlayingCard cardToDiscard) {
        discardPile.discardCard(cardToDiscard);
    }

    public void discardRandomCard(DiscardPile discardPile) {
        discardCard(discardPile, hand.get((int)(Math.random() * hand.size())));
    }
}
