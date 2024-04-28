public final class ScoreMgr {
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

  public static void printWinners(Player player) {
    if (isPlayerBusted(player) == true) {
      System.out.println("Dealer Won Better Luck Next Time");
      return;
    }

    else if (isPlayerBusted(Dealer.getInstance()) == true) {
      System.out.println("Congratulations you Won the Round!");
    }

    else if (player.getCurrentScore() > Dealer.getInstance().getCurrentScore()) {
      System.out.println("Congratulations you Won the Round!");
    }

    else {
      System.out.println("Dealer Won Better Luck Next Time");
    }
  }

  private ScoreMgr() {}
}
