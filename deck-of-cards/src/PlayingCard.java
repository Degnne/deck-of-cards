public class PlayingCard {

    public enum Suit {
        SPADE,
        HEART,
        CLUB,
        DIAMOND
    }

    public enum Rank {
        ACE,
        ONE,
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        JACK,
        QUEEN,
        KING
    }

    private Suit suit;
    private Rank rank;

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public String getColor() {
        if (suit == Suit.SPADE || suit ==Suit.CLUB) {
            return "Black";
        }
        return "Red";
    }

    public boolean isFaceCard() {
        return rank == Rank.ACE || rank == Rank.KING || rank == Rank.QUEEN || rank == Rank.JACK;
    }

    public int getCardValue(boolean acesHigh) {
        if (rank == Rank.ACE) {
            if (acesHigh) {
                return 14;
            } else {
                return 1;
            }
        }
        switch (rank) {
            case ONE: return 1;
            case TWO: return 2;
            case THREE: return 3;
            case FOUR: return 4;
            case FIVE: return 5;
            case SIX: return 6;
            case SEVEN: return 7;
            case EIGHT: return 8;
            case NINE: return 9;
            case TEN: return 10;
            case JACK: return 11;
            case QUEEN: return 12;
            case KING: return 13;
        }
        return 0;
    }

    public int getCardValue(boolean acesHigh, boolean faceCardIsTen) {
        if (faceCardIsTen && isFaceCard()) {
            return 10;
        } else {
            return getCardValue(acesHigh);
        }
    }

    public PlayingCard (Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
