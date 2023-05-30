public class Main {
    public static void main(String[] args) {
        DeckOfCards deck = new DeckOfCards();
        deck.shuffle();
        for (PlayingCard card : deck.getDeck()) {
            System.out.println(card);
        }
    }
}