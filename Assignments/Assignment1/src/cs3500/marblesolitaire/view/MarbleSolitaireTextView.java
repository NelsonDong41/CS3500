package cs3500.marblesolitaire.view;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

public class MarbleSolitaireTextView {
  private final MarbleSolitaireModelState game;

  public MarbleSolitaireTextView(MarbleSolitaireModelState game) throws IllegalArgumentException {
    if (game == null) {
      throw new IllegalArgumentException("game is null");
    } else {
      this.game = game;
    }
  }

  @Override
  public String toString() {
    StringBuilder str = new StringBuilder();

    for (int i = 0; i < this.game.getBoardSize(); i++) {
      for (int j = 0; j < this.game.getBoardSize(); j++) {
        if (this.game.getSlotAt(j, i) == MarbleSolitaireModelState.SlotState.Invalid) {
          str.append(" ");
        }
        if (this.game.getSlotAt(j, i) == MarbleSolitaireModelState.SlotState.Marble) {
          str.append("o");
        }
        if (this.game.getSlotAt(j, i) == MarbleSolitaireModelState.SlotState.Empty){
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
