import java.util.ArrayList;
import java.util.Collections;

public final class Deck {
  public static Deck getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new Deck();
    }
    return INSTANCE;
  }
  
  public String serveCard() { return cardsList.remove(cardsList.size() - 1); }

  public void resetDeck() {
    initializeDeck();
    shuffleDeck();
  }

  public void printDeck() {
    for (int i = 0; i < cardsList.size(); i++) {
      System.out.println(cardsList.get(i) + ", ");
    }
  }


  private static Deck INSTANCE;
  private ArrayList<String> cardsList;

  private Deck() {
    initializeDeck();
    shuffleDeck();
  }

  private void initializeDeck() {
    cardsList = new ArrayList<String>();
    String[] suits = {"Spade", "Club", "Diamond", "Heart"};
    String[] cards = {"A", "K", "Q", "J", "10", "9", "8",
                      "7", "6", "5", "4", "3",  "2"};

    for (int i = 0; i < suits.length; i++) {
      for (int j = 0; j < cards.length; j++) {
        cardsList.add(cards[j] + "-" + suits[i]);
      }
    }
  }

  private void shuffleDeck() { Collections.shuffle(cardsList); }
}
