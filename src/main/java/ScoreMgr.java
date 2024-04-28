public class ScoreMgr {
  public static ScoreMgr getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new ScoreMgr();
    }
    return INSTANCE;
  }

  public static boolean isPlayerBusted(Player player) {
    if (calculatePlayersScore(player) > 21) {
      return true;
    }

    return false;
  }

  public static int calculatePlayersScore(Player player) {
    String card = "";
    int score = 0;

    for (int i = 0; i < player.getCardsHeld().size(); i++) {
      card = player.getCardsHeld().get(i).split("-")[0];
      switch (card) {
      case "A":
        score += 11; // TO-DO fix
        break;

      case "K":
      case "Q":
      case "J":
        score += 10;
        break;

      default:
        score += Integer.parseInt(card);
        break;
      }
    }

    return score;
  }

  private static ScoreMgr INSTANCE;
  private ScoreMgr() {}
}
