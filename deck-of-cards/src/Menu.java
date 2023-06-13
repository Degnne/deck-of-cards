import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Menu {

    private Map<Integer, String> mainMenu = new LinkedHashMap<Integer, String>();
    private Scanner in = new Scanner(System.in);

    public Menu() {
        mainMenu.put(1, "Draw Cards");
        mainMenu.put(2, "Look at Your Hand");
        mainMenu.put(3, "Look at the Discard Pile");
        mainMenu.put(9, "Quit Program");
    }

    public void displayMainMenu() {
        for (Map.Entry<Integer, String> entry : mainMenu.entrySet()) {
            System.out.println("[" + entry.getKey() + "] " + entry.getValue());
        }
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
        for (PlayingCard card : hand.getHand()) {
            System.out.println(card);
        }
        System.out.println();
    }

    private String numberOfCardsToString(int number) {
        String string = number + " card";
        if (number != 1) {
            string += "s";
        }
        return string;
    }
}
