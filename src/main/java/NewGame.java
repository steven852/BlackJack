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

  public static void printGameOptions() {
    System.out.println("---------------------------");
    System.out.println("Choose An Option: ");
    System.out.println("1 - New Game");
    System.out.println("Any Other - Exit");
  }
}