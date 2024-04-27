import java.util.ArrayList;

public final class Dealer extends Player{
  public final static int DRAW_UNTIL_SCORE = 16;
  private static Dealer INSTANCE;

  private Dealer(){
    super();
  }

  public static Dealer getDealer() {
      if(INSTANCE == null) {
          INSTANCE = new Dealer();
      }
      return INSTANCE;
  }
}
