public class Main {
    public static void main(String[] args) {
        DeckOfCards deck = new DeckOfCards();
        for (PlayingCard card : deck.getDeck()) {
            System.out.println(card);
        }
    }
}