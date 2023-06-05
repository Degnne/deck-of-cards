import java.util.Scanner;

public class Main {

    private DeckOfCards deck = new DeckOfCards();
    private HandOfCards hand = new HandOfCards();
    private DiscardPile discardPile = new DiscardPile();
    private Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    public void run() {
        deck.shuffle();
        do {
            displayMenu();
            int userSelection;
            while (true) {
                while (true) {
                    System.out.print("What would you like to do? >>> ");
                    String selectionFromUser = userInput.nextLine();

                    try {
                        userSelection = Integer.parseInt(selectionFromUser);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid number.");
                    }
                }
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
                    default:
                        System.out.println("Please enter a valid number.");
                }
                displayMenu();
            }
        } while (true);
    }

    public void displayMenu() {
        System.out.println("There are " + deck.getDeckSize() + " cards in the deck, " + hand.getHandSize() +
                " cards in your hand, and " + discardPile.getDiscardPileSize() + " cards in the discard pile.");
        System.out.println("[1] Draw cards");
        System.out.println("[2] Look at  your hand");
        System.out.println("[3] Look at the discard pile");
        System.out.println("[0] Quit program");
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
        System.out.println("You drew " + numberOfCards + " cards.");
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

    public void endProgram() {

    }
}