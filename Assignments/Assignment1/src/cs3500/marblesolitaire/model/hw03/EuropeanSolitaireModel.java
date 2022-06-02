package cs3500.marblesolitaire.model.hw03;


import java.util.ArrayList;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;

public class EuropeanSolitaireModel extends EnglishSolitaireModel {

  /**
   * Constructs a default EuropeanSolitaireModel with a thickness of 3 and starting position
   * in the center.
   */
  public EuropeanSolitaireModel() {
    super();
  }

  public EuropeanSolitaireModel(int armThickness) throws IllegalArgumentException {
    super(armThickness);
  }

  public EuropeanSolitaireModel(int row, int col) throws IllegalArgumentException {
    super(row, col);
  }

  public EuropeanSolitaireModel(int armThickness, int row, int col) throws IllegalArgumentException {
    super(armThickness, row, col);
  }

  @Override
  protected boolean moveCondition(int fromRow, int fromCol, int toRow, int toCol) {
    int movey = fromRow - toRow;
    int movex = fromCol - toCol;
    return super.moveCondition(fromRow, fromCol, toRow, toCol) || (movex != 0 && movey != 0) ;
  }

  @Override
  protected boolean offBoard(int row, int col) {
    return col < armThickness - 1 - row
            || col > armThickness * 3 - 2 - (armThickness - row)
            || col < armThickness - 1 && row > armThickness * 2 - 2 + col
            || col > armThickness * 2 - 3 + ((armThickness * 3 - 2) - row)
            || (row < 0)
            || (col < 0)
            || (row > getBoardSize() - 1)
            || (col > getBoardSize() - 1);
  }
}
