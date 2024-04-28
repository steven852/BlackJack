import java.util.ArrayList;
import java.util.Scanner;

public class Player {
  private ArrayList<String> cardsHeld;
  private int score;

  public Player() { this.cardsHeld = new ArrayList<String>(); }

  public void drawCard() {
    System.out.println();
    System.out.println("The " + getClass().getSimpleName() + " draws ...");
    cardsHeld.add(Deck.getInstance().serveCard());
    ScoreMgr.calculatePlayersScore(this);
  }

  public void showCards() {
    System.out.println();
    System.out.println("The " + getClass().getSimpleName() + " holds: ");
    for (int i = 0; i < cardsHeld.size(); i++) {
      System.out.println(cardsHeld.get(i) + ", ");
    }

    System.out.println("and score = " + ScoreMgr.calculatePlayersScore(this));
  }

  public ArrayList<String> getCardsHeld() { return this.cardsHeld; }

  public void playTurn() {
    printPlayersOptions();

    Scanner sc = new Scanner(System.in);
    String option = sc.next();

    switch (option) {
    case "1":
      drawCard();
      break;

    case "2":
      return;

    default:
      return;
    }

    showCards();

    if (ScoreMgr.isPlayerBusted(this) == true) {
      System.out.println("Player is busted!");
      return;
    }

    else if (ScoreMgr.calculatePlayersScore(this) == 21) {
      System.out.println("21 reached!");
      return;
    }

    else {
      playTurn();
    }
  }

  private void printPlayersOptions() {
    System.out.println();
    System.out.println("Choose An Option: ");
    System.out.println("1 - Draw");
    System.out.println("2 - Stay");
  }
}
