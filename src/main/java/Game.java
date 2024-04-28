public class Game {
  public static Game getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new Game();
    }
    return INSTANCE;
  }

  public void startGame() {
    System.out.println("Staring new black Jack game ...");
    playNextMove();
  }

  enum GameState {
    NOT_STARTED,
    GAME_START,
    PLAYER_TURN,
    DEALER_TURN,
    GAME_OVER
  }

  private static Game INSTANCE;
  private GameState gameState = GameState.NOT_STARTED;
  private Player player;

  private Game() {
    gameState = GameState.GAME_START;
    player = new Player();
    playNextMove();
  }

  private void playNextMove() {
    switch (gameState) {

    case NOT_STARTED:
      // throw error
      break;

    case GAME_START:
      serveStartingCards();
      printStartingCards();
      gameState = GameState.PLAYER_TURN;
      break;

    case PLAYER_TURN:
      player.playTurn();
      gameState = GameState.DEALER_TURN;
      break;

    case DEALER_TURN:
      Dealer.getInstance().playTurn();
      gameState = GameState.GAME_OVER;
      break;

    case GAME_OVER:
      printWinner();
      resetGame();
      return;

    default:
      return;
    }

    playNextMove();
  }

  private void serveStartingCards() {
    Dealer.getInstance().drawCard();
    player.drawCard();
    Dealer.getInstance().drawCard();
    player.drawCard();
  }

  private void printStartingCards() {
    Dealer.getInstance().showCards();
    player.showCards();
  }

  private void printWinner() {
    System.out.println("The winner is ...");
  }

  private void resetGame() {
    player = new Player();
    Dealer.getInstance().resetDeler();
    Deck.getInstance().resetDeck();
    gameState = GameState.GAME_START;
  }
}
