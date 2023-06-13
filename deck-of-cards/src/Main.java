
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
            case(0):
                //TODO: End This Submenu
                break;
        }
    }

    public void shuffleDeck() {
        game.shuffleDeck();
    }

    public void drawCards() {
        int numberOfCards = menu.displayDrawCardsPrompt(game.getDeck().getDeckSize());
        game.drawCards(numberOfCards);
        menu.displayDrawCardsSuccessful(numberOfCards);
    }

    public void lookAtHand() {
        menu.displayHand(game.getHand());
        menu.displayHandMenu();
        //int userSelection = menu.getUserInput();
        //processHandMenuSelection(userSelection);
    }

    public void lookAtDiscard() {
        menu.displayDiscard(game.getDiscardPile());
    }

    public void discardCards() {
        //TODO: How to handle discarding cards?
    }

    public void endProgram() {
        System.exit(0);
    }
}