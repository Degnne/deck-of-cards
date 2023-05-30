public class PlayingCard {

    private String suit;
    private String rank;

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    public String getColor() {
        if (suit.equals("Clubs") || suit.equals("Spades")) {
            return "Black";
        }
        return "Red";
    }

    public boolean isFaceCard() {
        if (rank.equals("Ace") || rank.equals("Jack") || rank.equals("Queen") || rank.equals("King")) {
            return true;
        }
        return false;
    }

    public PlayingCard (String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
