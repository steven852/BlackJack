import java.util.ArrayList;

public class Player {
  private ArrayList<String> cardsHeld;
  private Deck deck = Deck.getDeck();
  private int score;

  public Player(){
    this.score = 0;
    this.cardsHeld = new ArrayList<String>();
  }

  public void hit(){
    System.out.println();
    System.out.println("The " + this.getClass().getSimpleName() + " Draws...");
    this.cardsHeld.add(this.deck.popDeck());
    calculateScore(this.cardsHeld);
  }

  public void showHand(){
    System.out.println();
    System.out.print("The " + this.getClass().getSimpleName() + " Has: ");
    for (int i = 0; i < this.cardsHeld.size(); i++){
      System.out.print(this.cardsHeld.get(i) + ", ");
    }
    System.out.println("and Score = " + this.score);
  }

  public ArrayList<String> getCardsHeld(){
    return this.cardsHeld;
  }

  public void calculateScore(ArrayList<String> cardsHeld){
    String card = "";
    this.score = 0; // Sneaky bug if not cleaed the score will append

    for(int i = 0; i < this.cardsHeld.size(); i++){
      card = this.cardsHeld.get(i).split("-")[0];
      if(NewGame.isNumeric(card)){
        this.score += Integer.parseInt(card);
      }
      else {
        switch (card) {
          case "A":
            this.score += 11; // TO-DO fix this
            break;

          default:
            this.score += 10;
            break;
        }
      }
    }
  }

  public int getScore() {
    return this.score;
  }
}
