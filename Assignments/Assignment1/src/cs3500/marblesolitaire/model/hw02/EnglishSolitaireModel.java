package cs3500.marblesolitaire.model.hw02;

import java.util.ArrayList;

/**
 * A class to create an English Solitaire Model.
 */
public class EnglishSolitaireModel implements MarbleSolitaireModel {

  private ArrayList<ArrayList<SlotState>> board;
  private final int armThickness;

  private final int starti;
  private final int startj;

  /**
   * Constructs a default EnglishSolitaireModel with a thickness of 3 and starting position
   * in the center.
   */
  public EnglishSolitaireModel() {
    this.board = new ArrayList<>();
    this.armThickness = 3;
    this.starti = 3;
    this.startj = 3;
    this.initBoard();
  }

  /**
   * Constructs a EnglishSolitaireModel with the following parameters.
   * @param sRow : which row the starting position is on
   * @param sCol : which column the starting position is on
   * @throws IllegalArgumentException : if the starting position is off the board or Invalid
   */
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

  /**
   * Constructs a EnglishSolitaireModel with the following parameters.
   * @param armThickness : how thick the arms are of the game
   * @throws IllegalArgumentException : if the thickness is even
   */
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

  /**
   * Constructs a EnglishSolitaireModel with the following parameters.
   * @param armThickness : how thick the arms are
   * @param sRow : which row the starting position is on
   * @param sCol : which column the starting position is on
   * @throws IllegalArgumentException : the arm thickness is even or if the starting position
   *      is out of the board or Invalid
   */
  public EnglishSolitaireModel(int armThickness, int sRow, int sCol)
          throws IllegalArgumentException {
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
        if (this.offBoard(i, j)) {
          this.board.get(i).add(SlotState.Invalid);
        } else if (i == this.starti && j == this.startj) {
          this.board.get(i).add(SlotState.Empty);
        } else {
          this.board.get(i).add(SlotState.Marble);
        }
      }
    }
  }

  /**
   * Moves a valid piece to a valid position.
   * @param fromRow the row number of the position to be moved from
   *                (starts at 0)
   * @param fromCol the column number of the position to be moved from
   *                (starts at 0)
   * @param toRow   the row number of the position to be moved to
   *                (starts at 0)
   * @param toCol   the column number of the position to be moved to
   *                (starts at 0)
   * @throws IllegalArgumentException : if the move is diagonal or the piece cannot move
   */
  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    int movey = fromRow - toRow;
    int movex = fromCol - toCol;

    if ((movex != 0 && movey != 0 && !this.canMove(fromRow, fromCol)) || this.isGameOver()) {
      throw new IllegalArgumentException("Invalid move");
    } else {
      if (Math.abs(movex) == 2 || Math.abs(movey) == 2
              && this.canMove(fromRow, fromCol)) {
        this.board.get(fromRow).set(fromCol, SlotState.Empty);
        this.board.get((fromRow + toRow)/2).set((fromCol + toCol)/2, SlotState.Empty);
        this.board.get(toRow).set(toCol, SlotState.Marble);
      }
      else if (Math.abs(movex) == 1 || Math.abs(movey) == 1) {
        throw new IllegalArgumentException("has to jump over a marble");
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

  /**
   * determines if the game is over.
   * @return a boolean. True if the game is over
   */
  @Override
  public boolean isGameOver() {
    for (int i = 0; i < getBoardSize(); i++) {
      for (int j = 0; j < getBoardSize(); j++) {
        if ((this.getSlotAt(i, j) == SlotState.Marble && this.canMove(j, i))) {
          return false;
        }
      }
    }
    return true;
  }

  /**
   * gets the longest length/width of the board.
   * @return : int of the length/width of the board
   */
  @Override
  public int getBoardSize() {
    return armThickness + 2 * (armThickness - 1);
  }

  /**
   * returns the type of enum at the given position.
   * @param row the row of the position sought, starting at 0
   * @param col the column of the position sought, starting at 0
   * @return : a SlotState with the given type at the position
   * @throws IllegalArgumentException when the position is out of bounds
   */
  @Override
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    if (row < 0 || row > this.getBoardSize() - 1
            || col < 0
            || col > this.getBoardSize() - 1) {
      throw new IllegalArgumentException();
    }
    return this.board.get(row).get(col);
  }

  private boolean offBoard(int row, int col) {
    return ((col < armThickness - 1 && row < armThickness - 1)
            || (col > armThickness * 2 - 2 && row > armThickness * 2 - 2)
            || (col > armThickness * 2 - 2 && row < armThickness - 1)
            || (col < armThickness - 1 && row > armThickness * 2 - 2));
  }

  /**
   * returns how many marbles are left on the board.
   *      @return an int of the number of marbles
   */
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
