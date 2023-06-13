import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

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

    public void displayMainMenu() {
        displayMenu(mainMenu);
    }

    public void displayHandMenu() {
        displayMenu(handMenu);
    }

    public int getUserInput() {
        System.out.print("Please choose an option: ");
        int userSelection = Integer.parseInt(in.nextLine());
        return userSelection;
    }

    public void displayDeckHandDiscardStats(int numberOfCardsInDeck, int numberOfCardsInHand, int numberOfCardsInDiscard) {
        System.out.println("Cards in the deck: " + numberOfCardsInDeck);
        System.out.println("Cards in your hand: " + numberOfCardsInHand);
        System.out.println("Cads in the discard: " + numberOfCardsInDiscard);
    }

    public int displayDrawCardsPrompt() {
        System.out.print("How many cards would you like to draw? ");
        int userSelection = Integer.parseInt(in.nextLine());
        return userSelection;
    }

    public void displayDrawCardsSuccessful(int numberOfCardsDrawn) {
        System.out.println("You drew " + numberOfCardsToString(numberOfCardsDrawn) + "!");
        System.out.println();
    }

    public void displayHand(HandOfCards hand) {
        System.out.println("Your hand contains: ");
        displayListOfCards(hand.getHand());
        System.out.println();
    }

    public void displayDiscard(DiscardPile discardPile) {
        System.out.println("The discard pile contains: ");
        displayListOfCards(discardPile.getDiscard());
        System.out.println();
    }

    private void displayMenu(Map<Integer, String> menuToDisplay) {
        for (Map.Entry<Integer, String> entry : menuToDisplay.entrySet()) {
            System.out.println("[" + entry.getKey() + "] " + entry.getValue());
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
}
