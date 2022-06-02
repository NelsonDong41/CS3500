package cs3500.marblesolitaire.model.hw03;

import java.util.ArrayList;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

public abstract class AbstractSolitaireModel implements MarbleSolitaireModel {
  protected final ArrayList<ArrayList<SlotState>> board;
  protected final int armThickness;

  protected final int starti;
  protected final int startj;

  /**
   * Constructs a default EnglishSolitaireModel with a thickness of 3 and starting position
   * in the center.
   */
  public AbstractSolitaireModel() {
    this(3, 3, 3);
  }

  /**
   * Constructs a EnglishSolitaireModel with the following parameters.
   *
   * @param sRow : which row the starting position is on
   * @param sCol : which column the starting position is on
   * @throws IllegalArgumentException : if the starting position is off the board or Invalid
   */
  public AbstractSolitaireModel(int sRow, int sCol) throws IllegalArgumentException {
    this(3, sRow, sCol);
  }

  /**
   * Constructs a EnglishSolitaireModel with the following parameters.
   *
   * @param armThickness : how thick the arms are of the game
   * @throws IllegalArgumentException : if the thickness is even
   */
  public AbstractSolitaireModel(int armThickness) throws IllegalArgumentException {
    this(armThickness, 3, 3);
  }

  /**
   * Constructs a EnglishSolitaireModel with the following parameters.
   *
   * @param armThickness : how thick the arms are
   * @param sRow         : which row the starting position is on
   * @param sCol         : which column the starting position is on
   * @throws IllegalArgumentException : the arm thickness is even or if the starting position
   *                                  is out of the board or Invalid
   */
  public AbstractSolitaireModel(int armThickness, int sRow, int sCol)
          throws IllegalArgumentException {
    this.armThickness = armThickness;
    this.board = new ArrayList<>();
    this.starti = sRow;
    this.startj = sCol;
    this.initBoard();
    if (initConditions(armThickness, sRow, sCol)) {
      throw new IllegalArgumentException();
    }
  }

  protected boolean initConditions(int armThickness, int sRow, int sCol) {
    return offBoard(sRow, sCol) || armThickness % 2 != 1;
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
   *
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
    if (moveCondition(fromRow, fromCol, toRow, toCol)) {
      throw new IllegalArgumentException("Invalid move");
    } else {
      this.board.get(fromRow).set(fromCol, SlotState.Empty);
      this.board.get((fromRow + toRow) / 2).set((fromCol + toCol) / 2, SlotState.Empty);
      this.board.get(toRow).set(toCol, SlotState.Marble);
    }
  }

  protected boolean moveCondition(int fromRow, int fromCol, int toRow, int toCol) {
    int movey = fromRow - toRow;
    int movex = fromCol - toCol;
    return this.isGameOver()
            || !this.canMove(fromRow, fromCol)
            || movex == 0 && movey == 0
            || Math.abs(movex) == 1
            || Math.abs(movey) == 1
            || Math.abs(movex) > 2
            || Math.abs(movey) > 2
            || this.offBoard(toRow, toCol)
            || this.offBoard(fromRow, fromCol)
            || this.getSlotAt((fromRow + toRow) / 2,
            (fromCol + toCol) / 2) != SlotState.Marble
            || this.getSlotAt(toRow, toCol) == SlotState.Marble
            || this.getSlotAt(fromRow, fromCol) == SlotState.Empty;
  }

  protected boolean canMove(int row, int col) {
    return this.getSlotAt(row, col) == SlotState.Marble
            && ((!this.offBoard(row - 2, col)
            && this.getSlotAt(row - 1, col) == SlotState.Marble
            && this.getSlotAt(row - 2, col) == SlotState.Empty)
            || (!this.offBoard(row + 2, col)
            && this.getSlotAt(row + 1, col) == SlotState.Marble
            && this.getSlotAt(row + 2, col) == SlotState.Empty)
            || (!this.offBoard(row, col + 2)
            && this.getSlotAt(row, col + 1) == SlotState.Marble
            && this.getSlotAt(row, col + 2) == SlotState.Empty)
            || (!this.offBoard(row, col - 2)
            && this.getSlotAt(row, col - 1) == SlotState.Marble
            && this.getSlotAt(row, col - 2) == SlotState.Empty));
  }

  /**
   * determines if the game is over.
   *
   * @return a boolean. True if the game is over
   */
  @Override
  public boolean isGameOver() {
    for (int i = 0; i < getBoardSize(); i++) {
      for (int j = 0; j < getBoardSize(); j++) {
        if ((this.getSlotAt(i, j) == SlotState.Marble && this.canMove(i, j))) {
          return false;
        }
      }
    }
    return true;
  }

  /**
   * gets the longest length/width of the board.
   *
   * @return : int of the length/width of the board
   */
  @Override
  public int getBoardSize() {
    return armThickness + 2 * (armThickness - 1);
  }

  /**
   * returns the type of enum at the given position.
   *
   * @param row the row of the position sought, starting at 0
   * @param col the column of the position sought, starting at 0
   * @return : a SlotState with the given type at the position
   * @throws IllegalArgumentException when the position is out of bounds
   */
  @Override
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    if (row < 0 || row >= this.getBoardSize()
            || col < 0
            || col >= this.getBoardSize()) {
      throw new IllegalArgumentException();
    }
    return this.board.get(row).get(col);
  }

  protected boolean offBoard(int row, int col) {
    return ((col < armThickness - 1 && row < armThickness - 1)
            || (col > armThickness * 2 - 2 && row > armThickness * 2 - 2)
            || (col > armThickness * 2 - 2 && row < armThickness - 1)
            || (col < armThickness - 1 && row > armThickness * 2 - 2))
            || (row < 0)
            || (col < 0)
            || (row > getBoardSize() - 1)
            || (col > getBoardSize() - 1);
  }

  /**
   * returns how many marbles are left on the board.
   *
   * @return an int of the number of marbles
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
