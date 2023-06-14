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

    public void discardHand(DiscardPile discardPile) {
        //TODO fix this!
        for (int i = 0; i < hand.size(); i++) {
            discardCard(discardPile, hand.get(i));
        }
    }

    public void discardCard(DiscardPile discardPile, PlayingCard cardToDiscard) {
        hand.remove(cardToDiscard);
        discardPile.discardCard(cardToDiscard);
    }

    public void discardRandomCard(DiscardPile discardPile) {
        discardCard(discardPile, hand.get((int)(Math.random() * hand.size())));
    }
}
