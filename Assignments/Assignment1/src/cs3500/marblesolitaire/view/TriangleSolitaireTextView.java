package cs3500.marblesolitaire.view;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

public class TriangleSolitaireTextView implements MarbleSolitaireView {
  private final MarbleSolitaireModelState game;
  private final Appendable appendable;

  /**
   * creates a MarbleSolitaireTextView object that allows us to view the game.
   *
   * @param game : the game we want to view
   * @throws IllegalArgumentException if the game is null
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState game) throws IllegalArgumentException {
    if (game == null) {
      throw new IllegalArgumentException("game is null");
    } else {
      this.game = game;
      this.appendable = System.out;
    }
  }

  /**
   * Constructor for the MarbleSolitaireTextView object.
   *
   * @param game       : the game being view
   * @param appendable : the output source
   * @throws IllegalArgumentException : if either are null
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState game, Appendable appendable)
          throws IllegalArgumentException {
    if (game == null || appendable == null || game.getBoardSize() == 0) {
      throw new IllegalArgumentException("null parameters");
    }
    this.game = game;
    this.appendable = appendable;
  }

  /**
   * gives the board in the form of text.
   *
   * @return string of the board with o being marbles and - being empty space
   */
  @Override
  public String toString() {
    StringBuilder str = new StringBuilder();
    String current = "";

    for (int i = 0; i < this.game.getBoardSize(); i++) {
      str.append(" ".repeat(this.game.getBoardSize() - i - 1));
      for (int j = 0; j < this.game.getBoardSize(); j++) {
        if (this.game.getSlotAt(i, j) == MarbleSolitaireModelState.SlotState.Marble) {
          str.append("O ");
        }
        if (this.game.getSlotAt(i, j) == MarbleSolitaireModelState.SlotState.Empty) {
          str.append("_ ");
        }
      }
      if (i != this.game.getBoardSize() - 1) {
        current = str.toString().replaceAll("\\s+$", "");
        str = new StringBuilder(current);
        str.append("\n");
      }
    }
    return str.toString().replaceAll("\\s+$", "");
  }

  @Override
  public void renderBoard() throws IOException {
    appendable.append(this.toString()).append("\n");
  }

  @Override
  public void renderMessage(String message) throws IOException {
    appendable.append(message);
  }
}
