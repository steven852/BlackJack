import custom.utils.Logger;

public final class Dealer extends Player {
  public final static int DRAW_UNTIL_SCORE = 16;
  private static Dealer INSTANCE;

  private Dealer() { super(); }

  public static Dealer getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new Dealer();
    }
    return INSTANCE;
  }

  public static void resetDeler() { INSTANCE = new Dealer(); }

  public void playTurn() {
    showCards();

    if (GameSupervisor.getInstance().isPlayerBusted(this) == true) {
      Logger.consoleLog(
          "Deler busted with: " +
          GameSupervisor.getInstance().calculatePlayersScore(this) + " !");

      return;
    }

    if (GameSupervisor.getInstance().calculatePlayersScore(this) >=
        DRAW_UNTIL_SCORE) {
      Logger.consoleLog(
          "Deler stops with final score: " +
          GameSupervisor.getInstance().calculatePlayersScore(this));

      return;
    }

    drawCard();
    playTurn();
  }
}
