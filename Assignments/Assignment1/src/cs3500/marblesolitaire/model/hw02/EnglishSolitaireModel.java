package cs3500.marblesolitaire.model.hw02;

import java.util.ArrayList;

import cs3500.marblesolitaire.model.hw03.AbstractSolitaireModel;

/**
 * A class to create an English Solitaire Model.
 */
public class EnglishSolitaireModel extends AbstractSolitaireModel {
  /**
   * Constructs a default EnglishSolitaireModel with a thickness of 3 and starting position
   * in the center.
   */
  public EnglishSolitaireModel() {
    super();
  }

  /**
   * Constructs a EnglishSolitaireModel with the following parameters.
   *
   * @param sRow : which row the starting position is on
   * @param sCol : which column the starting position is on
   * @throws IllegalArgumentException : if the starting position is off the board or Invalid
   */
  public EnglishSolitaireModel(int sRow, int sCol) throws IllegalArgumentException {
    super(sRow, sCol);
  }

  /**
   * Constructs a EnglishSolitaireModel with the following parameters.
   *
   * @param armThickness : how thick the arms are of the game
   * @throws IllegalArgumentException : if the thickness is even
   */
  public EnglishSolitaireModel(int armThickness) throws IllegalArgumentException {
    super(armThickness);
  }

  public EnglishSolitaireModel(int armThickness, int sRow, int sCol)
          throws IllegalArgumentException {
    super(armThickness, sRow, sCol);
  }
}
