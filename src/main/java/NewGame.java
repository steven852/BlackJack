import java.util.Scanner;
import java.util.ArrayList;

class NewGame{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String option = "";

    do{
      printMainOptions();
      option = sc.nextLine();

      if(isNumeric(option)){
        switch (Integer.parseInt(option)){
          case 1:
            newBlackJackGame();
            break;
          default:
            return;
        }
      }
      else {
        return;
      }
    } while (true);

  }

  public static void newBlackJackGame(){
    Deck deck = Deck.getDeck();
    Dealer dealer = Dealer.getDealer();
    Player player1 = new Player();

    dealer.hit(); player1.hit(); dealer.hit(); player1.hit();
    dealer.showHand();

    System.out.println();

    Scanner sc1 = new Scanner(System.in);
    String option = "";

    out: // In order to not break the if statement
    do{
      player1.showHand();
      printBlackJackOptions();

      option = sc1.nextLine();
      if(isNumeric(option)){
        if(Integer.parseInt(option) == 1){
          player1.hit();
        }

        else if(Integer.parseInt(option) == 2){
          break out;
        }
      }

      if(isBust(player1.getScore())){
        System.out.println("You busted with: " + player1.getScore());
        return;
      }
    } while (true);

    while (dealer.getScore() < dealer.DRAW_UNTIL_SCORE){
      dealer.hit();
      dealer.showHand();
    }

    if (player1.getScore() > dealer.getScore()){
      System.out.println("Congratulations you Won the Round!");
    }

    else if (player1.getScore() < dealer.getScore()){
      System.out.println("Dealer Won Better Luck Next Time");
    }

    else {
      System.out.println("Game was tied");
    }
  }

  public static boolean isNumeric(String str) {
    try {
      Integer.parseInt(str);
      return true;
    }
    catch(NumberFormatException e){
      return false;
    }
  }

  public static boolean isBust(int num){
    return num > 21 ? true:false;
  }

  public static void printMainOptions(){
    System.out.println();
    System.out.println("Choose An Option: ");
    System.out.println("1 - New Game of BlackJack");
    System.out.println("Any Other - Exit");
  }

  public static void printBlackJackOptions(){
    System.out.println();
    System.out.println("Choose An Option: ");
    System.out.println("1 - Hit");
    System.out.println("2 - Stay");
  }



}
