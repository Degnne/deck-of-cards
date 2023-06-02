public class Main {
    public static void main(String[] args) {
        DeckOfCards deck = new DeckOfCards();
        deck.shuffle();
        HandOfCards hand = new HandOfCards();
        DiscardPile discardPile = new DiscardPile();
        hand.drawCards(deck, 7);
        for (PlayingCard cardInHand : hand.getHand()) {
            System.out.println(cardInHand.getRank() + " of " + cardInHand.getSuit());
        }
    }
}