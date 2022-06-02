package cs3500.marblesolitaire.model.hw03;

import java.util.ArrayList;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;

public class TriangleSolitaireModel extends AbstractSolitaireModel {
  public TriangleSolitaireModel() {
    super(5, 0, 0);
  }

  public TriangleSolitaireModel(int armThickness) {
    super(armThickness, 0, 0);
  }

  public TriangleSolitaireModel(int row, int col) {
    super(5, row, col);
  }

  public TriangleSolitaireModel(int sideLength, int row, int col) {
    super(sideLength, row, col);
  }

  protected boolean initConditions(int armThickness, int sRow, int sCol) {
    return offBoard(sRow, sCol);
  }

  @Override
  protected boolean offBoard(int row, int col) {
    return (row < 0)
            || (col < 0)
            || (row > getBoardSize() - 1)
            || (col > row);
  }

  protected boolean canMove(int row, int col) {
    return this.getSlotAt(row, col) == SlotState.Marble
            && ((!this.offBoard(row - 2, col)
            && this.getSlotAt(row - 1, col) == SlotState.Marble
            && this.getSlotAt(row - 2, col) == SlotState.Empty)
            || ((!this.offBoard(row + 2, col)
            && this.getSlotAt(row + 1, col) == SlotState.Marble
            && this.getSlotAt(row + 2, col) == SlotState.Empty)
            || (!this.offBoard(row + 2, col + 2)
            && this.getSlotAt(row + 1, col + 1) == SlotState.Marble
            && this.getSlotAt(row + 2, col + 2) == SlotState.Empty)
            || (!this.offBoard(row - 2, col - 2)
            && this.getSlotAt(row - 1, col - 1) == SlotState.Marble
            && this.getSlotAt(row - 2, col - 2) == SlotState.Empty)
            || (!this.offBoard(row + 2, col - 2)
            && this.getSlotAt(row + 1, col - 1) == SlotState.Marble
            && this.getSlotAt(row + 2, col - 2) == SlotState.Empty)
            || (!this.offBoard(row - 2, col + 2)
            && this.getSlotAt(row - 1, col + 1) == SlotState.Marble
            && this.getSlotAt(row - 2, col + 1) == SlotState.Empty)

            || (!this.offBoard(row, col + 2)
            && this.getSlotAt(row, col + 1) == SlotState.Marble
            && this.getSlotAt(row, col + 2) == SlotState.Empty)
            || (!this.offBoard(row, col - 2)
            && this.getSlotAt(row, col - 1) == SlotState.Marble
            && this.getSlotAt(row, col - 2) == SlotState.Empty)));
  }

  @Override
  public int getBoardSize() {
    return armThickness;
  }
}
