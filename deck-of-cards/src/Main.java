import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    private Game game = new Game();
    private Menu menu = new Menu();

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    public void run() {
        while (true) {
            menu.displayDeckHandDiscardStats(game.getDeck().getDeckSize(),
                    game.getHand().getHandSize(), game.getDiscardPile().getDiscardPileSize());
            processMainMenuSelection(menu.displayMainMenu());
        }
    }

    public void processMainMenuSelection(int userSelection) {
        switch (userSelection) {
            case (1):
                drawCards();
                break;
            case (2):
                lookAtHand();
                break;
            case (3):
                lookAtDiscard();
                break;
            case (0):
                endProgram();
                break;
        }
    }

    public void processHandMenuSelection(int userSelection) {
        switch (userSelection) {
            case (1):
                drawCards();
                break;
            case (2):
                discardCards();
                break;
            case (3):
                discardHand();
                break;
            case(0):
                //TODO: End This Submenu
                break;
        }
    }

    public void drawCards() {
        int numberOfCards = menu.displayDrawCardsPrompt(game.getDeck().getDeckSize());
        game.drawCards(numberOfCards);
        menu.displayDrawCardsSuccessful(numberOfCards);
    }

    public void lookAtHand() {
        menu.displayHand(game.getHand());
        int userSelection = menu.displayHandMenu();
        processHandMenuSelection(userSelection);
    }

    public void lookAtDiscard() {
        menu.displayDiscard(game.getDiscardPile());
    }

    public void discardCards() {
        Map<Integer, String> handCards = new LinkedHashMap<Integer, String>();
        for (int i = 1; i <= game.getHand().getHandSize(); i++) {
            handCards.put(i, game.getHand().getHand().get(i - 1).toString());
        }
        int userSelection = menu.displayHandForDiscarding(handCards);
        game.discardCard(game.getHand().getHand().get(userSelection - 1));
    }

    public void discardHand() {
        game.discardHand();
    }

    public void endProgram() {
        System.exit(0);
    }
}