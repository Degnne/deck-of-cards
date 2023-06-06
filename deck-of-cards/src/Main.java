import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private DeckOfCards deck = new DeckOfCards();
    private HandOfCards hand = new HandOfCards();
    private DiscardPile discardPile = new DiscardPile();
    private Map<Integer, String> menu = new HashMap<>();
    private Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    public void run() {
        shuffleDeck();
        buildMenu();
        while (true) {
            displayMenu();
            int userSelection;
            while (true) {
                while (true) {
                    System.out.print("What would you like to do? >>> ");
                    String selectionFromUser = userInput.nextLine();

                    try {
                        userSelection = Integer.parseInt(selectionFromUser);
                        validateUserInput(new int[]{1, 2, 3, 0}, userSelection);
                        break;
                    } catch (NumberFormatException | UserSelectionOutOfBoundsException e) {
                        System.out.println("Please enter a valid number.");
                    }
                }
                processMenuSelection(userSelection);
                displayMenu();
            }
        }
    }

    public void buildMenu() {
        menu.put(1, "Draw Cards");
        menu.put(2, "Look at Your Hand");
        menu.put(3, "Look at the Discard Pile");
        menu.put(0, "Quit Program");
    }

    public void displayMenu() {
        System.out.println("There are " + numberOfCardsToString(deck.getDeckSize()) + " in the deck, " +
                numberOfCardsToString(hand.getHandSize()) + " in your hand, and " +
                numberOfCardsToString(discardPile.getDiscardPileSize()) + " in the discard pile.");
       for (Map.Entry<Integer, String> entry : menu.entrySet()) {
           System.out.println("[" + entry.getKey() + "] " + entry.getValue());
       }
    }

    public void processMenuSelection(int userSelection) {
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
        deck.shuffle();
    }

    public void drawCards() {
        System.out.print("How many cards would you like to draw? >>> ");
        int numberOfCards;
        while (true) {
            String numberFromUser = userInput.nextLine();
            try {
                numberOfCards = Integer.parseInt(numberFromUser);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
        hand.drawCards(deck, numberOfCards);
        System.out.println("You drew " + numberOfCardsToString(numberOfCards) + ".");
    }

    public void lookAtHand() {
        for (PlayingCard card : hand.getHand()) {
            System.out.println(card);
        }
    }

    public void lookAtDiscard() {
        for (PlayingCard card: discardPile.getDiscard()) {
            System.out.println(card);
        }
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