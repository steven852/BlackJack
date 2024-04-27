import custom.utils.Logger;
import java.util.Scanner;

class NewGame {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String option = "";

    do {
      printGameOptions();
      option = sc.next();

      switch (option) {
      case "1":
        Game.getInstance().startGame();
        break;
      default:
        return;
      }
    } while (true);
  }

  public static void newBlackJackGame() {
    //   Deck deck = Deck.getDeck();
    //   Dealer dealer = Dealer.getDealer();
    //   Player player1 = new Player();

    //   dealer.hit();
    //   player1.hit();
    //   dealer.hit();
    //   player1.hit();
    //   dealer.showHand();

    //   Logger.consoleLog();

    //   Scanner sc1 = new Scanner(System.in);
    //   String option = "";

    // out: // In order to not break the if statement
    //   do {
    //     player1.showHand();
    //     printBlackJackOptions();

    //     option = sc1.nextLine();
    //     if (isNumeric(option)) {
    //       if (Integer.parseInt(option) == 1) {
    //         player1.hit();
    //       }

    //       else if (Integer.parseInt(option) == 2) {
    //         break out;
    //       }
    //     }

    //     if (isBust(player1.getScore())) {
    //       System.out.println("You busted with: " + player1.getScore());
    //       return;
    //     }
    //   } while (true);

    //   while (dealer.getScore() < dealer.DRAW_UNTIL_SCORE) {
    //     dealer.hit();
    //     dealer.showHand();
    //   }

    //   if (player1.getScore() > dealer.getScore()) {
    //     System.out.println("Congratulations you Won the Round!");
    //   }

    //   else if (player1.getScore() < dealer.getScore()) {
    //     System.out.println("Dealer Won Better Luck Next Time");
    //   }

    //   else {
    //     System.out.println("Game was tied");
    //   }
  }

  public static void printGameOptions() {
    Logger.consoleLog("---------------------------");
    Logger.consoleLog("Choose An Option: ");
    Logger.consoleLog("1 - New Game");
    Logger.consoleLog("Any Other - Exit");
  }
}