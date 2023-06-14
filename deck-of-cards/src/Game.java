public class Game {

    private DeckOfCards deck = new DeckOfCards();
    private HandOfCards hand = new HandOfCards();
    private DiscardPile discardPile = new DiscardPile();

    public Game() {
        deck.shuffle();
    }

    public DeckOfCards getDeck() {
        return deck;
    }

    public HandOfCards getHand() {
        return hand;
    }

    public DiscardPile getDiscardPile() {
        return discardPile;
    }

    public void shuffleDeck() {
        deck.shuffle();
    }

    public void drawCards(int numberOfCards) {
        hand.drawCards(deck, numberOfCards);
    }

    public void discardHand() {
        hand.discardHand(discardPile);
    }

    public void discardCard(PlayingCard card) {
        hand.discardCard(discardPile, card);
    }
}
