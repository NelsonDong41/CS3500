package cs3500.marblesolitaire.view;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * a class to view a given game.
 */
public class MarbleSolitaireTextView implements MarbleSolitaireView {
  private MarbleSolitaireModelState game;

  /**
   * creates a MarbleSolitaireTextView object that allows us to view the game.
   * @param game : the game we want to view
   * @throws IllegalArgumentException if the game is null
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState game) throws IllegalArgumentException {
    if (game == null) {
      throw new IllegalArgumentException("game is null");
    } else {
      this.game = game;
    }
  }

  /**
   * gives the board in the form of text.
   * @return string of the board with o being marbles and - being empty space
   */
  @Override
  public String toString() {
    StringBuilder str = new StringBuilder();

    for (int i = 0; i < this.game.getBoardSize(); i++) {
      for (int j = 0; j < this.game.getBoardSize(); j++) {
        if (this.game.getSlotAt(i, j) == MarbleSolitaireModelState.SlotState.Invalid) {
          str.append(" ");
        }
        if (this.game.getSlotAt(i, j) == MarbleSolitaireModelState.SlotState.Marble) {
          str.append("o");
        }
        if (this.game.getSlotAt(i, j) == MarbleSolitaireModelState.SlotState.Empty) {
          str.append("-");
        }
      }
      if (i != this.game.getBoardSize() - 1) {
        str.append("\n");
      }
    }
    return str.toString();
  }
}
