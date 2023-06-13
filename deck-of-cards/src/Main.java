import java.util.Scanner;

public class Main {

    private DeckOfCards deck = new DeckOfCards();
    private HandOfCards hand = new HandOfCards();
    private DiscardPile discardPile = new DiscardPile();
    private Menu menu = new Menu();
    private Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    public void run() {
        shuffleDeck();
        while (true) {
            menu.displayDeckHandDiscardStats(deck.getDeckSize(), hand.getHandSize(), discardPile.getDiscardPileSize());
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
            case (9):
                endProgram();
                break;
        }
    }

    public void shuffleDeck() {
        deck.shuffle();
    }

    public void drawCards() {
        int numberOfCards = menu.displayDrawCardsPrompt();
    }

    public void lookAtHand() {

    }

    public void lookAtDiscard() {

    }

    public boolean validateUserInput(int[] availableSelections, int userSelection) throws UserSelectionOutOfBoundsException {
        for (int number: availableSelections) {
            if (number == userSelection) {
                return true;
            }
        }
        throw new UserSelectionOutOfBoundsException();
    }

    public String numberOfCardsToString(int number) {
        String string = number + " card";
        if (number != 1) {
            string += "s";
        }
        return string;
    }

    public void endProgram() {
        System.exit(0);
    }
}