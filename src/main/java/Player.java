import custom.utils.Logger;
import java.util.ArrayList;
import java.util.Scanner;

public class Player {
  private ArrayList<String> cardsHeld;
  private int score;

  public Player() { this.cardsHeld = new ArrayList<String>(); }

  public void drawCard() {
    Logger.consoleLog();
    Logger.consoleLog("The " + getClass().getSimpleName() + " Draws...");
    cardsHeld.add(Deck.getInstance().serveCard());
    GameSupervisor.getInstance().calculatePlayersScore(this);
  }

  public void showCards() {
    Logger.consoleLog();
    Logger.consoleLog("The " + getClass().getSimpleName() + " Has: ");
    for (int i = 0; i < cardsHeld.size(); i++) {
      Logger.consoleLog(cardsHeld.get(i) + ", ");
    }

    Logger.consoleLog("and Score = " +
                      GameSupervisor.getInstance().calculatePlayersScore(this));
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

    if (GameSupervisor.getInstance().isPlayerBusted(this) == true) {
      Logger.consoleLog("Player is busted!");
      return;
    }

    else {
      playTurn();
    }
  }

  private void printPlayersOptions() {
    Logger.consoleLog();
    Logger.consoleLog("Choose An Option: ");
    Logger.consoleLog("1 - Draw");
    Logger.consoleLog("2 - Stay");
  }
}
