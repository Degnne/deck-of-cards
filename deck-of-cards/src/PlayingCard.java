public class PlayingCard {

    private String suit;
    private String rank;

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
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
