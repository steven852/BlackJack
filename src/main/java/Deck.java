import java.util.ArrayList;
import java.util.Collections;

public final class Deck{
    private static Deck INSTANCE;
    private ArrayList<String> deckCards;

    private Deck() {
      generateDeck();
      shuffleDeck();
    }

    public static Deck getDeck() {
        if(INSTANCE == null) {
            INSTANCE = new Deck();
        }
        return INSTANCE;
    }

    private void generateDeck(){
      this.deckCards = new ArrayList<String>();
      String[] suits = {"Spade", "Club", "Diamond", "Heart"};
      String[] cards = {"A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3", "2"};

      for(int i = 0; i < suits.length; i++){
        for (int j = 0; j < cards.length; j++){
          this.deckCards.add(cards[j] + "-" + suits[i]);
        }
      }
    }

    private void shuffleDeck(){
      Collections.shuffle(this.deckCards);
    }

    public void createNewDeck(){
      generateDeck();
      shuffleDeck();
    }

    public void printDeck(){
      for (int i = 0; i < this.deckCards.size(); i++){
        System.out.println(this.deckCards.get(i) + ", ");
      }
    }

    public String popDeck(){
      return this.deckCards.remove(this.deckCards.size()-1);
    }

}
