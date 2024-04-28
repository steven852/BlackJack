import java.util.ArrayList;
import java.util.Scanner;

public class Player {
  public Player() {
    cardsHeld = new ArrayList<String>();
    currentScore = 0;
  }

  public void drawCard() {
    System.out.println();
    System.out.println("The " + getClass().getSimpleName() + " draws ...");
    cardsHeld.add(Deck.getInstance().serveCard());
    currentScore = ScoreMgr.calculatePlayersScore(this);
  }

  public void showCards() {
    System.out.println();
    System.out.println("The " + getClass().getSimpleName() + " holds: ");
    for (int i = 0; i < cardsHeld.size(); i++) {
      System.out.println(cardsHeld.get(i) + ", ");
    }

    System.out.println("and score = " + currentScore);
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

    else if (currentScore == 21) {
      System.out.println("21 reached!");
      return;
    }

    else {
      playTurn();
    }
  }

  private ArrayList<String> cardsHeld;
  private int currentScore;

  private void printPlayersOptions() {
    System.out.println();
    System.out.println("Choose An Option: ");
    System.out.println("1 - Draw");
    System.out.println("2 - Stay");
  }
}
