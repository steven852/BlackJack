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

    if (ScoreMgr.isPlayerBusted(this) == true) {
      System.out.println(
          "Deler busted with: " +
          ScoreMgr.calculatePlayersScore(this) + " !");

      return;
    }

    if (ScoreMgr.calculatePlayersScore(this) >=
        DRAW_UNTIL_SCORE) {
      System.out.println(
          "Deler stops with final score: " +
          ScoreMgr.calculatePlayersScore(this));

      return;
    }

    drawCard();
    playTurn();
  }
}
