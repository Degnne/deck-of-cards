import java.util.ArrayList;
import java.util.List;

public class DiscardPile {

    private List<PlayingCard> discard;

    public DiscardPile() {
        discard = new ArrayList<PlayingCard>();
    }

    public void discardCard(PlayingCard cardToDiscard) {
        discard.add(cardToDiscard);
    }

    public List<PlayingCard> getDiscard() {
        return discard;
    }

    public int getDiscardPileSize() {
        return discard.size();
    }
}
