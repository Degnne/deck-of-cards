import java.util.*;

public class Menu {

    private Map<Integer, String> mainMenu = new LinkedHashMap<Integer, String>();
    private Map<Integer, String> handMenu = new LinkedHashMap<Integer, String>();
    private Scanner in = new Scanner(System.in);

    public Menu() {
        mainMenu.put(1, "Draw Cards");
        mainMenu.put(2, "Look at Your Hand");
        mainMenu.put(3, "Look at the Discard Pile");
        mainMenu.put(0, "Quit Program");

        handMenu.put(1, "Draw Cards");
        handMenu.put(2, "Discard Cards");
        handMenu.put(0, "Back");
    }

    public int displayMainMenu() {
        displayMenu(mainMenu);
        return getMenuInput(mainMenu);
    }

    public void displayHandMenu() {
        displayMenu(handMenu);
    }

    public String getUserInput() {
        System.out.print("Please choose an option: ");
        return in.nextLine();
    }

    public void displayDeckHandDiscardStats(int numberOfCardsInDeck, int numberOfCardsInHand, int numberOfCardsInDiscard) {
        System.out.println("Cards in the deck: " + numberOfCardsInDeck);
        System.out.println("Cards in your hand: " + numberOfCardsInHand);
        System.out.println("Cads in the discard: " + numberOfCardsInDiscard);
    }

    public int displayDrawCardsPrompt(int deckSize) {
        while(true) {
            System.out.print("How many cards would you like to draw? ");
            try {
                int userSelection = Integer.parseInt(in.nextLine());
                if (userSelection < 0) {
                    throw new NumberFormatException();
                }
                if (userSelection <= deckSize) {
                    return userSelection;
                }
                System.out.println("There aren't enough cards in the deck!");
            } catch (NumberFormatException e) {
                System.out.println("That is an invalid number.");
            }
        }
    }

    public void displayDrawCardsSuccessful(int numberOfCardsDrawn) {
        System.out.println("You drew " + numberOfCardsToString(numberOfCardsDrawn) + "!");
        System.out.println();
    }

    public void displayHand(HandOfCards hand) {
        if (hand.getHandSize() > 0) {
            System.out.println("Your hand contains: ");
            displayListOfCards(hand.getHand());
        } else {
            System.out.println("You have no cards in your hand.");
        }
        System.out.println();
    }

    public void displayDiscard(DiscardPile discardPile) {
        if (discardPile.getDiscardPileSize() > 0) {
            System.out.println("The discard pile contains: ");
            displayListOfCards(discardPile.getDiscard());
        } else {
            System.out.println("There are no cards in the discard pile.");
        }
        System.out.println();
    }

    private void displayMenu(Map<Integer, String> menuToDisplay) {
        for (Map.Entry<Integer, String> entry : menuToDisplay.entrySet()) {
            System.out.println("[" + entry.getKey() + "] " + entry.getValue());
        }
    }

    private int getMenuInput(Map<Integer, String> menu) {
        while(true) {
            String userInputAsString = getUserInput();
            int userInput;
            try {
                userInput = Integer.parseInt(userInputAsString);
                validateUserInput(menu.keySet(), userInput);
                return userInput;
            } catch (UserSelectionOutOfBoundsException | NumberFormatException e) {
                System.out.println("That option is invalid.");
            }
        }
    }

    private void displayListOfCards(List<PlayingCard> cards) {
        for (PlayingCard card : cards) {
            System.out.println(card);
        }
    }

    private String numberOfCardsToString(int number) {
        String string = number + " card";
        if (number != 1) {
            string += "s";
        }
        return string;
    }

    private void validateUserInput(Set<Integer> availableSelections, int userSelection) throws UserSelectionOutOfBoundsException {
        for (int number: availableSelections) {
            if (number == userSelection) {
                return;
            }
        }
        throw new UserSelectionOutOfBoundsException();
    }
}
