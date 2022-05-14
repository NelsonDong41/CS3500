package cs3500.marblesolitaire.model.hw02;

import java.util.ArrayList;

public class EnglishSolitaireModel implements MarbleSolitaireModel {

  private final ArrayList<ArrayList<SlotState>> board;
  private final int armThickness;

  private final int starti;
  private final int startj;

  public EnglishSolitaireModel() {
    this.board = new ArrayList<>();
    this.armThickness = 3;
    this.starti = 3;
    this.startj = 3;
    this.initBoard();
  }

  public EnglishSolitaireModel(int sRow, int sCol) throws IllegalArgumentException {
    if ((sRow < 3 && sCol < 3)
            || (sRow < 3 && sCol > 5)
            || (sRow > 5 && sCol < 3)
            || (sRow > 5 && sCol > 5)) {
      throw new IllegalArgumentException("invalid cell position (" + sRow + ", " + sCol + ")");
    } else {
      this.armThickness = 3;
      this.board = new ArrayList<>();
      this.starti = sRow;
      this.startj = sCol;
      this.initBoard();
    }
  }

  public EnglishSolitaireModel(int armThickness) throws IllegalArgumentException {
    if (armThickness % 2 != 1) {
      throw new IllegalArgumentException("no even numbers");
    } else {
      this.board = new ArrayList<>();
      this.armThickness = armThickness;
      this.starti = 3;
      this.startj = 3;
      this.initBoard();
    }
  }

  public EnglishSolitaireModel(int armThickness, int sRow, int sCol) throws IllegalArgumentException {
    if (armThickness % 2 != 1
            || (sRow < armThickness - 1 && sCol < armThickness - 1)
            || (sRow > armThickness * 2 - 2 && sCol > armThickness * 2 - 2)
            || (sRow > armThickness * 2 - 2 && sCol < armThickness - 1)
            || (sRow < armThickness - 1 && sCol > armThickness * 2 - 2)) {
      throw new IllegalArgumentException();
    } else {
      this.armThickness = armThickness;
      this.board = new ArrayList<>();
      this.starti = sRow;
      this.startj = sCol;
      this.initBoard();
    }
  }

  private void initBoard() {
    for (int i = 0; i < armThickness + 2 * (armThickness - 1); i++) {
      this.board.add(new ArrayList<>());
      for (int j = 0; j < armThickness + 2 * (armThickness - 1); j++) {
        if (this.onBoard(i, j)) {
          this.board.get(i).add(SlotState.Invalid);
        } else if (i == this.starti && j == this.startj) {
          this.board.get(i).add(SlotState.Empty);
        } else {
          this.board.get(i).add(SlotState.Marble);
        }
      }
    }
  }

  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    int movex = fromRow - toRow;
    int movey = fromCol - toCol;

    if (movex != 0 && movey != 0 && !this.canMove(fromRow, fromCol)) {
      throw new IllegalArgumentException("can't move diagonally");
    } else {
      if (Math.abs(movex) == 2 || Math.abs(movey) == 2
              && this.getSlotAt(toRow, toCol).equals(SlotState.Empty)
              && this.getSlotAt(fromRow, fromCol).equals(SlotState.Marble)
              && this.getSlotAt((toRow + fromRow) / 2,
              (toCol + fromCol) / 2).equals(SlotState.Marble)) {
        this.board.get(fromCol).set(fromRow, SlotState.Empty);
        this.board.get(toCol).set(toRow, SlotState.Marble);
      }
    }
  }

  private boolean canMove(int row, int col) {
    boolean ans = true;
    if (row < this.getBoardSize() - 3) {
      ans = this.getSlotAt(col, row).equals(SlotState.Marble)
              && this.getSlotAt(row + 1, col).equals(SlotState.Marble)
              && this.getSlotAt(row + 2, col).equals(SlotState.Marble);
    }
    if (row >= 2) {
      ans = ans || this.getSlotAt(row - 1, col).equals(SlotState.Marble)
              && this.getSlotAt(row - 2, col).equals(SlotState.Marble);
    }
    if (col < this.getBoardSize() - 3) {
      ans = ans || this.getSlotAt(row, col + 1).equals(SlotState.Marble)
              && this.getSlotAt(row, col + 2).equals(SlotState.Marble);
    }
    if (col >= 3) {
      ans = ans || this.getSlotAt(row, col - 1).equals(SlotState.Marble)
              && this.getSlotAt(row, col - 1).equals(SlotState.Marble);
    }
    return ans;
  }

  @Override
  public boolean isGameOver() {
    for (int i = 0; i < getBoardSize(); i++) {
      for (int j = 0; j < getBoardSize(); j++) {
        if (this.getSlotAt(i, j) == SlotState.Marble && this.canMove(j, i)) {
          return false;
        }
      }
    }
    return true;
  }

  @Override
  public int getBoardSize() {
    return armThickness + 2 * (armThickness - 1);
  }

  @Override
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    if (row < 0 || row > this.getBoardSize() - 1
            || col < 0
            || col > this.getBoardSize() - 1) {
      throw new IllegalArgumentException();
    }
    if (this.onBoard(col, row)) {
      return SlotState.Invalid;
    } else if (row == starti && col == startj) {
      return SlotState.Empty;
    } else {
      return SlotState.Marble;
    }
  }

  private boolean onBoard(int row, int col) {
    return ((col < armThickness - 1 && row < armThickness - 1)
            || (col > armThickness * 2 - 2 && row > armThickness * 2 - 2)
            || (col > armThickness * 2 - 2 && row < armThickness - 1)
            || (col < armThickness - 1 && row > armThickness * 2 - 2));
  }

  @Override
  public int getScore() {
    int count = 0;

    for (int i = 0; i < this.getBoardSize(); i++) {
      for (int j = 0; j < this.getBoardSize(); j++) {
        if (this.board.get(i).get(j).equals(SlotState.Marble)) {
          count++;
        }
      }
    }
    return count;
  }
}
