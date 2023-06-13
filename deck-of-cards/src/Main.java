import java.util.Scanner;

public class Main {

    private Game game = new Game();
    private Menu menu = new Menu();
    private Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    public void run() {
        shuffleDeck();
        while (true) {
            menu.displayDeckHandDiscardStats(game.getDeck().getDeckSize(),
                    game.getHand().getHandSize(), game.getDiscardPile().getDiscardPileSize());
            menu.displayMainMenu();
            processMainMenuSelection(menu.getUserInput());
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

    public void shuffleDeck() {
        game.shuffleDeck();
    }

    public void drawCards() {
        int numberOfCards = menu.displayDrawCardsPrompt();
        game.drawCards(numberOfCards);
        menu.displayDrawCardsSuccessful(numberOfCards);
    }

    public void lookAtHand() {
        menu.displayHand(game.getHand());
        menu.displayHandMenu();
        int userSelection = menu.getUserInput();
    }

    public void lookAtDiscard() {
        menu.displayDiscard(game.getDiscardPile());
    }

    public boolean validateUserInput(int[] availableSelections, int userSelection) throws UserSelectionOutOfBoundsException {
        for (int number: availableSelections) {
            if (number == userSelection) {
                return true;
            }
        }
        throw new UserSelectionOutOfBoundsException();
    }

    public void endProgram() {
        System.exit(0);
    }
}